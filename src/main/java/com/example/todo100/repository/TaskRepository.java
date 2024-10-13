package com.example.todo100.repository;
import com.example.todo100.service.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByDatetime(String datetime);
}
