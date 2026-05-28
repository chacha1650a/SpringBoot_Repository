package com.korit.ch01.controller.board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "Board",
        description = "게시판 관련 정보 API에서 공통적으로 사용하는 응답 모델입니다."
)
public class BoardResp {
    @Schema(
            example = "1",
            description = "게시글 고유 번호(PK)"
    )
    private int boardId;
    @Schema(
            example = "제목",
            description = "- 제목"
    )
    private String title;
    @Schema(
            example = "김대훈",
            description = "- 글쓴이"
    )
    private String author;
    @Schema(
            example = "간단한 내용",
            description = "내용"
    )
    private String content;
    @Schema(
            description = "업로드 일시"
    )
    private LocalDateTime uploadAt;
    @Schema(
            description = "수정 일시"
    )
    private LocalDateTime updateAt;
}
