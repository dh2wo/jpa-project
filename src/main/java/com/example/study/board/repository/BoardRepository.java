package com.example.study.board.repository;

import com.example.study.board.domain.Board;
import com.example.study.board.repository.projection.BoardListProjection;
import com.example.study.board.type.SearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByBoardNum(Integer boardNum);
    // findAllProjectedBy(): Spring Data JPA의 기능 중 하나인 프로젝션(Projection)을 사용하여
    // 원하는 필드만 선택적으로 조회할 수 있는 기능을 제공합니다.
    List<BoardListProjection> findProjectedBy();
    List<BoardListProjection> findProjectedByMemberId(UUID memberId);
    Page<Board> findAll(Pageable pageable);

    // 페이지
    Page<Board> findAllByTitleContainsIgnoreCase(String keyword, Pageable pageable);

    Page<Board> findAllByContentContainsIgnoreCase(String keyword, Pageable pageable);

    Page<Board> findAllByNicknameContainsIgnoreCase(String keyword, Pageable pageable);

    Page<Board> findAllByBoardNum(long boardNum, Pageable pageable);
    

    // boardNum 존재 여부
    boolean existsByBoardNum(Integer boardNum);

    int deleteByBoardNum(Integer boardNum);

}
