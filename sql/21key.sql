USE mydatabase;
# KEY: 각 레코드를 구분하는 컬럼(들)
# Primary Key: 대표키, 주요키, 주키, pk
# UNIQUE
# NOT NULL
# 변경되지 말아야 함. -> 의미없는 id 값을 추가해주었다.
# Insert 시 결정되어야 한다.

# 그래서 결론
# -> 대부분의 테이블에 의미 없는 id 컬럼(NOT NUll UNIQUE AUTO_INCREMENT)으로 추가됨
# -> 대부분의 테이블에 의미 없는 id 컬럼(INT PRIMARY KEY AUTO_INCREMENT)으로 추가됨

CREATE TABLE table30
(
    name    VARCHAR(20),
    address VARCHAR(20),
#     phone   VARCHAR(20) UNIQUE NOT NULL 같은 역할을 한다
    phone   VARCHAR(20) PRIMARY KEY
);
DROP TABLE table30;

DESC table30;

# 이렇게 작성해도 됨.
CREATE TABLE table31
(
    name    VARCHAR(20),
    address VARCHAR(20),
    phone   VARCHAR(20),
    PRIMARY KEY (phone)
);
DESC table30;
DROP TABLE table31;

# primary 키를 두개 이상으로 설정 할 수도 있다.
CREATE TABLE table32
(
    name    VARCHAR(20),
    address VARCHAR(20),
    phone   VARCHAR(20),
    PRIMARY KEY (name, address)
);
DESC table32;

# primary일때 변경되지 말아야한다 설정하는 방법
CREATE TABLE table33
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    number  VARCHAR(13) NOT NULL UNIQUE,
    name    VARCHAR(20),
    address VARCHAR(30)
);

DROP TABLE table33;
DESC table33;

INSERT INTO table33
    (number, name, address)
VALUES ('3-3', 'son', 'seoul');

INSERT INTO table33
    (number, name, address)
VALUES ('4-4', 'lee', 'seoul');

INSERT INTO table33
    (number, name, address)
VALUES ('5-5', 'son', 'seoul');

SELECT *
FROM table33;

# id 값을 자동으로 증가시키면서 추가하는 방법
# AUTO_INCREMENT
