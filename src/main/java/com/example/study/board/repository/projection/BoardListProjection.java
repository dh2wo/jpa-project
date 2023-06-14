package com.example.study.board.repository.projection;

import com.example.study.board.domain.Board;

import java.time.OffsetDateTime;
import java.util.List;

//프로젝션은 데이터베이스 쿼리 결과에서 원하는 필드 또는 컬럼만을 선택적으로 조회하는 것 + 다중 조인 결과 추출
public record BoardListProjection(
        Integer boardNum,
        String nickname,
        String title,
        String content,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        OffsetDateTime deletedAt
) {}
