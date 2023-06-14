package com.example.study.member.exception.signup;

import com.example.study.support.exception.CustomException;

public class MemberFailureException extends CustomException {
	public final MemberErrorCode ERROR_CODE;
	
	public MemberFailureException() {
		super(MemberErrorCode.DEFAULT.MESSAGE);
		ERROR_CODE = MemberErrorCode.DEFAULT;
	}
	
	public MemberFailureException(String message) {
		super(message);
		ERROR_CODE = MemberErrorCode.DEFAULT;
	}
	
	public MemberFailureException(String message, Throwable cause) {
		super(message, cause);
		ERROR_CODE = MemberErrorCode.DEFAULT;
	}
	
	public MemberFailureException(MemberErrorCode errorCode) {
		super(errorCode);
		ERROR_CODE = errorCode;
	}
	
	public MemberFailureException(MemberErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
		ERROR_CODE = errorCode;
	}
}