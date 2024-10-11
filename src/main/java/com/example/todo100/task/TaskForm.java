package com.example.todo100.task;

import com.example.todo100.service.task.TaskEntity;
import jakarta.validation.constraints.NotBlank;
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

