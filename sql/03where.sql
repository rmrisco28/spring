# OR
SELECT *
FROM Customers
WHERE City = 'Barcelona'
   OR City = 'Bern'
   OR City = 'Lisboa';

#IN
SELECT *
FROM Customers
WHERE City IN ('Barcelona', 'Bern', 'Lisboa');

# 연습
# 미국, 영국, 스웨덴에 있는 고객들 조회
# 1,2,5 카테고리 ID인 상품들 조회
# 일본, 독일에 있는 공급자 조회(suppliers테이블)

SELECT *
FROM Customers
WHERE Country IN ('usa', 'uk', 'sweden');

SELECT *
FROM Products
WHERE CategoryID IN (1, 2, 5);

SELECT *
FROM Suppliers
WHERE Country IN ('germany', 'japan');


# AND
SELECT *
FROM Products
WHERE Price >= 50.00
  AND Price <= 59.99;

# BETWEEN AND
SELECT *
FROM Products
WHERE Price BETWEEN 50.00 AND 59.99;
# 두 값을 모두 포함한다.

# 연습: 1950년대 태어난 직원들 조회
# 1997년 7월에 주문한 주문 데이터 조회(Orders)

SELECT *
FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';

SELECT *
FROM Orders
WHERE OrderDate BETWEEN '1997-07-01' AND '1997-07-31';







