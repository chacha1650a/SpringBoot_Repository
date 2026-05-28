package com.korit.example.ex01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Member {
    private Long memberId;
    private String name;
    private String phone;
    private String email;

    public Long findById() {
        return memberId;
    }
}
