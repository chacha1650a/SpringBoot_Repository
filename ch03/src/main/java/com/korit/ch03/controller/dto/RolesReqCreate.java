package com.korit.ch03.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RolesReqCreate {
    private Long id;
    private String roleName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
