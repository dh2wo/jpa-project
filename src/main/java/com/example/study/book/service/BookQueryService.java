package com.example.study.book.service;

import com.example.study.book.api.dto.BookQueryDto.ReadBooksRequestDto;
import com.example.study.book.api.dto.BookQueryDto.ReadBooksResponseDto;
import com.example.study.book.repository.projection.BookListProjection;
import com.example.study.common.type.SearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookQueryService {
	
	ReadBooksResponseDto searchWithGenreBy(
			String genreEng, SearchType searchType, String keyword, Pageable pageable, String page);
}
