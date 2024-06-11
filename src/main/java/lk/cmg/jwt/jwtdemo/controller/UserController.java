package lk.cmg.jwt.jwtdemo.controller;

import lk.cmg.jwt.jwtdemo.dto.UserRequestDTO;
import lk.cmg.jwt.jwtdemo.service.UserService;
import lk.cmg.jwt.jwtdemo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 Created by : Lucifer Morningstar
 Package : lk.cmg.jwt.jwtdemo.controller
 Date :6/11/2024
 Time : 9:32 AM
 Project : jwtdemo
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO userRequestDTO) {
        System.out.println("userRequestDTO = " + userRequestDTO);
        return userService.login(userRequestDTO);
    }

    @GetMapping("/get-encoder/{password}")
    public ResponseUtil getEncoder(@PathVariable String password) {
        ResponseUtil responseUtil = userService.passwordGenerator(password);
        return responseUtil;
    }
}
