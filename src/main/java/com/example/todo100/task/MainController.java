package com.example.todo100.task;

import com.example.todo100.service.task.TaskEntity;
import com.example.todo100.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final TaskService taskService;

    @GetMapping("/")
    public String index(Model model) {
        List<TaskEntity> home = taskService.findAll();
        model.addAttribute("home", home);
        return "index";
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
}


//