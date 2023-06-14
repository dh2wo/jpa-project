package com.example.study.board.service;

import com.example.study.board.api.dto.BoardQueryDto.BoardQueryResponseDto;
import com.example.study.board.repository.projection.BoardListProjection;
import com.example.study.board.type.SearchType;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BoardQueryServcie {
//    List<board> all();

//    List<BoardListProjection> readList();

    List<BoardListProjection> findByBoardNum(Long boardNum);

    List<BoardListProjection> findByMemberId(HttpServletRequest request);

    BoardQueryResponseDto findBoardList(Pageable pageable, String keyword, SearchType searchType);
}
