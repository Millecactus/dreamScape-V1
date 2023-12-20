package com.example.User;


import jakarta.persistence.*;

import lombok.*;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class UserDto {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;

    @MonotonicNonNull
    private String firstname;

    @MonotonicNonNull
    private String lastname;

    @MonotonicNonNull
    private String email;

    @MonotonicNonNull
    private String password;


//méthode de comparaison entre le password stocké en db et celui donné
//    public boolean checkPassword(String password) {
//        String hashedInputPassword = hashPassword(password);
//        return this.passwordHash.equals(hashedInputPassword);
//    }


    public UserDto fromEntity(User user) {
        if (user == null) {
            throw new IllegalArgumentException("L'objet User est null");
        }
        return UserDto.builder()
                .userId((user.getUserId()))
                .firstname(user.getFirstname())
                .lastname((user.getLastname()))
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("L'objet UserDto est null");
        }
        return User.builder()
                .userId((userDto.getUserId()))
                .firstname(userDto.getFirstname())
                .lastname((userDto.getLastname()))
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }

    public boolean checkPassword(String password) {

        if (!password.isEmpty()) {
            if (password.equals(getPassword())) {
                System.out.print("true ");
                return true;
            }
        }
        System.out.print("false");
        return false;
    }
}



