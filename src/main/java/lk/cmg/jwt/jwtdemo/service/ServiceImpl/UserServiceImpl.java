package lk.cmg.jwt.jwtdemo.service.ServiceImpl;

import lk.cmg.jwt.jwtdemo.dto.UserDTO;
import lk.cmg.jwt.jwtdemo.dto.UserRequestDTO;
import lk.cmg.jwt.jwtdemo.dto.responseDTO.LoginResponseDTO;
import lk.cmg.jwt.jwtdemo.entity.User;
import lk.cmg.jwt.jwtdemo.repository.UserRepo;
import lk.cmg.jwt.jwtdemo.service.UserService;
import lk.cmg.jwt.jwtdemo.util.JWTUtil;
import lk.cmg.jwt.jwtdemo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 Created by : Lucifer Morningstar
 Package : lk.cmg.jwt.jwtdemo.service.ServiceImpl
 Date :6/11/2024
 Time : 9:59 AM
 Project : jwtdemo
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder userPasswordEncorder;

    @Autowired
    private JWTUtil jwtUtil;


    public UserDTO getUser(String username) {
        Optional<User> byId = userRepo.findByUsername(username);
        if (byId.isEmpty()) {
            return null;
        } else {
            User user = byId.get();
            UserDTO userDTO = new UserDTO(user.getId(),user.getUsername(), user.getPassword(),user.getRole(), user.getStatus());
            System.err.println(userDTO);
            return userDTO;
        }
    }

    @Override
    public ResponseEntity<?> login(UserRequestDTO userDTO) {
        System.out.println("userDTO = " + userDTO);
        UserDTO userInDB = getUser(userDTO.getUsername());

        DatabaseUserDetailService databaseUserDetailService = new DatabaseUserDetailService(userRepo);

        if (userInDB != null) {
            boolean isPasswordMatched=checkPassword(userDTO.getPassword(),userInDB.getPassword());

            if (isPasswordMatched){
                final UserDetails userDetails = databaseUserDetailService.loadUserByUsername(userDTO.getUsername());

                System.err.println("userDetails = " + userDetails);

                final String jwt = jwtUtil.generateToken(userDetails);
                System.out.println("jwt = " + jwt);

                User user = loadUserByUsername(userDTO.getUsername());

                return ResponseEntity.ok(new LoginResponseDTO(user.getId(),user.getUsername(),user.getRole(), jwt));
            }
        }

        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    private User loadUserByUsername(String username) {

        UserDTO user = getUser(username);
        System.err.println("loadUserByUserName" + user);

        if (user == null||user.getStatus()==0) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }else if (user.getStatus()==1){
            return new User(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), user.getStatus());
        }else {
            return null;
        }
    }


    private boolean checkPassword(String password, String password1) {
        return userPasswordEncorder.matches(password, password1);
    }

    public ResponseUtil passwordGenerator(String password) {
        String encode = userPasswordEncorder.encode(password);

        return new ResponseUtil("200", "Encoded", encode);

    }
}