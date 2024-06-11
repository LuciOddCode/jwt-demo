package lk.cmg.jwt.jwtdemo.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 Created by : Lucifer Morningstar
 Package : lk.cmg.jwt.jwtdemo.dto.responseDTO
 Date :6/11/2024
 Time : 10:03 AM
 Project : jwtdemo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private int id;
    private String username;
    private String role;
    private String jwt;
}
