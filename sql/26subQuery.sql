# sub query: 쿼리 안의 쿼리 읽기는 편함. (직관적)
# 대신 속도로는 join이 훨씬 빠르다.

SELECT p.ProductID, p.ProductName
FROM w3schools.OrderDetails od
         Right JOIN w3schools.Products p
                    ON od.ProductID = p.ProductID
WHERE od.OrderDetailID IS NULL
ORDER BY p.ProductID;

# 1. 주문 된적 있는 상품 목록
SELECT ProductID
FROM w3schools.OrderDetails;

# 2. 위 쿼리 결과에 없는 상품 ID들
SELECT *
FROM w3schools.Products
WHERE ProductID NOT IN (SELECT ProductID
                        FROM w3schools.OrderDetails);

# 상품과 카테고리 정보 조회
SELECT Products.ProductID, ProductName, c.CategoryName
FROM w3schools.Products
         JOIN w3schools.Categories c ON Products.CategoryID = c.CategoryID;

SELECT ProductID,
       ProductName,
       (SELECT CategoryName
        FROM w3schools.Categories c
        WHERE c.CategoryID = p.CategoryID) CategoryName
FROM w3schools.Products p;

# 연습
# 1996-08-01에 주문을 처리한 직원명 조회
# JOIN, SubQuery
SELECT e.FirstName, e.LastName, o.OrderDate
FROM w3schools.Orders o
         JOIN w3schools.Employees e
              ON e.EmployeeID = o.EmployeeID
WHERE o.OrderDate = '1996-08-01'
ORDER BY e.FirstName, e.LastName;


SELECT OrderDate,
       (SELECT *
        FROM w3schools.Employees)
FROM w3schools.Orders o
WHERE OrderDate = '1996-08-01';

# 상품의 평균 가격보다 높은 상품들 조회
# sub query
SELECT AVG(Price) 평균
FROM w3schools.Products;

SELECT ProductName, price
FROM w3schools.Products
WHERE Price > (SELECT AVG(Price) 평균
               FROM w3schools.Products)
ORDER BY Price DESC;

# 상품의 평균가격이 50 이상인 카테고리 번호
SELECT CategoryID, AVG(Price)
FROM w3schools.Products
GROUP BY CategoryID
HAVING AVG(Price) >= 50;


SELECT *
FROM (SELECT CategoryID, AVG(Price) avg
      FROM w3schools.Products
      GROUP BY CategoryID) p
WHERE avg >= 50;

# 연습
# 1996년 9월 평균 처리 금액보다 높은 금액을 처리한 직원 목록


SELECT FirstName, LastName, OrderDate, avg(Quantity * Price) 평균
FROM w3schools.Employees e
         JOIN w3schools.Orders o ON e.EmployeeID = o.EmployeeID
         JOIN w3schools.OrderDetails od ON o.OrderID = od.OrderID
         JOIN w3schools.Products p ON od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
GROUP BY FirstName, LastName, OrderDate
ORDER BY OrderDate;

SELECT FirstName, LastName, OrderDate
FROM (SELECT FirstName, LastName, OrderDate, avg(Quantity * Price) 평균
      FROM w3schools.Employees e
               JOIN w3schools.Orders o ON e.EmployeeID = o.EmployeeID
               JOIN w3schools.OrderDetails od ON o.OrderID = od.OrderID
               JOIN w3schools.Products p ON od.ProductID = p.ProductID
      WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
      GROUP BY FirstName, LastName, OrderDate
      ORDER BY OrderDate) 인원
WHERE (w3schools.OrderDetails.Quantity * w3schools.Products.Price) > 평균;


# 평균을 먼저 구하고, 평균보다 많이 처리한 직원을 찾기
SELECT (SELECT SUM(od.Quantity * p.Price)
        FROM w3schools.Orders o
                 JOIN w3schools.OrderDetails od
                      on o.OrderID = od.OrderID
                 JOIN w3schools.Products p
                      ON od.ProductID = p.ProductID
        WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30') /
       (SELECT COUNT(DISTINCT EmployeeID)
        FROM w3schools.Orders o
        WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30');


# 1. 총 처리 금액
SELECT SUM(od.Quantity * p.Price)
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              on o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';

# 2. 직원 수 나누고 8명
SELECT COUNT(DISTINCT EmployeeID)
FROM w3schools.Orders o
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';


# 3. 직원 별 처리 금액
SELECT e.EmployeeID, e.LastName, e.FirstName, SUM(od.Quantity * p.Price) sum
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              on o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Employees e
              ON e.EmployeeID = o.EmployeeID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
Group By e.EmployeeID, e.LastName, e.FirstName;


# 4. 평균 금액보다 높은 직원 조회
SELECT e.EmployeeID, e.LastName, e.FirstName, SUM(od.Quantity * p.Price) sum
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Employees e ON
    e.EmployeeID = o.EmployeeID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
GROUP BY e.EmployeeID
HAVING sum > (SELECT (SELECT SUM(od.Quantity * p.Price)
                      FROM w3schools.Orders o
                               JOIN w3schools.OrderDetails od
                                    ON o.OrderID = od.OrderID
                               JOIN w3schools.Products p
                                    ON od.ProductID = p.ProductID
                      WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30') /
                     (SELECT COUNT(DISTINCT EmployeeID)
                      FROM w3schools.Orders o
                      WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'))
ORDER BY EmployeeID;