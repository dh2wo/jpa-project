package com.example.study.board.service;


import com.example.study.board.api.dto.BoardCommandDto.*;
import com.example.study.board.domain.Board;
import com.example.study.board.exception.BoardFailureErrorCode;
import com.example.study.board.exception.BoardFailureException;
import com.example.study.board.repository.BoardRepository;
import com.example.study.board.repository.projection.BoardListProjection;
import com.example.study.member.exception.signup.MemberErrorCode;
import com.example.study.member.repository.MemberRepository;
import com.example.study.util.jwt.JwtPayloadParser;
import com.example.study.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultBoardCommandService implements BoardCommandService {

    private final JwtPayloadParserBuilder jwtPayloadParserBuilder;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional // 트랜잭션 범위 설정, 예외 처리와 롤백, 데이터 일관성
    public BoardCreateResponseDto create(BoardCreateRequsetDto dto, HttpServletRequest request) {

        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);
        String nickname = payloadParser.claims().get("nickname", String.class);
        String email = payloadParser.subject();

        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(MemberErrorCode
                            .MEMBER_NOT_EXIST::defaultException)
                            .id();

        Board board = Board.builder()
                .memberId(memberId)
                .nickname(nickname)
                .title(dto.title())
                .content(dto.content())
                .build();

        boardRepository.save(board);

        return BoardCreateResponseDto.builder()
                .success(true)
                .build();
    }

    @Transactional
    public BoardDeleteResponseDto delete(Integer boardNum) {

        boolean success = boardRepository.existsByBoardNum(boardNum);
        if (!success) throw BoardFailureErrorCode.DEFAULT.defaultException();

        boardRepository.deleteByBoardNum(boardNum);

        return BoardDeleteResponseDto.builder()
                .success(success)
                .build();
    }


    @Override
    @Transactional // 얘가 있어서 .save() 안해줘도 됨.
    public BoardUpdateResponseDto update(Integer boardNum, BoardUpdateRequestDto dto, HttpServletRequest request) {

        JwtPayloadParser payloadParser = jwtPayloadParserBuilder.buildWith(request);
        String email = payloadParser.subject();

        // 유저 아이디
        UUID memberId = memberRepository.findIdByEmail(email)
                .orElseThrow(IllegalStateException::new)
                .id();

        Optional<Board> optionalBoard = boardRepository.findByBoardNum(boardNum);
        if(optionalBoard.isEmpty()) {
            throw new IllegalStateException();
        }

        Board board  = optionalBoard.get();
        if(board.getMemberId() != memberId){
            throw new IllegalStateException();
        }

        board.setTitle(dto.title());
        board.setContent(dto.content());

        return BoardUpdateResponseDto.builder()
                .success(true)
                .build();
    }
}


