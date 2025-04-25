package com.kaminur.ums.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
}