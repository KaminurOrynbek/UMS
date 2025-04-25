package com.kaminur.ums.dto;

import com.kaminur.ums.model.Role;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
}