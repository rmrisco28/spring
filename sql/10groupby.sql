# GROUP BY: 특정 컬럼 값 기준으로 결과를 나눔

SELECT CategoryID, SUM(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;
# GROUP BY 에 작성한 카테고리를 SELECT 에도 적어주는게 일반적이다. (보기좋게)

# 연습
# 카테고리별 상품 가격의 평균
SELECT CategoryID, AVG(price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;


# 카테고리별 최고 상품 가격
SELECT CategoryID, Max(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;


# 카테고리별 최저 상품 가격
SELECT CategoryID, MIN(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;

# 카테고리별 상품의 갯수
SELECT CategoryID, COUNT(*)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;


# 국가별 고객 수
SELECT country, COUNT(*)
FROM Customers
GROUP BY Country
ORDER BY Country;

# 국가, 도시별 고객 수
SELECT Country, City, COUNT(*)
FROM Customers
GROUP BY Country, City
ORDER BY Country, City;

# 공급자와 카테고리별
SELECT SupplierID, CategoryID, COUNT(*)
FROM Products
GROUP BY SupplierID, CategoryID
ORDER BY SupplierID, CategoryID;

# 집계함수 사용 후 조건 설정
# 국가별 조회
SELECT Country, COUNT(*)
FROM Customers
GROUP BY Country;

# 조회 후, 조건을 걸고 싶은 경우,
# 나중에 배울것이고 일단은 몰라도 됨.
# 조회 결과를 봤는데 보인 테이블을 서브 쿼리로 쓰는 방법

# 서브쿼리 사용 (나중에)
SELECT *
FROM (SELECT Country, COUNT(*) AS C
      FROM Customers
      GROUP BY Country) T
WHERE C >= 10;

# Having: 집계 함수 사용 후 결과 FILTERING (꼭 집계 후 사용 가능)
SELECT Country, COUNT(*)
FROM Customers
GROUP BY Country
HAVING COUNT(*) >= 100;

# having절 쓸때 집계함수 쓰는데, 같은 함수를 또 쓰기 귀찮으니
# AS: 컬럼(또는 TABLE)의 별칭
SELECT Country, COUNT(*) AS 고객수
FROM Customers
GROUP BY Country
HAVING 고객수 >= 10;

# 평균 상품 가격이 50보다 큰 카테고리들 조회
SELECT CategoryID, AVG(Price) AS 평균
FROM Products
GROUP BY CategoryID
HAVING 평균 > 50;

# 연습
# 고객 수가 1명인 국가들 조회
SELECT Country, COUNT(*) AS 고객수
FROM Customers
GROUP BY Country
HAVING 고객수 = 1;


# 상품 평균가격이 30미만인 카테고리 조회
SELECT CategoryID, AVG(Price) AS 평균
FROM Products
GROUP BY CategoryID
HAVING 평균 < 30;


# 100건 이상 처리한 직원 조회(Orders, EmployeeID
SELECT EmployeeID, COUNT(*) AS 처리건
FROM Orders
GROUP BY EmployeeID
HAVING 처리건 > 100
ORDER BY EmployeeID;


