package com.example.study.board.exception;

import com.example.study.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum BoardFailureErrorCode implements ErrorCode {
	BOARD_FAILURE("게시글이 작성 실패", HttpStatus.CONFLICT),
	// ...
	DEFAULT("게시글이 작성 실패", HttpStatus.INTERNAL_SERVER_ERROR),
	PAGE_OUT_OF_RANGE("페이지 번호가 유효하지 않음.",HttpStatus.BAD_REQUEST);


	public final String MESSAGE;
	public final HttpStatus STATUS;
	
	@Override
	public String getName() {
		return name();
	}
	
	@Override
	public HttpStatus defaultHttpStatus() {
		return STATUS;
	}
	
	@Override
	public String defaultMessage() {
		return MESSAGE;
	}
	
	@Override
	public BoardFailureException defaultException() {
		return new BoardFailureException(this);
	}
	
	@Override
	public BoardFailureException defaultException(Throwable cause) {
		return new BoardFailureException(this, cause);
	}
}
