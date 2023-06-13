package com.example.study.board.repository;

import com.example.study.board.domain.Board;
import com.example.study.board.repository.projection.BoardListProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    List<Board> findAll();

    // findAllProjectedBy(): Spring Data JPA의 기능 중 하나인 프로젝션(Projection)을 사용하여
    // 원하는 필드만 선택적으로 조회할 수 있는 기능을 제공합니다.
    List<BoardListProjection> findAllProjectedBy();

    // boardNum 존재 여부
    boolean existsByBoardNum(Integer boardNum);

    int deleteByBoardNum(Integer boardNum);

    Board findByBoardNum(Integer boardNum);

}
