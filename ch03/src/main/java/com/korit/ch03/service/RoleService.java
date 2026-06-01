package com.korit.ch03.service;

import com.korit.ch03.controller.dto.RoleResp;
import com.korit.ch03.controller.dto.RolesReqCreate;
import com.korit.ch03.entity.Role;
import com.korit.ch03.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleMapper roleMapper;

    public RoleResp create(RolesReqCreate dto) {
        Role newRole = Role.builder()
                .id(dto.getId())
                .roleName(dto.getRoleName())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();

        roleMapper.insert(newRole);

        return RoleResp.builder()
                .id(dto.getId())
                .roleName(dto.getRoleName())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
