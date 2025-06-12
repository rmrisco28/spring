USE mydatabase;

# 상품정보
CREATE TABLE table41
(
    id          INT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30),
    price       INT,
    category_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES table42 (id)
);

# 카테고리 테이블
CREATE TABLE table42
(
    id   INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    info VARCHAR(30),
    PRIMARY KEY (id)
);

# 현재 3정규화 위반
INSERT INTO table41
    (name, price, category_id)
VALUES ('몽쉘', 1000, 1),
       ('오예스', 2000, 1),
       ('게토레이', 500, 2),
       ('커피', 600, 2),
       ('가나', 500, 3),
       ('크런키', 500, 3);

INSERT INTO table42
    (name, info)
VALUES ('파이', '크림이 있는빵'),
       ('음료수', '설탕물'),
       ('초콜릿', '카카오 가공품');


SELECT *
FROM table41;

SELECT *
FROM table42;

SELECT *
FROM table41 t41
         JOIN table42 t42
              ON t41.category_id = t42.id;


INSERT INTO table41
    (name, price)
VALUES ('컴퓨터', 10000);
# 외래키를 설정하는방법
# 나중에 넣기로 하고
INSERT INTO table42
    (name, info)
VALUES ('전자제품', '어쩌구 저쩌구');


UPDATE table41
set category_id=10
WHERE id = 10;


UPDATE table41
SET category_id = 5
WHERE id = 10;

DELETE
FROM table41
WHERE category_id = 4;

DELETE
FROM table42
WHERE id = 4;


# 외래 키 자식 테이블 child table
# 가리키고 있는 테이블 부모 테이블이라고 명명하기도 한다.
#  부모 테이블이 존재해야 있을 수 있음.
INSERT INTO table42
    (id, name, info)
VALUES (4, 'pc', '기계');

