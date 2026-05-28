package com.korit.ch01.controller.board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(
        name = "BoardReqCreate",
        description = """
            게시글 <u>정보 등록</u>시 사용하는 요청 모델입니다.
            모든 필드는 <u>필수 값</u>입니다.
        """
)
public class BoardReqCreate {
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1",
            description = "게시글 등록 시 게시글 번호로 사용되는 필드입니다."
    )
    private String boardId;
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "제목",
            description = "게시글 등록 시 게시글 제목으로 사용되는 필드입니다."
    )
    private String title;
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "김대훈",
            description = "게시글 등록 시 게시글 글쓴이로 사용되는 필드입니다."
    )
    private String author;
    @Schema(
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "간단한 내용",
            description = "게시글 등록시 게시글 내용로 사용되는 필드입니다."
    )
    private String content;
}
