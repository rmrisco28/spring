#WHERE: 행(레코드, 데이터, record, row)을 선택(filter) 걸러낸다.

# 9개 행
SELECT *
FROM Employees;

SELECT *
FROM Employees
WHERE EmployeeID = 3;

SELECT *
FROM Employees
WHERE EmployeeID < 4;

# 4개의 행
SELECT *
FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';

# 5개 행
SELECT *
FROM Employees
WHERE Notes LIKE '%BA%';

# 연산자
# = : 같다.
SELECT *
FROM Customers;

SELECT *
FROM Customers
WHERE Country = 'UK';

# 연습 미국인 고객들 조회
SELECT *
FROM Customers
WHERE Country = 'USA';

# 연습: 특정 도시에 있는 고객들 조회
SELECT *
FROM Customers
WHERE City = 'London';

# 대소문자 구분 없이 검색 가능.
SELECT *
FROM Customers
WHERE City = 'london';

# 비교 연산자
# !=, <> 같지 않다.
# >, >=, <, <=

SELECT *
FROM Customers
WHERE City != 'london';

SELECT *
FROM Customers
WHERE City <> 'london';

# 연습: 미국에 있지 않은 고객들조회,
# 스웨덴이 있지 않는 고객들 조회
SELECT *
FROM Customers
WHERE country != 'USA';

SELECT *
FROM Customers
WHERE country != 'sweden';

# >, >=, <, <=
SELECT *
FROM Customers
WHERE CustomerID < 5; # 숫자 형식은 보통 따옴표를 쓰지 않는다.

SELECT *
FROM Customers
WHERE CustomerID <= 5;

SELECT *
FROM Customers
WHERE CustomerID > 88;

SELECT *
FROM Customers
WHERE CustomerID >= 88;

SELECT *
FROM Customers
WHERE CustomerName >= 'T';

SELECT *
FROM Customers
WHERE CustomerName >= 't';

SELECT *
FROM Customers
WHERE CustomerName >= 'D';

SELECT *
FROM Customers
WHERE CustomerName >= 'd';

# 연습 :
# products(상품) 테이블 조회
# Price(가격)이 50미만인 상품들
# Price(가격)이 80이상인 상품들

SELECT *
FROM Products
WHERE Price < 50;

SELECT *
FROM Products
WHERE Price > 80;

# Orders(주문) 테이블 조회
# OrderDate(주문날짜() 가 1998년 1월 1일 이후(포함)인 데이터 조회

SELECT *
FROM Orders
WHERE OrderDate >= '1998.01.01';

# orderDate 주문날짜가 1996년 12월 31일 이전(포함)인 데이터 조회
SELECT *
FROM Orders
Where OrderDate <= '1996.12.31';

# 논리 연산자
# AND, OR, NOT

#NOT
SELECT *
FROM Customers
WHERE City = 'berlin'; # 1row

SELECT *
FROM Customers
WHERE City != 'Berlin'; # 90row

SELECT *
FROM Customers
WHERE NOT (City = 'berlin'); # 90row


SELECT *
FROM Customers
WHERE Not City = 'berlin';
# 90 row

# 연습: 미국에 살지 않는 고객들 조회
SELECT *
FROM Customers
WHERE Country = 'usa';

SELECT *
FROM Customers

WHERE not Country = 'usa';

# or 연산자
# 두개의 조건이 모두 만족 될때
SELECT *
FROM Customers
WHERE CustomerID = 1
   OR CustomerID = 2;

SELECT *
FROM Customers
WHERE Country = 'usa'
   OR Country = 'uk';

# 연습: CategoryID가 1 또는 7인상품들 조회
# 도시 Madrid 또는 Lisboa에 있는 고객들 조회

SELECT *
FROM Products
WHERE CategoryID = 1
   OR CategoryID = 7;


SELECT *
FROM Customers
WHERE City = 'madrid'
   OR City = 'lisboa'
   OR City = 'barcelona';

# AND
SELECT *
FROM Customers
WHERE CustomerID >= 10
  AND CustomerID < 20;


# 연습: 1950-01-01 ~ 1959-12-31 사이에 태어난 직원들 조회
# 50.00(포함) ~ 60.00(미포함) 가격인 상품들 조회
# 'B'로 시작하는 이름인 고객들 조회

SELECT *
FROM Employees
WHERE BirthDate >= '1950.01.01'
  AND BirthDate <= '1959.12.31';

SELECT *
FROM Products
WHERE Price >= 50
  AND Price < 60;

SELECT *
FROM Customers
WHERE CustomerName >= 'B'
  AND CustomerName < 'c';
#   AND Country = 'france';


