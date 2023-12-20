package com.example.User;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class UserDto {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;
    private String firstname;
    private  String lastname;
    private String email;


    public UserDto fromEntity(User user){
        if(user==null){
            throw new IllegalArgumentException("L'objet User est null");
        }
        return UserDto.builder()
                .userId((user.getUserId()))
                .firstname(user.getFirstname())
                .lastname((user.getLastname()))
                .email(user.getEmail())
                .build();
    }

    public User toEntity(UserDto userDto){
        if(userDto==null){
            throw new IllegalArgumentException("L'objet UserDto est null");
        }
        return User.builder()
                .userId((userDto.getUserId()))
                .firstname(userDto.getFirstname())
                .lastname((userDto.getLastname()))
                .email(userDto.getEmail())
                .build();
    }
}
