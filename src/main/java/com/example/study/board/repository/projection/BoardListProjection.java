package com.example.study.board.repository.projection;

import com.example.study.board.domain.Board;

import java.time.OffsetDateTime;
import java.util.List;

public record BoardListProjection(
        Integer boardNum,
        String title,
        String content,
        OffsetDateTime createAt
) {}
