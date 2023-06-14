package com.example.study.board.service;

import com.example.study.board.api.dto.BoardCommandDto.*;

import javax.servlet.http.HttpServletRequest;

public interface BoardCommandService {
    BoardCreateResponseDto create(BoardCreateRequsetDto dto, HttpServletRequest request);

    BoardDeleteResponseDto delete(Integer boardNum);

    BoardUpdateResponseDto update(Integer boardNum, BoardUpdateRequestDto dto, HttpServletRequest request);
}
