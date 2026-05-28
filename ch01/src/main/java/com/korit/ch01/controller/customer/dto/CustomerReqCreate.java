package com.korit.ch01.controller.customer.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "CustomerReqCreate",
        description = """
            고객 <u>정보 등록</u>시 사용하는 요청 모델입니다.
            모든 필드는 <u>필수 값</u>입니다.
        """
)
public record CustomerReqCreate(
        @Schema(
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "1",
                description = "고객 등록 시 고유 식별자 번호(PK)로 사용되는 필드입니다."
        )
        int userId,
        @Schema(
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "testName",
                description = "고객 등록 시 이름으로 사용되는 필드입니다."
        )
        String name,
        @Schema(
                requiredMode = Schema.RequiredMode.REQUIRED,
                example = "testuser1234",
                description = "고객 등록 시 전화번호로 사용되는 필드입니다."
        )
        String phoneE164
) {}
