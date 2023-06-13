package com.example.study.board.api;

import com.example.study.board.api.dto.BoardCommandDto.*;
import com.example.study.board.domain.Board;
import com.example.study.board.service.BoardCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardCommandApi {

    private final BoardCommandService boardCommandService;

    @PostMapping("/add")
    public BoardAddResponseDto add(
            BoardAddRequsetDto dto, HttpServletRequest request){ // request: member_id 가져오려고
        return boardCommandService.add(dto, request);
    }

    @DeleteMapping("/delete/{id}")
    public BoardDeleteResponseDto delete(@PathVariable("id") Integer boardNum){
        return boardCommandService.delete(boardNum);
    }

    @PostMapping("/update/{id}")
    public BoardUpdateResponseDto update(@PathVariable("id") Integer boardNum, @RequestBody BoardUpdateRequestDto dto){
        return boardCommandService.update(boardNum, dto);
    }
}