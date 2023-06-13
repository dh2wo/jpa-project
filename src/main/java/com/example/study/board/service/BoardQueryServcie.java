package com.example.study.board.service;

import com.example.study.board.repository.projection.BoardListProjection;

import java.util.List;

public interface BoardQueryServcie {
//    List<board> all();

    List<BoardListProjection> all();
}
