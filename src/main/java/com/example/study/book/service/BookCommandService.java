package com.example.study.book.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static com.example.study.book.api.dto.BookCommandDto.BookCreateRequestDto;

public interface BookCommandService {
	boolean add(BookCreateRequestDto dto, MultipartFile file, HttpServletRequest request);
}
