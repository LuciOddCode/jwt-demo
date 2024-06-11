package lk.cmg.jwt.jwtdemo.repository;

import lk.cmg.jwt.jwtdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 Created by : Lucifer Morningstar
 Package : lk.cmg.jwt.jwtdemo.repository
 Date :6/11/2024
 Time : 9:58 AM
 Project : jwtdemo
 */

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
