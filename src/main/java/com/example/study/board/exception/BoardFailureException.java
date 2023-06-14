package com.example.study.board.exception;

import com.example.study.support.exception.CustomException;

public class BoardFailureException extends CustomException {
	public final BoardFailureErrorCode ERROR_CODE;
	
	public BoardFailureException() {
		super(BoardFailureErrorCode.DEFAULT.MESSAGE);
		ERROR_CODE = BoardFailureErrorCode.DEFAULT;
	}
	
	public BoardFailureException(String message) {
		super(message);
		ERROR_CODE = BoardFailureErrorCode.DEFAULT;
	}
	
	public BoardFailureException(String message, Throwable cause) {
		super(message, cause);
		ERROR_CODE = BoardFailureErrorCode.DEFAULT;
	}
	
	public BoardFailureException(BoardFailureErrorCode errorCode) {
		super(errorCode);
		ERROR_CODE = errorCode;
	}
	
	public BoardFailureException(BoardFailureErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
		ERROR_CODE = errorCode;
	}
}