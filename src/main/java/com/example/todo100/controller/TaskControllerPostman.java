package com.example.todo100.controller;


import com.example.todo100.service.TaskEntity;
import com.example.todo100.service.TaskForm;
import com.example.todo100.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskControllerPostman {
//
    private final TaskService taskService;
//
//    @GetMapping("/create")
//    public String showCreationForm(TaskForm form) {
//        return "CREATE";
//    }
//
//    @PostMapping
//    public void create( TaskForm form, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            showCreationForm(form);
//        }
//        taskService.create(form.toEntity());
//    }
//
//    @GetMapping
//    public List<TaskEntity> showTaskList() {
//        // 모든 작업 리스트를 가져옴
//        return taskService.findAll();
//    }

//    @GetMapping("/{id}/editForm")
//    public TaskForm showEditForm(@PathVariable("id") long id) {
//        return taskService.getTaskFormById(id);
//    }
//
//    @PostMapping("/{id}/update")
//    public void update(@PathVariable("id") long id,
//                       @Validated TaskForm taskform,
//                       BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            showEditForm(id);
//
//        }
//         taskService.update(taskform.toEntityId(id));
//    }

}
