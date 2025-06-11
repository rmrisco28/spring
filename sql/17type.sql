USE mydatabase;

# STRING
# VARCHAR(길이) 형식
CREATE TABLE table4
(
    col1 VARCHAR(1),
    col2 VARCHAR(3),
    col3 VARCHAR(5)
);

INSERT INTO table4
    (col1, col2, col3)
VALUES ('a', 'abc', 'abcde');

INSERT INTO table4 # 실패 #col1의 길이가 1인데 2글자 넣으려고해서 실패
    (col1, col2, col3)
VALUES ('aa', 'abc', 'abcde');

INSERT INTO table4
    (col1, col2, col3)
VALUES ('한', 'abc', 'abcde');

INSERT INTO table4 # 실패 col1의 길이가 1인데 2글자 넣으려고해서 실패
    (col1, col2, col3)
VALUES ('한글', 'abc', 'abcde');

SELECT *
FROM table4;

# 연습
# id 최대8글자, name(최대 20글자) 컬럼이 있는 table5만들기
# 두개의 레코드 입력(성공)
# 실패하는 레코드 입력시도

CREATE TABLE table5
(
    id   VARCHAR(8),
    name VARCHAR(20)
);

INSERT INTO table5
    (id, name)
VALUES ('123아이디', '메시');

INSERT INTO table5
    (id, name)
VALUES ('456아이디', '크리스티아누 호날두');

INSERT INTO table5
    (id, name)
VALUES ('789아이디', '크리스티아누 호날두 김수환무 거북이와 두루미 삼척박사');

DELETE
FROM table5
WHERE name = '크리스티아누 호날두';


SELECT *
FROM table5;


# NUMBER
# INTEGER (소수점 없는)
# DECIMAL (소수점 있는)
CREATE TABLE table6
(
    col1 INT,
    col2 BIGINT
);
INSERT INTO table6
    (col1, col2)
VALUES (232434, 1234852);

INSERT INTO table6 # 가능
    (col1, col2)
VALUES (234596781, 234685324785232231);

INSERT INTO table6 # 불가능
    (col1, col2)
VALUES (2345967812, 234685324785);

SELECT *
FROM table6;


# 연습
# score(정수), length(큰정수) 컬럼이 있는 table7 번 만들기
# 두 개의 레코드 입력 (성공)
# 한 개의 레코드 입력 (실패)

CREATE TABLE table7
(
    score  INT,
    length BIGINT
);

INSERT INTO table7
    (score, length)
VALUES (123456789, 987654321321);

INSERT INTO table7
    (score, length)
VALUES (1234567890, 987654321321987);


INSERT INTO table7
    (score, length)
VALUES (12345678901, 987654321321987654);

# DECIMAL(총길이, 소수점 이하 길이)
CREATE TABLE table8
(
    col1 INT,
    col2 DECIMAL(5, 1),
    col3 DECIMAL(10, 3),
    col4 DEC(5, 1),
    col5 DEC(10, 3)
);
INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (234, 1234.5, 1234567.123, null, null);

INSERT INTO table8 # 소수점 이하보다 낮은 숫자가 있다면, 반올림해서 올라가게 됨.
    (col1, col2, col3, col4, col5)
VALUES (234, 1234.56, 1234567.1234, null, null);

INSERT INTO table8 # 총 길이보다 길다면 실행되지 않는다.
    (col1, col2, col3, col4, col5)
VALUES (234, 1234.5, 12345678.123, null, null);

SELECT *
FROM table8;

# 연습
# score(총길이4, 소수점 이하2), money(총길이 10, 소수점 이하3) table9
# 두 개의 레코드 입력 성공
# 한 개 레코드 실패

CREATE TABLE table9
(
    score DECIMAL(4, 2),
    money DEC(10, 3)
);

INSERT INTO table9
    (score, money)
VALUES (12.34, 1234567.891);

INSERT INTO table9
    (score, money)
VALUES (12.44, 9876543.123);

# score 에선 소수점 2자리 이상을 사용하고 money 에선 3자리 이상 써야함
INSERT INTO table9
    (score, money)
VALUES (1234, 9876543123);

SELECT *
FROM table9;

# INT -> int
# BIGINT -> long
# DEC -> DOUBLE

# DATE, TIME
# DATATIME: 날짜 시간
CREATE TABLE table10
(
    col1 DATE,
    col2 TIME,
    col3 DATETIME
);

INSERT INTO table10
    (col1, col2, col3)
VALUES ('2025-06-11', '10:25:50', '2025-06-11 10:25:50');

# 년월일, 시분초, 년월일 시분초
INSERT INTO table10
    (col1, col2, col3)
VALUES ('2025-06-11', '10:25:50', '2025-06-11 10:25:50');

# 연습
# birth_date(날짜), work_time(시간), born(날짜 시간) table 11만들기
# 두개의 레코드 입력

CREATE TABLE table11
(
    birth_date DATE,
    work_time  TIME,
    born       DATETIME
);

INSERT INTO table11
    (birth_date, work_time, born)
VALUES ('2025-06-11', '10:32:10', '1999-11-11 11:11:12');

INSERT INTO table11
    (birth_date, work_time, born)
VALUES ('1987-02-2', '23:21:58', '1978-01-21 12:23:14');

SELECT *
FROM table11;

# STRING: VARCHAR(길이)
# NUMBER: INT, BIGINT, DEC(총길이, 소수점 이하길이)
# 날짜길이: DATE, TIME, DATETIME

CREATE TABLE table12
(
    col1 VARCHAR(10),
    col2 INT,
    col3 BIGINT,
    col4 DEC(10, 2),
    col5 DATE,
    col6 TIME,
    col7 DATETIME
);

INSERT INTO table12
    (col1, col2, col3, col4, col5, col6, col7)
VALUES ();

SELECT *
FROM table12;


CREATE TABLE table13
(
    name       VARCHAR(255),
    birth_date DATE,
    score      DEC(10, 2),
    born_at    DATETIME
);

SELECT *
FROM table13;

INSERT INTO table13
    (name, birth_date, score, born_at)
VALUES ();
