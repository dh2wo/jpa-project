package com.example.study.board.api;

import com.example.study.board.domain.Board;
import com.example.study.board.repository.projection.BoardListProjection;
import com.example.study.board.service.BoardQueryServcie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardQueryApi {

    private final BoardQueryServcie boardQueryServcie;

    // 컬럼 전부 조회
//    @GetMapping("/all")
//    public List<Board> board(){
//        return boardQueryServcie.all();
//    }

    // 선택 컬럼만 조회
    @GetMapping("/all")
    public List<BoardListProjection> board(){
        return boardQueryServcie.all();
    }
}
