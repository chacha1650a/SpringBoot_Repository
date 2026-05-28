package com.korit.ch01.controller.board.dto;

import lombok.Data;

@Data
public class BoardReqList {
    private String title;
    private String author;
    private String content;
}
