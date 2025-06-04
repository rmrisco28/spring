# SELECT: 조회할 열(columns) 지정
# FROM: 테이블명 지정
# WHERE: 행(records)를 필터링

# * 모든 컬럼
SELECT *
FROM Customers;

# 지정된 열
SELECT CustomerName
FROM Customers;

SELECT CustomerName, Country
From Customers;

SELECT CustomerName, Country, City
From Customers;

# 나열된컬럼의 순서가 조회된 결과 순서와 같음
SELECT CustomerName, City, Country
From Customers;

# 미국에 사는 고객들 이름 조회
SELECT CustomerName
FROM Customers
WHERE Country = 'usa';

# 미국에 사는 고객들 이름, 국가, 도시 조회
SELECT Country, City, CustomerName
FROM Customers
WHERE Country = 'usa';


# 맥시코와 미국에 사는 고객들의 이름과 국가, 도시, 주소(address)조회
# 60년대 태어난 직원들 생일, 이름(lastName, firstName) 조회
# 가격이 10(포함)~20(미포함) 사이인 상품의 가격, 상품명, 카테고리 번호조회

SELECT CustomerName, Country, City, Address
FROM Customers
WHERE Country IN ('mexico', 'usa');

SELECT BirthDate, LastName, FirstName
FROM Employees
WHERE BirthDate BETWEEN '1960-01-01' AND '1969-12-31';

SELECT Price, ProductName, CategoryID
FROM Products
WHERE Price >= 10
  AND Price < 20;








