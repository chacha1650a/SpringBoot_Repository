package com.korit.ch04api.service;

import com.korit.ch04api.dto.AuthUserCreateRequest;
import com.korit.ch04api.dto.AuthUserResponse;
import com.korit.ch04api.dto.CreateResponse;
import com.korit.ch04api.entity.User;
import com.korit.ch04api.common.exception.DuplicatedException;
import com.korit.ch04api.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public CreateResponse authCreate(AuthUserCreateRequest dto) {

        User foundUser = userMapper.selectByUsername(dto.getUsername());

        if (foundUser != null) {
            // 필드 중복 처리
            throw new DuplicatedException("이미 존재하는 사용자 이름입니다.", "username", dto.getUsername());
        }

        User userEntity = dto.toUser();
        userMapper.insert(userEntity);

        return CreateResponse.builder()
                .domainName("유저")
                .createdIds(List.of(userEntity.getId()))
                .build();
    }

    public AuthUserResponse getOne(String username) {
        User user = userMapper.selectByUsername(username);
        return AuthUserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
