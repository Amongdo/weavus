package com.example.todo100.controller;

import com.example.todo100.service.TaskEntity;
import com.example.todo100.service.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {

    long id;
    @NotBlank
    private String summary;
    private String description;
    @NotBlank
    private String datetime;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;



    public static TaskDTO toDTO(TaskEntity entity) {
        return new TaskDTO(
                entity.getId(),
                entity.getSummary(),
                entity.getDescription(),
                entity.getDatetime(),
                entity.getStatus()
                );

    }
}