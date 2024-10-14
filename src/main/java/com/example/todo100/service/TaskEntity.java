package com.example.todo100.service;

import jakarta.persistence.*;
import lombok.*;

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
    @Enumerated(EnumType.STRING)
    private TaskStatus status; // 새로운 status 필드 추가
//    private boolean completed;

}
