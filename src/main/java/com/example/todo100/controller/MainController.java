package com.example.todo100.controller;

import com.example.todo100.service.TaskEntity;
import com.example.todo100.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Controller
@RequiredArgsConstructor
public class MainController {

    private final TaskService taskService;

    @GetMapping("/")
    public String index(@RequestParam(value = "datetime", required = false) String datetime, Model model) {
        List<TaskEntity> home;
        if (datetime != null && !datetime.isEmpty()) {
            // 사용자가 특정 날짜를 선택한 경우, 해당 날짜에 맞는 데이터를 조회
            home = taskService.findByDatetime(datetime);
        } else {
            // 사용자가 날짜를 선택하지 않은 경우, 현재 날짜를 기본으로 데이터를 조회
            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            home = taskService.findByDatetime(currentDate);
        }
        model.addAttribute("home", home);
        return "index";
    }



}



    //API  형식. 객체를 리턴하게 될 땐, 제이슨방식으로 출력해줌
//    @GetMapping("abd")
//    @ResponseBody
//    public Hello helloApi(@RequestParam("name") String name) {
//        Hello hello = new Hello();
//        hello.setName(name);
//        return hello;
//    }
//
//    static class Hello {
//        private String name;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }



//