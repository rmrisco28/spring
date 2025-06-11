# DATABASE: 테이블을 모아 놓은 공간
# CREATE DATEBASE: 데이터 베이스 만들기 CREATE DATABALSE 데이터베이스명
CREATE DATABASE mydatabase;

# database(schema) 사용하기 use 데이터베이스명.
USE mydatabase;


# CREATE TABLE: 테이블만들기

CREATE TABLE table1
(
    id int
);

# DROP TABLE: 테이블 삭제하기 (매우 주의!!!!)
DROP TABLE table1;

#
USE mydatabase;
USE w3schools;

SELECT *
FROM w3schools.Customers;


# 다른 데이터베이스에 있어도
# 다른 데이터베이스 테이블을 사용 할 수 있는 방법
SELECT *
FROM w3schools.Customers;

# 우리는 mydatabase에서 만들예정
USE mydatabase;

#
CREATE TABLE table2 # 테이블명
(
    name    varchar(255),# 둥근 괄호 안에서 컬럼명 (데이터 타입) 나열
    country varchar(255),
    phone   varchar(255)
);

INSERT INTO table2
    (name, country, phone)
VALUES ('트럼프', '미국', '1234');

SELECT *
FROM table2;

# 테이블 명을 짓는 관습(글로벌은 아니고 회사마다 다름)
# 테이블 명, 컬럼명 작성 규칙
# 소문자, _ (lower_snake_case)
CREATE TABLE my_table1
(
    name            varchar(255),
    address         varchar(255),
    last_name       varchar(255),
    nick_name       varchar(255),
    home_address    varchar(255),
    my_work_address varchar(255)
);

#연습
# id, name, address, team 컬럼이 있는 table3 만들기
# 2개의 레코드 입력(insert) 하기

CREATE TABLE table3
(
    id       varchar(255),
    name     varchar(255),
    adddress varchar(255),
    team     varchar(255)
);

INSERT INTO table3
    (id, name, adddress, team)
VALUES (1, '트럼프', '미국', '공화당'),
       (2, '머스크', '미국', '테슬라');

SELECT *
FROM table3;

# DROP TABLE: 테이블 삭제하기
DROP TABLE my_table1;

# 연습
# table3 삭제하기
DROP TABLE table3;

# 자료형
