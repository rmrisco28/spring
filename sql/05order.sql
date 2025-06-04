# ORDER BY 조회 결과 순서 결정

# 고객번호 오름차순
SELECT *
FROM Customers
ORDER BY CustomerID;

# 고객 이름 오름차순
SELECT *
FROM Customers
ORDER BY CustomerName;

# 연습: 상품 가격 오름 차순으로 조회
SELECT *
FROM Products
Order BY Price;

# 오더 바이로 원하는 순서를 정할 수 있는데
SELECT CustomerName, City, Country
FROM Customers
ORDER BY Country, City;

# 연습: 카테고리별, 가격별 오름차순으로 상품 조회
SELECT CategoryID, Price, ProductName
FROM Products
ORDER BY CategoryID, Price;

# 기본은 오름차순(ASCENDING, ASC)
SELECT CategoryID, Price, ProductName
FROM Products
ORDER BY CategoryID ASC, Price ASC;
# ASC 삭제 가능


# 내림차순(DESCENDING, DESC)
SELECT *
FROM Products
ORDER BY Price DESC;
# 가격이 높은 순으로

# 연습: 생일 역순 직원 조회 ( 젋은사람)
SELECT *
FROM Employees
Order By BirthDate DESC;

# 연습: 카테고리(오름차순), 가격(내림차순) 순서로 상품 조회
SELECT *
FROM Products
Order By CategoryID, Price DESC;

#
SELECT Country, City, CustomerName
FROM Customers
Order By Country, City;

# 컬럼의 순서를 사용
SELECT Country, City, CustomerName
FROM Customers
Order By 1, 2;

# 같은 내용
SELECT ProductName, CategoryID, Price
FROM Products
ORDER BY Price DESC;
# 컬럼 순서를 통해 정렬 할수 있다.
SELECT ProductName, CategoryID, Price
FROM Products
ORDER BY 3 DESC;