package com.example.User;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class User {

    @Id
    private Integer userId;

    @Column
    private String firstname;

    @Column
    private  String lastname;

    @Column
    private String email;

}
