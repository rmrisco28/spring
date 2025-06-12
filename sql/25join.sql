USE mydatabase;

CREATE TABLE table39
(
    col1 INT
);

CREATE TABLE table40
(
    col_a INT
);

INSERT INTO table39
    (col1)
VALUES (1),
       (2),
       (3),
       (4),
       (5);

INSERT INTO table40
    (col_a)
VALUES (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9);

DROP table table39;

# cartesian pre
SELECT *
FROM table39
         JOIN table40;

# inner join
# 둘다 있는 것만 합친다.
SELECT *
FROM table39
         JOIN table40
              On table39.col1 = table40.col_a;

# left (outer) join
# 왼쪽 테이블의 값을 기준으로 오른쪽에 값인 없는 자리에 null로 채워진다.
SELECT *
FROM table39
         LEFT OUTER JOIN table40
                         On table39.col1 = table40.col_a;

# right (outer) join
# 오른쪽 테이블의 값을 기준으로 왼쪽에 값인 없는 자리에 null로 채워진다.
SELECT *
FROM table39
         RIGHT OUTER JOIN table40
                          On table39.col1 = table40.col_a;

# 테이블 39
ALTER TABLE table39
    ADD COLUMN name VARCHAR(10);

SELECT *
FROM table39;

ALTER TABLE table40
    ADD COLUMN toy VARCHAR(20);

SELECT *
FROM table40;

SELECT *
FROM table39
         RIGHT JOIN table40
                    On table39.col1 = table40.col_a;

# null 값으로 어떻게 사용 할 수 있을까?
# 장난감이 있는 사람은 inner join

# 장난감 있는 사람 + 장난감 없는 사람
# 장난감이 없는 사람들은
SELECT *
FROM table39
         LEFT JOIN table40
                   On table39.col1 = table40.col_a;

# LEFT JOIN은 ~가 없는 데이터를 조회할 때 사용.
SELECT *
FROM table39
         LEFT JOIN table40
                   On table39.col1 = table40.col_a
WHERE col_a IS NULL;

# 주인이 있는 장난감 + 주인이 없는 장남감
# 주인이 없는 장난감
SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = table40.col_a
WHERE col1 IS NULL;


# 주문한적 없는 고객
SELECT *
FROM w3schools.Customers c
         LEFT JOIN w3schools.Orders o
                   ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL;

DELETE
FROM w3schools.Orders
WHERE EmployeeID IN (2, 3);


# 주문을 처리한 적 없는 직원들 조회
SELECT e.EmployeeID, e.LastName, e.FirstName
FROM w3schools.Orders o
         RIGHT JOIN w3schools.Employees e
                    ON o.EmployeeID = e.EmployeeID
WHERE o.OrderID IS NULL;


# UNION (합집합)
SELECT col1
FROM table39
UNION
SELECT col_a
FROM table40;

SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = col_a

UNION

SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = col_a;



DELETE
FROM w3schools.OrderDetails
WHERE ProductID IN (10, 20, 30, 40);

# 연습
# 한번도 주분 된적 없는 상품들 이름 조회
SELECT p.ProductID, p.ProductName
FROM w3schools.OrderDetails od
         Right JOIN w3schools.Products p
                    ON od.ProductID = p.ProductID
WHERE od.OrderDetailID IS NULL
ORDER BY p.ProductID;





