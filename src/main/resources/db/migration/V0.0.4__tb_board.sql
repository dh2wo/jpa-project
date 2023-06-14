-- board_num SEQUENCE
CREATE SEQUENCE IF NOT EXISTS board_sequence START 1;

-- 게시판(Board)
CREATE TABLE IF NOT EXISTS joara_basic.board (
    id                  UUID                 PRIMARY KEY,
    member_id           UUID                 ,
    nickname           VARCHAR(255)         ,
    board_num           SERIAL               ,
    title               VARCHAR(255)         ,
    content             TEXT                 ,
    created_at          DATE                 ,
    updated_at          DATE                 ,
    deleted_at          DATE
);
ALTER TABLE joara_basic.board ALTER COLUMN board_num SET DEFAULT nextval('board_sequence');
