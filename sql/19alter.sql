USE mydatabase;

CREATE TABLE table22
(
    col1 INT,
    col2 VARCHAR(10)
);
# 만들고 not null을 주고 싶을때?

# 방법1(데이터가 없을때)
DROP TABLE table22;

INSERT INTO table22
    (col1, col2)
VALUES (3, 'son');

# 방법2
# ALTER TABLE : 테이블 수정
# 컬럼추가
# 컬럼 TYPE 제약사항 변경
# 컬럼명 변경
ALTER TABLE table22
    ADD COLUMN col3 DATETIME NOT NULL DEFAULT NOW();

ALTER TABLE table22
    ADD COLUMN col4 INT;


DESC table22;

SELECT *
FROM table22;

ALTER TABLE table22
    ADD COLUMN col4 INT;

ALTER TABLE table22
    ADD COLUMN col5 INT NOT NULL;

ALTER TABLE table22
    ADD COLUMN col6 VARCHAR(10) NOT NULL;

ALTER TABLE table22
    ADD COLUMN col7 VARCHAR(10) NOT NULL UNIQUE;

ALTER TABLE table22
    ADD COLUMN col8 INT;

# 다른 위치에 컬럼을 추가하는 방법
ALTER TABLE table22
    ADD COLUMN col19 INT
        AFTER col1;

ALTER TABLE table22
    ADD COLUMN col20 INT
        FIRST;

# 연습
# table22에 새로운 컬럼 2개 추가
ALTER TABLE table22
    ADD COLUMN col21 VARCHAR(100);

ALTER TABLE table22
    ADD COLUMN col22 INT
        AFTER col19;

ALTER TABLE table22
    ADD COLUMN col293 INT NOT NULL DEFAULT '없음'
        AFTER col19;

# 컬럼명 변경
CREATE TABLE table23
(
    col1 INT,
    col2 VARCHAR(10)
);
# 이름 변경과 동시에 제약사항, type명도 바꿀 수 있음
ALTER TABLE table23
    CHANGE COLUMN col1 col11 INT;

DESC table23;

ALTER TABLE table23
    CHANGE COLUMN col11 col21 INT NOT NULL;

ALTER TABLE table23
    CHANGE COLUMN col21 col31 VARCHAR(10) NOT NULL;

# 컬럼의 type 제약사항 변경
ALTER TABLE table23
    MODIFY COLUMN col31 INT NOT NULL UNIQUE;

SELECT *
FROM table23;


# 연습
# table23 col2 의 타입을 DEC(10,2) NOT NULL, UNIQUE 변경
ALTER TABLE table23
    MODIFY COLUMN col2 DEC(10, 2);

ALTER TABLE table23
    MODIFY COLUMN col2 INT;


CREATE TABLE table24
(
    col1 VARCHAR(5),
    col2 INT
);

INSERT INTO table24
    (col1, col2)
VALUES ('abcde', 400000000);

INSERT INTO table24
    (col1, col2)
VALUES ('abcde', 400000000);

SELECT *
FROM table24;

ALTER TABLE table24
    MODIFY COLUMN col1 VARCHAR(3);

ALTER TABLE table24
    MODIFY COLUMN col1 VARCHAR(10) UNIQUE;

ALTER TABLE table24
    MODIFY COLUMN col2 BIGINT UNIQUE;




