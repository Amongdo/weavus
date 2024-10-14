package com.example.todo100.controller;

import com.example.todo100.service.TaskEntity;
import com.example.todo100.service.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskForm {

    private String summary;
    private String description;
    private String datetime;
    @Enumerated(EnumType.STRING)
    private TaskStatus status= TaskStatus.IN_PROGRESS;

    public TaskEntity toEntityId(long id) {

        return new TaskEntity(
                id,
                getSummary(),
                getDescription(),
                getDatetime(),
                getStatus()
        );
    }

    public TaskEntity toEntity() {
        return new TaskEntity(
                null,
                getSummary(),
                getDescription(),
                getDatetime(),
                getStatus()
        );
    }

    public static TaskForm fromEntity(TaskEntity taskEntity) {
        return new TaskForm(
                taskEntity.getSummary(),
                taskEntity.getDescription(),
                taskEntity.getDatetime(),
                taskEntity.getStatus()
        );
    }
}

