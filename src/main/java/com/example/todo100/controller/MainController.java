package com.example.todo100.controller;

import com.example.todo100.service.TaskEntity;
import com.example.todo100.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
@Controller
@RequiredArgsConstructor
public class MainController {

    private final TaskService taskService;

    @GetMapping("/")
    public String index(@RequestParam(value = "datetime", required = false) String datetime, Model model) {
        // 서비스에서 작업 목록을 가져옴
        List<TaskEntity> home = taskService.getTasksByDate(datetime);
        // 서비스에서 달성률을 계산
        double completionRate = taskService.calculateCompletionRate(home);

        //현재시간
        LocalTime currentTime = LocalTime.now();
        //설정시간과 현재시간의 차이 계산
        home.forEach(task -> {
            LocalTime taskTime = task.getTime();
            if (taskTime != null) {
                //시간 차이를 구함
                Duration duration = Duration.between(currentTime, taskTime);
                long hours = Math.abs(duration.toHours());
                //구간에 따른 클래스명 설정
                String tm;
                if (hours < 0) {
                    tm = "gray"; // 과거 시간 (음수일 때)
                } else if (hours == 0) {
                    tm = "red"; // 1시간 이내 (0 시간)
                } else if (hours >= 1 && hours < 5) {
                    tm = "orange"; // 1시간 ~ 5시간
                } else {
                    tm = ""; // 기본값
                }
                task.setColor(tm);
            }
        });
        // 모델에 작업 목록과 달성률 추가
        model.addAttribute("home", home);
        model.addAttribute("completionRate", completionRate);
        return "index";
    }
}
