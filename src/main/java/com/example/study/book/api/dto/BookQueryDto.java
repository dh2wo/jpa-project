package com.example.study.book.api.dto;

import com.example.study.book.repository.projection.BookListProjection;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

public record BookQueryDto() {
	
	public record ReadBooksRequestDto(
			String keyword
	){
		public ReadBooksRequestDto {
			if (keyword != null && "".equals(keyword.trim())) keyword = null;
		}
	}
	
	@Builder
	public record ReadBooksResponseDto(
			List<BookListProjection> books,
			Long lastPage
	){}
	public record ReadMemberBooksReqDto(
			UUID MemberId
	){
		public ReadMemberBooksReqDto {
			if (MemberId != null && "".equals(MemberId)) MemberId = null;
		}
	}
	
	@Builder
	public record ReadMemberBooksResponseDto(
			List<BookListProjection> books,
			Long lastPage
	){}
}
