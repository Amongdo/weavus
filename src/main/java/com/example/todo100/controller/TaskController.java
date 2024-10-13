package com.example.todo100.controller;

import com.example.todo100.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
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
    public String create(@Validated TaskForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form, model);
        }
        taskService.create(form.toEntity());
        return "redirect:/";
    }

    @GetMapping("/{id}/editForm")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Optional<TaskForm> form = Optional.ofNullable(taskService.findById(id)
                .map(TaskForm::fromEntity)
                .orElseThrow(TaskNotFoundException::new));
        model.addAttribute("taskForm", form);
        model.addAttribute("mode", "EDIT");
        return "form";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") long id,
                         @Validated @ModelAttribute TaskForm taskform,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mode", "EDIT");
            return "form";
        }
        taskService.update(taskform.toEntityId(id));
        return "redirect:/";
    }

    @PostMapping ("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        taskService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showDetail(@PathVariable("id") long taskId, Model model) {
        TaskDTO taskDTO = taskService.findById(taskId)
                .map(TaskDTO::toDTO)
                .orElseThrow(TaskNotFoundException::new);
        model.addAttribute("task", taskDTO);
        return "/detail";
    }

}
