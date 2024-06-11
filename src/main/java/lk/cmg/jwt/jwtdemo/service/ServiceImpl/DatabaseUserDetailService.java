package lk.cmg.jwt.jwtdemo.service.ServiceImpl;

import lk.cmg.jwt.jwtdemo.entity.User;
import lk.cmg.jwt.jwtdemo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 Created by : Lucifer Morningstar
 Package : lk.cmg.wccmsbackend.service.impl
 Date :5/7/2024
 Time : 12:48 PM
 Project : wc-cms
 */
@Service
public class DatabaseUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public DatabaseUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
