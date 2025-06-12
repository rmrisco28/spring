USE mydatabase;

CREATE TABLE table38
(
    id INT
);

INSERT INTO table38
    (id)
VALUES (9),
       (8),
       (7);

# 5개 행
SELECT *
FROM table34;
# 5개 행
SELECT *
FROM table35;
# 3개 행
SELECT *
FROM table38;

# 카트시안 곱이 일어나고 ON으로 값을 정리해야한다.
# 5 * 5 = 25 * 3 = 75의 레코드가 생성됨.
SELECT *
FROM table34 t34
         join table35 t35
         JOIN table38 t38;


# ON 대신 이렇게도 쓸 수 있다.
SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
         JOIN w3schools.Suppliers s
WHERE p.CategoryID = c.CategoryID
  AND p.SupplierID = s.SupplierID;

SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID;


# 공급자별 공급하는 상품 카테고리
SELECT s.SupplierName, c.CategoryName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY c.CategoryName;

# OrderID, 어떤 고객이 요청하고 어떤 직원이 처리했는지, 누가 배송했는지 알아보기
SELECT DISTINCT s.ShipperName, c.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
         JOIN w3schools.Shippers s
              ON o.ShipperID = s.ShipperID
ORDER BY s.ShipperName, c.CustomerName;


# 연습
# 1996년 7월 5일에 주문된 상품명 목록
# Orders, OrderDetails, Product
SELECT o.OrderDate, p.ProductName
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE OrderDate = '1996-07-05'
ORDER BY p.ProductName;

# 연습
# 상한두부가 나가버렸다.
# tofu 상품을 어떤 고객이 언제 주문 했는지 조회
# ORDERS(주문), Products(상품), Customers(고객), OrderDetails(주문 내용)
SELECT p.ProductName, c.CustomerName, o.OrderDate
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
WHERE p.ProductID = 14 #조건에 사용되는 컬럼들은 PK 사용할 수록 성능이 좋아짐
ORDER BY c.CustomerName, o.OrderDate;

# 우수 고객 선정 조회
# 고객별 주문 금액
# Orders, OrderDetails, Products, Customers
SELECT c.CustomerName, SUM(od.Quantity * p.Price) 합
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY 합 DESC
LIMIT 10;

# 연습
# 이번달 우수 직원 선정
# 1997-09월에 가장 많은 주문(가격기준)을 처리한 직원 조회
# Employees 직원, Orders 주문, OrderDetails 내역, Products 상품
SELECT e.EmployeeID, e.FirstName, e.LastName, sum(od.Quantity * p.Price) 합
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1997-09-01' AND '1997-09-30'
Group By e.EmployeeID
ORDER BY 합 DESC;











