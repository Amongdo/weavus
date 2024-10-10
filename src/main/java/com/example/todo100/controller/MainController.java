package com.example.todo100.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("create","생성페이지");
        return "create";
    }

    @GetMapping("edit")
    public String edit(Model model){
        model.addAttribute("edit","편집페이지");
        return "edit";
    }
    @GetMapping("delete")
    public String delete(Model model){
        model.addAttribute("delete","삭제페이지");
        return "delete";
    }
}
