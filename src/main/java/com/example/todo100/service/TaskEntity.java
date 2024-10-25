package com.example.todo100.service;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String description;
    private String datetime;
    private LocalTime time;
    @Enumerated(EnumType.STRING)
    private TaskStatus status; // 새로운 status 필드 추가
    private String color;
}
