package com.example.study.board.service;

import com.example.study.board.api.dto.BaordCommandDto.BoardAddRequsetDto;
import com.example.study.board.api.dto.BaordCommandDto.BoardAddResponseDto;
import com.example.study.board.domain.Board;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
    BoardAddResponseDto add(BoardAddRequsetDto dto, HttpServletRequest request);
}
