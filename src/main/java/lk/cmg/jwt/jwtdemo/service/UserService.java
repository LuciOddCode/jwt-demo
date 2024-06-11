package lk.cmg.jwt.jwtdemo.service;

import lk.cmg.jwt.jwtdemo.dto.UserRequestDTO;
import lk.cmg.jwt.jwtdemo.util.ResponseUtil;
import org.springframework.http.ResponseEntity;

/**
 Created by : Lucifer Morningstar
 Package : lk.cmg.jwt.jwtdemo.service
 Date :6/11/2024
 Time : 9:58 AM
 Project : jwtdemo
 */
public interface UserService {
    ResponseEntity<?> login(UserRequestDTO userDTO);
    ResponseUtil passwordGenerator(String password);
}
