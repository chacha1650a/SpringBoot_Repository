package com.korit.ch01.controller.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class UserReqList {
    private String query;
    private String username;
    private String email;
}
