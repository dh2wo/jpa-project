package com.example.study.board.service;

import com.example.study.board.api.dto.BaordCommandDto.BoardAddRequsetDto;
import com.example.study.board.api.dto.BaordCommandDto.BoardAddResponseDto;
import com.example.study.board.domain.Board;
import com.example.study.board.repository.BoardRepository;
import com.example.study.episode.api.dto.EpiCommandDto.EpiAddResponsetDto;
import com.example.study.member.repository.MemberRepository;
import com.example.study.member.service.MemberService;
import com.example.study.util.jwt.JwtPayloadParser;
import com.example.study.util.jwt.JwtPayloadParserBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultBoardService implements BoardService{

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
                .boardTitle(dto.boardTitle())
                .boardContent(dto.boardContent())
                .build();

        boardRepository.save(board);

        return BoardAddResponseDto.builder()
                .success(true)
                .build();
    }
}
