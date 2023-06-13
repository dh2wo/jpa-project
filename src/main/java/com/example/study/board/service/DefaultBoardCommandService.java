package com.example.study.board.service;


import com.example.study.board.api.dto.BoardCommandDto.*;
import com.example.study.board.domain.Board;
import com.example.study.board.repository.BoardRepository;
import com.example.study.board.repository.projection.BoardListProjection;
import com.example.study.member.repository.MemberRepository;
import com.example.study.util.jwt.JwtPayloadParser;
import com.example.study.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultBoardCommandService implements BoardCommandService {

    private final JwtPayloadParserBuilder jwtPayloadParserBuilder;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Override
    public BoardAddResponseDto add(BoardAddRequsetDto dto, HttpServletRequest request) {
        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);
        String email = payloadParser.subject();
        String nickname = payloadParser.claims().get("nickname", String.class);

        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(IllegalStateException::new)
                .id();

        Board board = Board.builder()
                .memberId(memberId)
                .title(dto.title())
                .content(dto.content())
                .build();

        boardRepository.save(board);

        return BoardAddResponseDto.builder()
                .success(true)
                .build();
    }

    @Transactional
    public BoardDeleteResponseDto delete(Integer boardNum) {
        boolean success = boardRepository.existsByBoardNum(boardNum);

        if (success) {
            List<BoardListProjection> board = boardRepository.findAllProjectedBy();
            boardRepository.deleteByBoardNum(boardNum);
        }

        return BoardDeleteResponseDto.builder()
                .success(success)
                .build();
    }

    @Override
    @Transactional
    public BoardUpdateResponseDto update(Integer boardNum, BoardUpdateRequestDto dto) {
        boolean success = boardRepository.existsByBoardNum(boardNum);

        if(success){
            Board board = boardRepository.findByBoardNum(boardNum);
            board.setTitle(dto.title());
            board.setContent(dto.content());
        }

        return BoardUpdateResponseDto.builder()
                .success(success)
                .build();
    }
}


