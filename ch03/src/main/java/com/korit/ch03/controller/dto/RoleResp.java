package com.korit.ch03.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class RoleResp {
    private Long id;
    private String roleName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
