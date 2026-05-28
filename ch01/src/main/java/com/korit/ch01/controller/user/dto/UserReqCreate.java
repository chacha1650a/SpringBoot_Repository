package com.korit.ch01.controller.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "UserReqCreate",
        description = """
            사용자 <u>정보 등록</u>시 사용하는 요청 모델입니다.
            모든 필드는 <u>필수 값</u>입니다.
        """
)
public record UserReqCreate(
        @Schema(
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "testuser1234",
                description = "사용자 등록 시 사용자 이름으로 사용되는 필드입니다."
        )
        String username,
        @Schema(
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "password1234",
                description = "사용자 등록 시 비밀번호로 사용되는 필드입니다."
        )
        String password,
        @Schema(
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "example@gmail.com",
                description = "사용자 등록 시 이메일로 사용되는 필드입니다."
        )
        String email
) {}