package com.example.study.board.api;

import com.example.study.board.api.dto.BoardQueryDto.BoardQueryResponseDto;
import com.example.study.board.repository.projection.BoardListProjection;
import com.example.study.board.service.BoardQueryServcie;
import com.example.study.board.type.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    // 선택 컬럼만 조회 (id, memberId 제외)
    @GetMapping("")
    public BoardQueryResponseDto findBoardList(
            @PageableDefault(size=10, sort="boardNum", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "NONE") SearchType searchType){
        return boardQueryServcie.findBoardList(pageable, keyword, searchType);
    }

//    @GetMapping("/{boardNum}")
//    public List<BoardListProjection> findByBoardNum(@PathVariable Long boardNum){
//        return boardQueryServcie.findByBoardNum(boardNum);
//    }
    // todo 다양한 필드로 조회해보기
    // todo 다양한 조회 합치기
    @GetMapping("/{boardNum}")
    public List<BoardListProjection> findByBoardNum(@PathVariable Long boardNum){
        return boardQueryServcie.findByBoardNum(boardNum);
    }

    // 내 글만 조회
    @GetMapping("/mylist")
    public List<BoardListProjection> findByMemberId(HttpServletRequest request){
        return boardQueryServcie.findByMemberId(request);
    }
}
