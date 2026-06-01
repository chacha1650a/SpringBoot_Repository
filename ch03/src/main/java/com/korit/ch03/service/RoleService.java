package com.korit.ch03.service;

import com.korit.ch03.controller.dto.RoleResp;
import com.korit.ch03.controller.dto.RolesReqCreate;
import com.korit.ch03.entity.Role;
import com.korit.ch03.exception.DuplicatedException;
import com.korit.ch03.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleMapper roleMapper;

    public void create(RolesReqCreate dto) {
        Role foundRole = roleMapper.selectByRoleName(dto.getRoleName());

        if (foundRole != null) {
            throw new DuplicatedException("roleName이 중복입니다.", "roleName", dto.getRoleName());
        }

        Role newRole = Role.builder()
                .roleName(dto.getRoleName())
                .build();

        roleMapper.insert(newRole);

    }

    public List<RoleResp> getAll() {
        List<Role> roles = roleMapper.selectAll();
        return roles.stream()
                .map(role -> RoleResp.builder()
                        .roleName(role.getRoleName())
                        .createdAt(role.getCreatedAt())
                        .updatedAt(role.getUpdatedAt())
                        .build())
                .toList();
    }

    public RoleResp getOne(Long roleId) {
        Role role = roleMapper.selectById(roleId);
        return RoleResp.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .build();
    }
}
