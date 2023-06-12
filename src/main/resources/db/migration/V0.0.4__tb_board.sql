-- board_num SEQUENCE
CREATE SEQUENCE IF NOT EXISTS board_sequence START 1;

-- 게시판(Board)
CREATE TABLE IF NOT EXISTS joara_basic.board (
    id                  UUID                 PRIMARY KEY,
    member_id           UUID                 ,
    board_num           SERIAL               ,
    board_title         VARCHAR(255)         ,
    board_content       TEXT                 ,
    create_at           DATE
);
ALTER TABLE joara_basic.board ALTER COLUMN board_num SET DEFAULT nextval('board_sequence');
