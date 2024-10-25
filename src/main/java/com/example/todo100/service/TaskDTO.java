package com.example.todo100.service;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {

    private Long id;
    @NotBlank
    private String summary;
    private String description;
    @NotBlank
    private String datetime;
    private LocalTime time;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private String color;



    public static TaskDTO toDTO(TaskEntity entity) {
        return new TaskDTO(
                entity.getId(),
                entity.getSummary(),
                entity.getDescription(),
                entity.getDatetime(),
                entity.getTime(),
                entity.getStatus(),
                entity.getColor()
                );

    }
}