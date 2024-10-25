package com.example.todo100.controller;

import com.example.todo100.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
//@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/create")
    public String showCreationForm(@ModelAttribute TaskForm form, Model model) {
        model.addAttribute("mode", "CREATE");
        return "form";
    }


    @PostMapping
    public String create(@Validated TaskForm form, BindingResult bindingResult,
                         @RequestParam(value = "hour", required = false) int hour,
                         @RequestParam(value = "minute", required = false) int minute,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form, model);
        }
        form.setHourAndMinute(hour, minute);
        taskService.create(form.toEntity());
        return "redirect:/";
    }



    @GetMapping
    public String showTaskList(Model model) {
        List<TaskEntity> tasks = taskService.findAll(); // 모든 작업 리스트를 가져옴
        model.addAttribute("tasks", tasks);
        return "redirect:/";
    }



        @GetMapping("/{id}/editForm")
        public String showEditForm(@PathVariable("id") long id, Model model) {
            TaskForm form = taskService.getTaskFormById(id);
            model.addAttribute("taskForm", form);
            model.addAttribute("mode", "EDIT");
            return "form";
        }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") long id,
                         @Validated @ModelAttribute TaskForm form,
                         BindingResult bindingResult,
                         @RequestParam(value = "hour", required = false) int hour,
                         @RequestParam(value = "minute", required = false) int minute,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mode", "EDIT");
            return "form";
        }
        form.setHourAndMinute(hour, minute);
        taskService.update(form.toEntityId(id));
        return "redirect:/";
    }

    @PostMapping ("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        taskService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable("id") long id, Model model) {
        Optional<TaskEntity> optionalTask = taskService.findById(id);
        // TaskEntity가 있으면 값을 전달하고, 없으면 빈 객체를 전달
        TaskEntity task = optionalTask.orElseGet(TaskEntity::new);  // 값이 없으면 빈 TaskEntity 생성
        model.addAttribute("task", task);  // 모델에 task 전달

        return "/detail";  // detail 페이지로 이동
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam Long id, @RequestParam String status,
                               @RequestParam(value = "datetime", required = false) String datetime) {

        taskService.updateTaskStatus(id, status);
        return (datetime != null) ? "redirect:/?datetime=" + datetime : "redirect:/";
        }
    }



