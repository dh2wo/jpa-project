package com.example.study.book.domain;

import com.example.study.support.MySchemaConstants;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
@Table(
		name = MySchemaConstants.TB_BOOK_GENRE,
		schema = MySchemaConstants.SCHEMA
//		catalog = MySchemaConstants.SCHEMA
)
public class BookGenre {
	@Id
	private Long id;
	@Column
	private String kor;
	@Column
	private String eng;
}