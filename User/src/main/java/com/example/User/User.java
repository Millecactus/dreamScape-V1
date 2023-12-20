package com.example.User;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;

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

    @Column
    private String password;


}
