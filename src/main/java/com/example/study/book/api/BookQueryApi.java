package com.example.study.book.api;

import com.example.study.book.api.dto.BookQueryDto.*;
import com.example.study.book.exception.BookQueryErrorCode;
import com.example.study.book.repository.projection.BookListProjection;
import com.example.study.book.service.BookQueryService;
import com.example.study.common.type.SearchType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@Log4j2
public class BookQueryApi {
	private final BookQueryService bookQueryService;
	
	// Restful(over) -> initial CRUD
	// vs just Rest한 API
	@GetMapping(path = "/genre/{genreEng}")
	public ReadBooksResponseDto ReadBooksByGenre(
			@PathVariable String genreEng,
			@PageableDefault(size=20, sort="createdAt", direction = Sort.Direction.DESC)
			Pageable pageable,
			@RequestParam(required = false) String keyword,
			@RequestParam(required = false, defaultValue = "NONE") SearchType searchType,
			@RequestParam(required = false) String page) {

		return bookQueryService.searchWithGenreBy(genreEng, searchType, keyword, pageable, page);
	}
	
//	@GetMapping("/{memberId}")
//	public ReadMemberBooksResponseDto getBooksByMember(
//			@PathVariable UUID memberId,
//			@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
//			Pageable pageable,
//			@RequestParam(required = false) String keyword,
//			@RequestParam(required = false) String genreEng,
//			@RequestParam(required = false, defaultValue = "NONE") SearchType searchType){
//
//		pageable = pageable.previousOrFirst();
//
//		Page<BookListProjection> memberBookSearchResult = bookQueryService.searchWithGenreBy(
//				genreEng, searchType, keyword, pageable);
//
//		List<BookListProjection> books = memberBookSearchResult.toList();
//		long lastPageNumber = memberBookSearchResult.getTotalPages();
//
//		if (pageable.getPageNumber() >= lastPageNumber) {
//			throw BookQueryErrorCode.PAGE_OUT_OF_RANGE.defaultException();
//		}
//
//		return ReadMemberBooksResponseDto.builder()
//				.books(books)
//				.lastPage(lastPageNumber)
//				.build();
//	}
}

// GET /genre/{generEng}/books
// GET /genre/{generEng}/books?page=1
// POST /genre/1/books
// PUT /genre/1/books/Q9ADFDAF
// DELETE /genre/Q9DF7A/books/1
// "/genre/{genreId}/books/{bookId}"

// private ID public CODE(ID)

// GET /books/genre/