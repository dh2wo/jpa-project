package com.example.study.book.api;

import com.example.study.book.api.dto.BookCommandDto;
import com.example.study.book.api.dto.BookCommandDto.BookCreateResponseDto;
import com.example.study.book.api.dto.BookCommandDto.BookUpdateResponseDto;
import com.example.study.book.service.BookCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public final class BookCommandApi {
	
	private final BookCommandService bookCommandService;
	
	@PostMapping("/create")
	public BookCreateResponseDto bookAddResponseDto(
			@RequestPart(value = "coverImage", required = false) MultipartFile file,
			@ModelAttribute @Valid BookCommandDto.BookCreateRequestDto body,
			HttpServletRequest request){
		return new BookCreateResponseDto(bookCommandService.add(body, file, request));
	}


}
