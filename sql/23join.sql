USE mydatabase;
CREATE TABLE table34
(
    name VARCHAR(1)
);

CREATE TABLE table35
(
    score INT
);

INSERT INTO table34
    (name)
    VALUE ('a'),
    ('b'),
    ('c'),
    ('d'),
    ('e');
INSERT INTO table35
    (score)
values (5),
       (4),
       (3),
       (2),
       (1);

SELECT *
FROM table34;

SELECT *
FROM table35;

# 동시에 확인 할 경우, table34의 레코드 수와 table35레코드 수가 곱해진 만큼 보여짐
# 34의 1번 레코드와 35 의 1번 레코드를 결합,
# 34의 1번 레코드와 35 의 2번 레코드를 결합 ...
# 34의 5번 레코드와 35 의 5번 레코드를 결합
# 행은 25개, 열은 2개
SELECT *
FROM table34,
     table35;

# 프로덕트는 77행, 카테고리 8행 = 616
# 열 9개
SELECT *
FROM w3schools.Products
         JOIN
     w3schools.Categories;

# Cartesian Product (카테시안 곱)

CREATE TABLE table36
(
    `대회`  varchar(20),
    `연도`  INT,
    `우승자` VARCHAR(30),
    PRIMARY KEY (`대회`, `연도`)
);


CREATE TABLE table37
(
    `우승자`  VARCHAR(30),
    `생년월일` VARCHAR(100),
    PRIMARY KEY (`우승자`)
);

INSERT INTO table36
    (대회, 연도, 우승자)
VALUES ('D', '1998', 'chip'),
       ('I', '1998', 'al'),
       ('C', '1999', 'bob'),
       ('D', '1999', 'al'),
       ('I', '1999', 'chip');

INSERT INTO table37
    (우승자, 생년월일)
VALUES ('chip', '77-3-14'),
       ('al', '75-7-21'),
       ('bob', '68-9-28');

SELECT *
FROM table36;
SELECT *
FROM table37;


# 카테시안 곱
SELECT *
FROM table36
         JOIN table37;

# 우리가 필요한 데이터는 대회에 우승한 사람의 생년월일 5개뿐.
# 36번 테이블의 우승자와 37번 테이블의 우승자의 값만 가져오는 방법

SELECT *
FROM table36
         JOIN table37
WHERE table36.우승자 = table37.우승자;

# 위도 되지만 더 많이 쓰는 조합

SELECT *
FROM table36
         JOIN table37
              ON table36.우승자 = table37.우승자;

# 우승자가 중복되니, 4개의 컬럼만 보고 싶을 경우,
SELECT 대회, 연도, table36.우승자, 생년월일
FROM table36
         JOIN table37
              ON table36.우승자 = table37.우승자;

# join을 하면 테이블의 이름이 반복해서 나오기 때문에
# ALIAS 별칭으로 지정
SELECT 대회 AS congress, 연도 AS year, t6.우승자, 생년월일
FROM table36 AS t6
         JOIN table37 AS t7
              ON t6.우승자 = t7.우승자;


# 연습

SELECT *
FROM w3schools.Products;

SELECT *
FROM w3schools.Categories;

SELECT p.ProductName, c.CategoryName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              On p.CategoryID = c.CategoryID
ORDER BY c.CategoryName, p.ProductName;

# 상품테이블의 공급자의 id가 서플라이어 키 값으로 갖고있습니다.
# 공급자 별 공급하는 상품 목록 조회
SELECT s.SupplierName, p.ProductName
FROM w3schools.Suppliers s
         JOIN w3schools.Products p
              On s.SupplierID = p.SupplierID
ORDER BY s.SupplierName, p.ProductName;

# FROM 절에 쓰는 내용이 늘어났을 뿐, 어려운건 없다.
# WHERE절과 함께 보겠습니다.

# 주문별 처리 직원
SELECT o.OrderDate, o.OrderID, e.FirstName, e.LastName
FROM w3schools.Orders o
         JOIN w3schools.Employees e
              ON o.EmployeeID = e.EmployeeID
WHERE e.EmployeeID = 3;

# 1번 고객이 주문한 날짜들 조회

SELECT o.CustomerID, o.OrderDate
FROM w3schools.Orders o
WHERE CustomerID = 1;

SELECT c.CustomerName, o.OrderDate
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              On o.CustomerID = c.CustomerID
WHERE c.CustomerID = 1;

# 고객별 주문 건수 주문이 20건 이상인 고객
SELECT c.CustomerID, c.CustomerName, COUNT(*)
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
HAVING COUNT(*) >= 20
ORDER BY c.CustomerID;


# 연습
# 직원별 주문 처리 건수
SELECT e.EmployeeID, e.FirstName, e.LastName, count(*) count
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
GROUP BY e.EmployeeID
ORDER BY count DESC;

SELECT e.EmployeeID, e.FirstName, e.LastName, count(*) count
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
WHERE o.OrderDate BETWEEN '1997-01-01' AND '1997-12-31'
GROUP BY e.EmployeeID
ORDER BY count DESC;


# 카테고리별 상품의 평균 가격
SELECT c.CategoryID, CategoryName, AVG(p.Price)
FROM w3schools.Categories c
         JOIN w3schools.Products p
              ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID
ORDER BY c.CategoryID;









