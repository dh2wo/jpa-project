package com.example.study.board.service;

import com.example.study.board.api.dto.BoardQueryDto.BoardQueryResponseDto;
import com.example.study.board.domain.Board;
import com.example.study.board.exception.BoardFailureErrorCode;
import com.example.study.board.repository.BoardRepository;
import com.example.study.board.repository.projection.BoardListProjection;
import com.example.study.board.domain.type.SearchType;
import com.example.study.member.repository.MemberRepository;
import com.example.study.util.jwt.JwtPayloadParser;
import com.example.study.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultBoardQueryService implements BoardQueryServcie {

    private final JwtPayloadParserBuilder jwtPayloadParserBuilder;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

//    @Override
//    public List<Board> all() {
//        return boardRepository.findAll();
//    }

//    @Override
//    public List<BoardListProjection> readList() {
//        // Projection으로 원하는 컬럼만 가져올 경우 JpaRepository에서 findAllProjectedBy() 함수를 사용
//        return boardRepository.findProjectedBy();
//    }

    @Override
    public List<BoardListProjection> findByBoardNum(Long boardNum) {
        return null;
    }

    @Override
    public List<BoardListProjection> findByMemberId(HttpServletRequest request) {

        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);
        String email = payloadParser.subject();

        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(IllegalStateException::new)
                .id();

        return boardRepository.findProjectedByMemberId(memberId);
    }

    @Override
    public BoardQueryResponseDto findBoardList(Pageable pageable, String keyword, SearchType searchType, String page) {

        Page<Board> boardSearchResult = null;

        if (page != null && !page.isEmpty()) {
            // 만약 'page' 매개변수가 제공되었다면, pageable 객체를 해당 페이지로 업데이트
            pageable = PageRequest.of(Integer.parseInt(page) - 1, pageable.getPageSize(), pageable.getSort());
        }

        switch (searchType){
            case TITLE ->                               // Contains: 포함, IgnoreCase: 대소문자 구별X
                    boardSearchResult = boardRepository.findAllByTitleContainsIgnoreCase(keyword, pageable);
            case CONTENT ->
                    boardSearchResult = boardRepository.findAllByContentContainsIgnoreCase(keyword, pageable);
            case MEMBER_NAME ->
                    boardSearchResult = boardRepository.findAllByNicknameContainsIgnoreCase(keyword, pageable);
            case BOARD_NUM ->
                    boardSearchResult = boardRepository.findAllByBoardNum(Long.parseLong(keyword), pageable);
            case NONE ->
                    boardSearchResult = boardRepository.findAll(pageable);
        }
        // pageable 객체를 이전 페이지 또는 첫 번째 페이지로 업데이트
        pageable = pageable.previousOrFirst();

        List<Board> boards = boardSearchResult.toList();
        long lastPageNumber = boardSearchResult.getTotalPages();

        if (pageable.getPageNumber() >= lastPageNumber) {
            // 요청한 페이지가 범위를 벗어나면 예외
            throw BoardFailureErrorCode.PAGE_OUT_OF_RANGE.defaultException();
        }

        return BoardQueryResponseDto.builder()
                .boardList(boards)
                .lastPage(lastPageNumber)
                .build();
    }
}
