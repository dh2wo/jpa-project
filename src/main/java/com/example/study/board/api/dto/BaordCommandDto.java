package com.example.study.board.api.dto;

import lombok.Builder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record BaordCommandDto() {

    // CREATE, UPDATE, DELETE; READ(X)
    public record BoardAddRequsetDto(
//            @GeneratedValue(strategy = GenerationType.AUTO)
            Long boardNum,
            String boardTitle,
            String boardContent
    ){}

    @Builder
    public record BoardAddResponseDto(
            boolean success
    ){}
}
