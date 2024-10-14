package com.example.todo100.service;

import com.example.todo100.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }


    public void update(TaskEntity entity) {
        taskRepository.save(entity);
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }

    public void create(TaskEntity newEntity) {
        taskRepository.save(newEntity);
    }

    public Optional<TaskEntity> findById(long taskId) {
        return taskRepository.findById(taskId);
    }


    public List<TaskEntity> findByDatetime(String datetime) {
        return taskRepository.findByDatetime(datetime);
    }

    public TaskEntity save(TaskEntity task) {
        return taskRepository.save(task);
    }
}
