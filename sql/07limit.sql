# limit: 조회 레코드(행) 수 제한
SELECT *
FROM Customers
LIMIT 5;

# 가격이 높은 상품 5개 조회
SELECT *
FROM Products
ORDER BY Price DESC
LIMIT 5;

# 나이 많은 직원 2명 조회
SELECT *
FROM Employees
ORDER BY BirthDate
LIMIT 2;


# 연습: 2번 카테고리에서 가장 저렴한 상품 3개 조회
SELECT *
FROM Products
WHERE CategoryID = 2
order by price
LIMIT 3;


# 연습: 미국에 사는 고객 중 고객번호가 가장 높은 1명
SELECT *
FROM Customers
WHERE Country = 'usa'
order by CustomerID DESC
LIMIT 1;

# LIMIT size: 몇개 행
# LIMIT offset, size: offset부터 size 개 rows

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 10; # 1번부터 10번까지

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 0, 10; # 0번(인덱스) 1번부터 10번까지

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 10, 10; # 10번(인덱스) 11번부터 20번까지 (10개)

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 20, 10;
# 20번(인덱스) 21번부터 30번까지 (10개)


#91~82
SELECT *
FROM Customers
ORDER BY CustomerID DESC
LIMIT 0, 10;

#81~72
SELECT *
FROM Customers
ORDER BY CustomerID DESC
LIMIT 10, 10;


#71~62
SELECT *
FROM Customers
ORDER BY CustomerID DESC
LIMIT 20, 10;

# 연습: 가격이 두번째로 높은 상품명 조회
SELECT *
FROM Products
ORDER BY Price DESC
Limit 1,1;

# 연습: 세번째로 나이가 많은 직원명 조회
SELECT *
FROM Employees
ORDER BY BirthDate
limit 2,1;

# 연습: 1번 카테고리에서 두번째로 저렴한 상품명 조회
SELECT *
FROM Products
WHERE ProductID = 1
ORDER BY Price
# limit 1,1;


