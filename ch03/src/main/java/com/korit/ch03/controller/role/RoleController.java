package com.korit.ch03.controller.role;

import com.korit.ch03.controller.dto.ApiResponse;
import com.korit.ch03.controller.dto.RoleResp;
import com.korit.ch03.controller.dto.RolesReqCreate;
import com.korit.ch03.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody RolesReqCreate dto) {
        roleService.create(dto);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RoleResp>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok(roleService.getAll()));
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<ApiResponse<RoleResp>> getOne(@PathVariable Long roleId) {
        return ResponseEntity.ok(ApiResponse.ok(roleService.getOne(roleId)));
    }
}
