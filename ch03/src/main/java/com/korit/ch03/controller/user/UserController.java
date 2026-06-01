package com.korit.ch03.controller.user;

import com.korit.ch03.controller.dto.UserReqCreate;
import com.korit.ch03.controller.dto.UserResp;
import com.korit.ch03.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResp> create(@RequestBody UserReqCreate dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

}
