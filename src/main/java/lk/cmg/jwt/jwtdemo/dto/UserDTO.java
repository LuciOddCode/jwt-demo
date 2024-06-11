package lk.cmg.jwt.jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String role;
    private int status;

}