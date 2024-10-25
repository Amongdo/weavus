package com.example.todo100.service;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskForm {

    private String summary;
    private String description;
    private String datetime;
    private LocalTime time;
    @Enumerated(EnumType.STRING)
    private TaskStatus status= TaskStatus.IN_PROGRESS;
    private String color;


    public TaskEntity toEntityId(long id) {

        return new TaskEntity(
                id,
                getSummary(),
                getDescription(),
                getDatetime(),
                getTime(),
                getStatus(),
                getColor()
        );
    }

    public TaskEntity toEntity() {
        return new TaskEntity(
                null,
                getSummary(),
                getDescription(),
                getDatetime(),
                getTime(),
                getStatus(),
                getColor()
        );
    }

    public static TaskForm fromEntity(TaskEntity taskEntity) {
        return new TaskForm(
                taskEntity.getSummary(),
                taskEntity.getDescription(),
                taskEntity.getDatetime(),
                taskEntity.getTime(),
                taskEntity.getStatus(),
                taskEntity.getColor()
        );
    }

    public void setHourAndMinute(int hour, int minute) {
        this.time = LocalTime.of(hour, minute);
    }
}

