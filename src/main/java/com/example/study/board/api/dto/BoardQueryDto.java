package com.example.study.board.api.dto;

import com.example.study.board.domain.Board;
import lombok.Builder;
import org.springframework.data.domain.Page;

import java.util.List;

public record BoardQueryDto() {
    // READ만

    @Builder
    public record BoardQueryResponseDto(
            List<Board> boardList,
            Long lastPage
    ){}

}
