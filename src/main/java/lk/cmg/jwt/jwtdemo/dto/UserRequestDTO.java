package lk.cmg.jwt.jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 Created by : Lucifer Morningstar
 Package : lk.cmg.jwt.jwtdemo.dto.responseDTO
 Date :6/11/2024
 Time : 10:17 AM
 Project : jwtdemo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequestDTO {
    private String username;
    private String password;
}
