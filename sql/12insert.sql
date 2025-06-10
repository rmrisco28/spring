SELECT COUNT(*)
FROM Customers;

# INSERT INTO: 새 데이터(record, row) 입력
INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
# 위 컬럼의 순서에 맞춰서 값을 넣어주면 된다.
VALUES (92, 'donald', 'trump', 'new york', 'CA', '1234', 'usa');
# VALUE를 써도되고, VALUES를 써도 된다.

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, PostalCode, Country, City)
# 순서가 맞지않으면 다른 값이 들어간다.
VALUES (93, 'elon', 'musk', 'la', 'TA', '5678', 'usa');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES (94, 'park', 'jisung', 'suwon', 'suwon', '9090', 'korea');

# 아직 배우진 않았지만
# 오른쪽 데이터 아이콘 눌러서 table 눌러보면, columns 버튼 눌러보면
# 열쇠모양 아이콘이 옆에 있습니다. 있다는것만 먼저 알고 계세요.
# 그 옆에 보면 auto increment(자동증가)가 있음.
# 직접 넣지 않아도 된다.

INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('son', 'hm', '강남', '강남', '8080', 'korea');

INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('cha', 'bum', '수원', '서울', '3030', 'korea');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# 연습
# categories 테이블에 새 레코드 2개 입력해보기

INSERT INTO Categories
    (CategoryName, Description)
    VALUE ('beef', 'cow');

INSERT INTO Categories
    (CategoryName, Description)
    VALUE ('meet', 'pig');

SELECT *
FROM Categories
ORDER BY CategoryID DESC;

# Products 테이블에 새 레코드 2개 입력해보기

INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
    VALUE ('what', '77', '5', '100kg', 30.00);

INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
    VALUE ('why', '88', '6', '1T', 50.00);

SELECT *
FROM Products
ORDER BY ProductID DESC;

INSERT INTO Customers
    (CustomerName)
VALUES ('손흥민');
# sql에서는 데이터를 넣을때 하나의 레코드 단위로 값이 들어가야함
# 특정 컬럼에 값을 넣었기 때문에, 들어가지 않는 나머지 값은 null 값이 들어간다.
# null: 값이 없다.

# 의도적으로 null을 넣을 수도 있다.
insert into Customers
    (CustomerName, ContactName)
    VALUE ('트럼프', NULL);

# null과 ''은 다르다.
insert into Customers
    (CustomerName, ContactName, Address)
    VALUE ('도날드', NULL, '');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;
# 우리는 mysql 쓰지만, oracle에서는 null이 '' 랑 같을 수 있으니, 매뉴얼을 확인하자

# 연습
# 카테고리 테이블에서 새 데이터를 넣기(Description은 Null로 남기기)
# 카테고리 테이블에서 새 데이터를 넣기(Description은 ''로 남기기)

INSERT INTO Categories
    (CategoryName, Description)
VALUES ('커피', null);

INSERT INTO Categories
    (CategoryName, Description)
VALUES ('cor', '');

SELECT *
FROM Categories
ORDER BY CategoryID DESC;


# DELETE: 기존 데이터 (record, row) 삭제

# UPDATE: 기존 데이터 수정
