package com.example.study.board.domain;

import com.example.study.episode.domain.type.EpisodeStatus;
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
public class BoardComment extends UuidBaseEntity {
    UUID boardId;
    String nickname;
    String content;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    EpisodeStatus status = EpisodeStatus.PENDING;
    @Builder.Default
    OffsetDateTime createdAt = OffsetDateTime.now(DEFAULT_TIMEZONE_ID);
    OffsetDateTime updatedAt;
    OffsetDateTime deletedAt;
}
