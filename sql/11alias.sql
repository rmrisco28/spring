# ALIAS (AS) 컬럼이나 테이블에 별칭 주기
SELECT CustomerName AS Name, ContactName AS Contact
FROM Customers;

# AS: 생략 가능
SELECT CustomerName Name, ContactName Contact
FROM Customers;

#
SELECT AVG(Price)
FROM Products;

SELECT AVG(Price) AS 평균가격
FROM Products;

#AS 생략 가능
SELECT AVG(Price) 평균가격
FROM Products;


# 별칭에 공백(띄어쓰기 있을경우 ``, '', "" 사용 가능
SELECT AVG(Price) AS '평균 가격'
FROM Products;
SELECT AVG(Price) `평균 가격`
FROM Products;

# 테이블에 별칭 주기
SELECT p.ProductName, c.CategoryName
FROM Products AS p,
     Categories AS c;

# AS 생략 가능
SELECT p.ProductName, c.CategoryName, p.Price
FROM Products p,
     Categories c;

# 리뷰 각 페이지당 20개씩, 마지막 페이지가 8개라는 사실도 보여줄 수 있어야 함.
# 컨트롤러 15

###############################
# 페이징 연습용 쿼리
###############################
# 대량의 고객 정보 입력
INSERT INTO Customers
# *표 말고 전체 컬럼을 선택하고 customerID 지우기
    (CustomerName, ContactName, Address, City, PostalCode, Country)
SELECT CustomerName, ContactName, Address, City, PostalCode, Country
FROM Customers;

SELECT COUNT(*)
FROM Customers;

# 페이지 번호를 페이징 하는 방법


# 대량의 상품 정보 입력
INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
SELECT ProductName, SupplierID, CategoryID, Unit, Price
FROM Products;

SELECT COUNT(*)
FROM Products;




