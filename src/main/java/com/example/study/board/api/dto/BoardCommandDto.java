package com.example.study.board.api.dto;

import lombok.Builder;

public record BoardCommandDto() {

    // CREATE, UPDATE, DELETE; READ(X)

    // 게시글 추가 dto
    public record BoardCreateRequsetDto(
            String title,
            String content
    ){}

    @Builder
    public record BoardCreateResponseDto(
            boolean success
    ){}

    // 게시글 삭제 dto
    @Builder
    public record BoardDeleteResponseDto(
            boolean success
    ){}

    // 게시글 수정 dto
    public record BoardUpdateRequestDto(
            String title,
            String content
    ){}

    @Builder
    public record BoardUpdateResponseDto(
            boolean success
    ){}
}
