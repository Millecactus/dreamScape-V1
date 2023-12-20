
package com.example.User;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table

public class Dream {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private Integer userId;

    private Date dateCreate;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;



}
