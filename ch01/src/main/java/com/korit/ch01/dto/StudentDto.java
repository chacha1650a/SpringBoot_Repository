package com.korit.ch01.dto;

import org.springframework.web.bind.annotation.*;

public record StudentDto(
        String name,
        int age
) {}


