package com.example.study.board.api.dto;

import lombok.Builder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record BoardCommandDto() {

    // CREATE, UPDATE, DELETE; READ(X)
    public record BoardAddRequsetDto(
            String title,
            String content
    ){}

    @Builder
    public record BoardAddResponseDto(
            boolean success
    ){}

    @Builder
    public record BoardDeleteResponseDto(
            boolean success
    ){}

    public record BoardUpdateRequestDto(
            String title,
            String content
    ){}

    @Builder
    public record BoardUpdateResponseDto(
            boolean success
    ){}
}
