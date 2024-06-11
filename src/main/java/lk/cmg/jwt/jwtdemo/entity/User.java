package lk.cmg.jwt.jwtdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 Created by : Lucifer Morningstar
 Package : lk.cmg.jwt.jwtdemo.entity
 Date :6/11/2024
 Time : 9:57 AM
 Project : jwtdemo
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;
    String role;
    int status;
}
