package com.example.todo100.controller;

import com.example.todo100.service.TaskEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import static com.mysql.cj.protocol.a.MysqlTextValueDecoder.getDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskForm {

    @Size(max = 256, message = "max font = 256")
    private String summary;
    private String description;
    private String datetime;

    public TaskEntity toEntityId(long id) {

        return new TaskEntity(
                id,
                getSummary(),
                getDescription(),
                getDatetime()
        );
    }

    public TaskEntity toEntity() {
        return new TaskEntity(
                null,
                getSummary(),
                getDescription(),
                getDatetime()

        );
    }

    public static TaskForm fromEntity(TaskEntity taskEntity) {
        return new TaskForm(
                taskEntity.getSummary(),
                taskEntity.getDescription(),
                taskEntity.getDatetime()
        );
    }
}

