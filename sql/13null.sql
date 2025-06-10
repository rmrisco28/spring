# NULL: 값이 없다.

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# SUM, COUNT, MIN, MAX, AVG
# 집계함수는 NULL을 집계에 포함하지 않는다.

SELECT COUNT(CustomerName)
FROM Customers;

SELECT COUNT(ContactName)
FROM Customers;

SELECT COUNT(Address)
FROM Customers;

# 2302.71
SELECT SUM(Price)
FROM Products;

#29.148228
# 추가를 해도
SELECT AVG(Price)
FROM Products;

INSERT INTO Products
    (ProductName)
    VALUE ('커피');

INSERT INTO Products
    (ProductName)
    VALUE ('컴퓨터');

# NULL인 컬럼 조회
SELECT *
FROM Customers
# WHERE ContactName IS NULL # null 인 값을 찾기
WHERE ContactName IS NOT NULL # null이 아닌 값을 찾기
ORDER BY CustomerID DESC;

# 어떤 연산을 해도 null(값이 없음) 이기 때문에 무조건 false가 나옴.
# 따라서 != null
# WHERE ContactName =  null, !=null 이런거 안된다.

# 연습
# 카테고리에서 Description 이 null인 레코드 조회
SELECT *
FROM Categories
WHERE Description IS NULL
ORDER BY CategoryID DESC;

# 카테고리에서 Description 이 null이 아닌 레코드 조회
SELECT *
FROM Categories
WHERE Description IS NOT NULL
ORDER BY CategoryID DESC;

# 상품 조회
SELECT *
FROM Products
ORDER BY ProductID DESC;

# 2302.71
SELECT SUM(Price)
FROM Products;

# 29.148228
SELECT AVG(Price)
FROM Products;

# 0으로 값을 넣고 싶다?
# IFNULL: NULL 인경우 다른 값으로 조회
# 원본이 바뀐것은 아님.
SELECT PRODUCTID,
       PRODUCTNAME,
       SUPPLIERID,
       IFNULL(CATEGORYID, '미정') CATEGORYID,
       IFNULL(UNIT, '없다')       UNIT,
       IFNULL(Price, 0)         PRICE
FROM Products
ORDER BY ProductID DESC;

# 2302.71
SELECT SUM(Price)
FROM Products;

# 28.866364
SELECT AVG(Price)
FROM Products;

# 29.148228 -> 28.135570
SELECT AVG(IFNULL(Price, 0))
FROM Products;

# 연습
# 카테고리 테이블 조회, description이 null이면 '정해지지 않음'으로 조회
SELECT categoryid, categoryname, IFNULL(description, '정해지지 않음') description
FROM Categories
ORDER BY CategoryID DESC;


# description 컬럼으로 COUNT() 함수 결과를 조회, NULL 도 count에 포함 되도록
SELECT COUNT(ifnull(Description, '')) count
FROM Categories;


