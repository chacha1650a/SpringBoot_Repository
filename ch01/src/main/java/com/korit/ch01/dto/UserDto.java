package com.korit.ch01.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public record UserDto(String username,
                      String password,
                      String name,
                      String email)
{
    @GetMapping("/api/userdto")
    @ResponseBody
    public UserDto UserDto() {
        return new UserDto("chacha1650a", "1234", "김대훈", "01058797023a@gmail.com");
    }
}
