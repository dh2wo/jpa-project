-- board_num SEQUENCE
CREATE SEQUENCE IF NOT EXISTS board_sequence START 1;

-- 게시판(Board)
CREATE TABLE IF NOT EXISTS joara_basic.board (
    id                  UUID                 PRIMARY KEY,
    nickname            VARCHAR(255)         NOT NULL,
    board_num           BIGSERIAL            NOT NULL,
    title               VARCHAR(255)         NOT NULL,
    content             TEXT                 NOT NULL,
    status              VARCHAR(255)         ,
    created_at          DATE                 NOT NULL,
    updated_at          DATE                 ,
    deleted_at          DATE
);
ALTER TABLE joara_basic.board ALTER COLUMN board_num SET DEFAULT nextval('board_sequence');

-- 게시판 댓글(BoardComment)
CREATE TABLE IF NOT EXISTS joara_basic.board_commnet (
    id                  UUID                 PRIMARY KEY,
    board_id            UUID                 NOT NULL,
    nickname            VARCHAR(255)         NOT NULL,
    content             VARCHAR(255)         ,
    status              VARCHAR(255)         ,
    created_at          DATE                 NOT NULL ,
    updated_at          DATE                 ,
    deleted_at          DATE
);

-- 게시판 대댓글(BoardReply)
CREATE TABLE IF NOT EXISTS joara_basic.board_reply (
    id                  UUID                 PRIMARY KEY,
    board_comment_id    UUID                 NOT NULL,
    nickname            VARCHAR(255)         NOT NULL,
    content             VARCHAR(255)         NOT NULL,
    status              VARCHAR(255)         ,
    created_at          DATE                 NOT NULL ,
    updated_at          DATE                 ,
    deleted_at          DATE
);