package com.example.todo100.service;

import com.example.todo100.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public List<TaskEntity> findall() {
        return taskRepository.findAll();
    }

    @Transactional
    public void update(TaskEntity entity) {
        taskRepository.save(entity);
    }
    @Transactional
    public void delete(long id) {
        taskRepository.deleteById(id);
    }
    @Transactional
    public void create(TaskEntity newEntity) {
        taskRepository.save(newEntity);
    }

    public Optional<TaskEntity> findById(long taskId) {
        return taskRepository.findById(taskId);
    }
}
