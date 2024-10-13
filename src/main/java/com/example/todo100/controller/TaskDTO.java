package com.example.todo100.controller;

import com.example.todo100.service.TaskEntity;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {

    long id;

    private String summary;
    private String description;
    private String datetime;



    public static TaskDTO toDTO(TaskEntity entity) {
        return new TaskDTO(
                entity.getId(),
                entity.getSummary(),
                entity.getDescription(),
                entity.getDatetime()
                );

    }
}