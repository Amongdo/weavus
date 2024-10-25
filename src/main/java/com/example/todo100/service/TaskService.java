package com.example.todo100.service;

import com.example.todo100.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public Optional<TaskEntity> findById(long id) {
        return taskRepository.findById(id);
    }


    public List<TaskEntity> findByDatetime(String datetime) {
        return taskRepository.findByDatetime(datetime);
    }
    // 특정 날짜 또는 현재 날짜에 해당하는 작업을 조회
    public List<TaskEntity> getTasksByDate(String datetime) {
        if (datetime == null || datetime.isEmpty()) {
            datetime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return taskRepository.findByDatetime(datetime);
    }
    // 완료된 작업 수 계산
    public long countCompletedTasks(List<TaskEntity> tasks) {
        return tasks.stream().filter(task -> "DONE".equals(task.getStatus().name())).count();
    }

    // 전체 작업 수 계산
    public long countTotalTasks(List<TaskEntity> tasks) {
        return tasks.size();
    }

    // 달성률 계산
    public double calculateCompletionRate(List<TaskEntity> tasks) {
        long completedTasks = countCompletedTasks(tasks);
        long totalTasks = countTotalTasks(tasks);

        double completionRate = (totalTasks == 0) ? 0 : ((double) completedTasks / totalTasks) * 100;
        return Math.round(completionRate * 100.0) / 100.0;
    }

    public TaskForm getTaskFormById(long id) {
        return taskRepository.findById(id)
                .map(TaskForm::fromEntity)
                .orElseThrow(TaskNotFoundException::new);
    }
    public TaskDTO getTaskById(long taskId) {
        return taskRepository.findById(taskId)
                .map(TaskDTO::toDTO)
                .orElseThrow(TaskNotFoundException::new);
    }
    public void updateTaskStatus(long id, String status) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            TaskEntity task = optionalTask.get();
            task.setStatus(TaskStatus.valueOf(status));
            taskRepository.save(task);
        } else {
            throw new TaskNotFoundException();
        }
    }

}
