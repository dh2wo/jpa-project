package com.example.study.board.api;

import com.example.study.board.api.dto.BaordCommandDto.BoardAddRequsetDto;
import com.example.study.board.api.dto.BaordCommandDto.BoardAddResponseDto;
import com.example.study.board.domain.Board;
import com.example.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardCommandApi {

    private final BoardService boardService;
    @PostMapping("/add")
    public BoardAddResponseDto add(
            BoardAddRequsetDto dto, HttpServletRequest request){
        return boardService.add(dto, request);
    }
}