package com.example.study.board.api;

import com.example.study.board.api.dto.BoardCommandDto.*;
import com.example.study.board.service.BoardCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardCommandApi {

    private final BoardCommandService boardCommandService;

    // 게시글 등록
    @PostMapping()
    public BoardCreateResponseDto create(
            @RequestBody @Valid BoardCreateRequsetDto dto,
            HttpServletRequest request){ // request: member_id 가져오려고
        return boardCommandService.create(dto, request);
    }

    // 게시글 삭제 (@DeleteMapping())
    @DeleteMapping("/{boardNum}")
    public BoardDeleteResponseDto delete(@PathVariable("boardNum") Integer boardNum){
        return boardCommandService.delete(boardNum);
    }

    // 게시글 수정
    @PutMapping("/{boardNum}")
    public BoardUpdateResponseDto update(@PathVariable("boardNum") Integer boardNum, @RequestBody BoardUpdateRequestDto dto, HttpServletRequest request){
//        boolean success = boardCommandService.update(boardNum, dto, request).success();
//        return BoardUpdateResponseDto.builder()
//                .success(success)
//                .build();
        return boardCommandService.update(boardNum, dto, request);
    }
}