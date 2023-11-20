package com.dreamscape.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DreamDTO {

    @Id
    private Integer id;

    private Integer userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy", locale = "en")
    private Date dateCreate;

    private String title;

    private String description;

    public static DreamDTO fromEntity(Dream dream){
        return DreamDTO.builder()
                .id(dream.getId())
                .userId(dream.getUserId())
                .dateCreate(dream.getDateCreate())
                .title(dream.getTitle())
                .description(dream.getDescription())
                .build();
    }

    public static Dream toEntity(DreamDTO dreamDTO){
        return Dream.builder()
                .id(dreamDTO.getId())
                .userId(dreamDTO.getUserId())
                .dateCreate(dreamDTO.getDateCreate())
                .title(dreamDTO.getTitle())
                .description(dreamDTO.getDescription())
                .build();
    }
}
