#like (~같은)
# %_:wildcard

# %: 0개 이상 아무거나
# _: 1개 이상 아무거나

#가장 많이 쓰는 키워드?

# u로 시작하는 국가에 있는 고객들 조회
SELECT *
FROM Customers
WHERE Country LIKE 'u%';


# a로 시작하는 고객명 조회
SELECT *
FROM Customers
WHERE CustomerName Like 'a%';

#a로 시작하고 a로 끝나는 고객명
SELECT *
FROM Customers
WHERE CustomerName LIKE 'a%a';


# to가 있는 고객명
SELECT *
FROM Customers
WHERE CustomerName LIKE '%to%';


# 10번대 고객
SELECT *
FROM Customers
WHERE CustomerID like '1_';


# 1997년 12월에 주문한 주문들
SELECT *
FROM Orders
WHERE OrderDate LIKE '1997-12-__';



# 연습
# 직원설명에 college가 포함된 직원들 조회
SELECT *
FROM Employees
WHERE Notes LIKE '%college%';


# C로 시작하는 상품명인 상품 조회
SELECT *
FROM Products
WHERE ProductName LIKE 'c%'
