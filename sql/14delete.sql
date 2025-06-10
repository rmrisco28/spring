# DELETE: 특정 행(row, record) 를 삭제
# 레코드를 삭제하면 데이터를 살리기 쉽지 않다.

DELETE
FROM Customers
WHERE CustomerID = 105;
# 테이블의 특정 행을 지워야하는데, 선택시에는 SELECT의 WHERE를 썼는데
# 동일하게 WHERE 사용하면됨

# Country가 null인 데이터 삭제
DELETE
FROM Customers
WHERE Country IS NULL;

# 명심: 지우기 전에, 꼭 같은 WHERE절로 SELECT 해보기 ★중요★
SELECT *
FROM Customers
WHERE CustomerID = 100;

DELETE
FROM Customers
WHERE CustomerID = 100;

# WHERE 없이 삭제하면 모든 레코드가 삭제됨.
SELECT *
FROM Customers;

DELETE
FROM Customers;


SELECT *
FROm Customers
WHERE Country IS NULL;


SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# 연습
# 공급자 테이블에서 28, 29번 공급자 삭제하기
SELECT *
FROM Suppliers
WHERE SupplierID = 28
   OR SupplierID = 29;

DELETE
FROM Suppliers
WHERE SupplierID = 28
   OR SupplierID = 29;

SELECT *
FROM Suppliers
ORDER BY SupplierID DESC;

# 공급자 테이블의 모든 레코드 삭제하기
DELETE
FROM Suppliers;
