package com.kaminur.ums.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
}