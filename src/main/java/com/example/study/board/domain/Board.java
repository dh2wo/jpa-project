package com.example.study.board.domain;

import com.example.study.support.MySchemaConstants;
import com.example.study.support.UuidBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.example.study.support.Constants.DEFAULT_TIMEZONE_ID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(
        name = MySchemaConstants.TB_BOARD,
        schema = MySchemaConstants.SCHEMA)
public class Board extends UuidBaseEntity {
    public UUID memberId;
    public Integer boardNum;
    public String boardTitle;
    public String boardContent;
    @Builder.Default
    public OffsetDateTime createAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);
}
