package com.korit.ch01.controller.board;

import com.korit.ch01.controller.board.dto.BoardRepUpdate;
import com.korit.ch01.controller.board.dto.BoardReqCreate;
import com.korit.ch01.controller.board.dto.BoardReqList;
import com.korit.ch01.controller.board.dto.BoardResp;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping("/api/boards")
@Tag(name = "Board", description = "게시글 등록 / 조회 / 수정 / 삭제")
public class BoardController {

    @PostMapping
    public ResponseEntity<BoardResp> create(@RequestBody BoardReqCreate dto) {
        return ResponseEntity.ok(new BoardResp(1, "제목", "글쓴이", "내용", LocalDateTime.now(), LocalDateTime.now()));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResp> list(BoardReqList dto) {
        System.out.println(dto.getTitle());
        System.out.println(dto.getAuthor());
        System.out.println(dto.getContent());
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResp> update(@RequestBody BoardRepUpdate dto) {
        System.out.println(dto);
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<BoardResp> modify(@RequestBody BoardRepUpdate dto) {
        System.out.println(dto);
        return ResponseEntity.ok(null);
    }
}
