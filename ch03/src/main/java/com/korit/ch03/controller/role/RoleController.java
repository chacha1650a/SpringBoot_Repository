package com.korit.ch03.controller.role;

import com.korit.ch03.controller.dto.RoleResp;
import com.korit.ch03.controller.dto.RolesReqCreate;
import com.korit.ch03.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResp> create(@RequestBody RolesReqCreate dto) {
        return ResponseEntity.ok(roleService.create(dto));
    }
}
