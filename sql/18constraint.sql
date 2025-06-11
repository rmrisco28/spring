USE mydatabase;

# 제약사항(Constrain) : 컬럼에 입력 가능한 값을 제한

# NOT NULL: null 허용안함
# UNIQUE: 중복 허용 안함
# DEFAULT: 값 안주면 기본값

# NOT NULL
CREATE TABLE table14
(
    col1 INT,
    col2 INT NOT NULL # null 허용 안됨
);

INSERT INTO table14
    (col1, col2)
VALUES (5, 1);

INSERT INTO table14
    (col1)
VALUES (1);

INSERT INTO table14
    (col2)
VALUES (1);

INSERT INTO table14
    (col2)
VALUES (11);

SELECT *
FROM table14;

# 연습
# (name varchar not null) (address varchar) table15만들기
CREATE TABLE table15
(
    name    varchar(255) NOT NULL,
    address varchar(255)
);

INSERT INTO table15
    (name, address)
VALUES ('철수', '서울');

INSERT INTO table15
    (name)
VALUES ('영희');

INSERT INTO table15
    (address)
VALUES ('서울');

SELECT *
FROM table15;

# DEFAULT: 값 안주면 기본값
CREATE TABLE table16
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) DEFAULT 'anonymous'
);

INSERT INTO table16
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table16
    (col1)
    VALUE ('qwe');

INSERT INTO table16
    (col1, col2)
VALUES ('qwe', null);

SELECT *
FROM table16;

CREATE TABLE table17
(
    col1 VARCHAR(10)          DEFAULT 'var1',
    col2 VARCHAR(10) NOT NULL DEFAULT 'var2'
);

INSERT INTO table17
    (col1, col2)
VALUEs ('abc', 'def');

INSERT INTO table17
    (col1, col2)
VALUEs (null, 'def');

INSERT INTO table17
    (col2)
VALUEs ('zxt');

INSERT INTO table17
    (col1)
VALUEs ('iop');

SELECT *
FROM table17;

# 연습
# (name varchar not null), (score int not null default 0) table18 만들기

CREATE TABLE table18
(
    name  varchar(100) NOT NULL,
    score INT          NOT NULL DEFAULT '0'
);

INSERT INTO table18
    (name, score)
VALUES ('길동', 230);

INSERT INTO table18
    (name)
VALUES ('철수');

INSERT INTO table18
    (name, score)
VALUES ('영희', 110);

INSERT INTO table18
    (name)
VALUES ('짱구');

SELECT *
FROM table18;

# UNIQUE : 중복 허용 불가
CREATE TABLE table19
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) UNIQUE
);

INSERT INTO table19
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table19
    (col1, col2)
VALUES ('abc', 'qwe');

INSERT INTO table19
    (col1, col2)
VALUES ('iop', 'qwe');

INSERT INTO table19
    (col1)
VALUES ('iop');

INSERT INTO table19
    (col1)
VALUES ('sdf');


SELECT *
FROM table19;

CREATE TABLE table20
(
    col1 VARCHAR(3),
    col2 VARCHAR(3) UNIQUE NOT NULL
);

INSERT INTO table20
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table20
    (col1, col2)
VALUES ('abc', 'qwe');

INSERT INTO table20 # 실패
    (col2)
VALUES ('qwe');

INSERT INTO table20 # 실패
    (col1)
VALUES ('abc');


SELECT *
FROM table20;


# 연습
# (name varchar not null unique), (score int not null default 0) table21

CREATE TABLE table21
(
    name  VARCHAR(10) NOT NULL UNIQUE,
    score INT         NOT NULL DEFAULT 0
);

INSERT INTO table21
    (name, score)
VALUES ('길동', 1);

INSERT INTO table21
    (name)
VALUES ('철수');

INSERT INTO table21
    (name)
VALUES ('영희');

INSERT INTO table21 # 실패
    (score)
VALUES (1);

# 테이블의 구조 보기
DESCRIBE table20;
DESC table15;
# 줄여서 쓸 수도 있다.
# field:
# key:
# UNI:
# PRI:NOT NULL과 UNIQUE 값을 주었을 경우, pri써있음


# 아이콘에 o표시가 있으면 null을 허용하지 않는다.
# 색깔로 표시되어있는게 UNIQUE
# DEFAULT 되어있다면 옆에 기본값이 보인다.

SHOW CREATE TABLE table19;
CREATE TABLE `table19`
(
    `col1` varchar(10) DEFAULT NULL,
    `col2` varchar(10) DEFAULT NULL,
    UNIQUE KEY `col2` (`col2`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci);


# 연습
# w3schools.Products 테이블 구조 보기
# DESC, SHOW CREATE TABLE, copy DDL
USE mydatabase;

USE w3schools;

DESC w3schools.Products;
SHOW CREATE TABLE w3schools.Products;
create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null
);


# Primary Key: 주요 키(PK)
# Foreign Key: 외래키(FK), 참조키