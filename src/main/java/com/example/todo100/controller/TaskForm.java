package com.example.todo100.controller;

import com.example.todo100.service.TaskEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskForm {
    @NotBlank
    @Size(max = 256, message = "max font = 256")
    private String summary;

    @NotBlank
    private String description;

    public TaskEntity toEntityId(long id) {

        return new TaskEntity(
                id,
                getSummary(),
                getDescription()
        );
    }

    public TaskEntity toEntity() {
        return new TaskEntity(
                null,
                getSummary(),
                getDescription()
        );
    }

    public static TaskForm fromEntity(TaskEntity taskEntity) {
        return new TaskForm(
                taskEntity.getSummary(),
                taskEntity.getDescription()
        );
    }
}

