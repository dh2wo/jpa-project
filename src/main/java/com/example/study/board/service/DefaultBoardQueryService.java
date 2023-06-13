package com.example.study.board.service;

import com.example.study.board.repository.BoardRepository;
import com.example.study.board.repository.projection.BoardListProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBoardQueryService implements BoardQueryServcie {

    private final BoardRepository boardRepository;

//    @Override
//    public List<Board> all() {
//        return boardRepository.findAll();
//    }

    @Override
    public List<BoardListProjection> all() {
        return boardRepository.findAllProjectedBy();
    }
}
