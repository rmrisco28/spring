USE mydatabase;

# 게시물을 작성하는 어플을 만든다고 상상

# 게시물
# 제목, 본문, 작성일시, 회원ID
CREATE TABLE table43
(
    id               INT PRIMARY KEY Auto_Increment,
    title            VARCHAR(255),
    content          VARCHAR(10000),
    create_at        DATETIME,
    table44_username VARCHAR(20),
    FOREIGN KEY (table44_username) REFERENCES table44 (username)
);


DROP TABLE table43;

# 회원
# ID, PW, 자기소개
CREATE TABLE table44
(
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    notes    VARCHAR(5000)
);


SELECT *
FROM table44;

DROP TABLE table44;


# 1대 N 관계,

# 또 다른 관계

# 1대 1 관계 (잘 보이진 않음)
# 직원 정보
CREATE TABLE table45(
    id INT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(20),
    hire_date DATE,
    school VARCHAR(20),

);

# 직원 연봉
CREATE TABLE table46(
    id INT PRIMARY KEY ,
    salary INT,
    FOREIGN KEY (id) REFERENCES table45(id)
)

# 이 테이블에 접근하는 모든 사람이 연봉에 접근하지 않았으면 할 때
# 민감한 정보를 공유하고 싶지 않을 때
# 같은 ID 값을 공유하게 되면서 실행된다.

# N 대 N 관계
# 예시) 한 수업에 여러 학생이 들을 수 있는 상황
CREATE TABLE table47(
    id INT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(20),
    info VARCHAR(20)
);


CREATE TABLE table48(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    schedule VARCHAR(20),
    info VARCHAR(20)
);
# 학생 입장에서 봤을때 여러 수업을 들 수 있다.
# 수업도 여러 학생이 들을 수 있다.
# 서로 foregn key를 가질 수 없다.
# 대신 중간 테이블을 가져야 한다. (연결테이블)
# 학생 수업(연결, 조인, 중간 테이블)
CREATE TABLE table49(
    # 부가적인 저보가 있다면 다른 프라이머리키가 있는게 좋다.(아닐때도 있음)
    table47_id INT,
    table48_id INT,

    PRIMARY KEY (table47_id, table48_id),
    FOREIGN KEY (table47_id) REFERENCES table47(id),
    FOREIGN KEY (table48_id) REFERENCES table48(id)
);

# 연습
# 다대다 테이블 만들어보기
# 50,51,52

CREATE TABLE table50
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    book_name VARCHAR(20),
    write_day DATE,
    genre     VARCHAR(20)
);

CREATE TABLE table51
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    reader     VARCHAR(20),
    read_day   DATE,
    read_count INT
);

CREATE TABLE table52(
    table50_id INT,
    table51_id INT,

    PRIMARY KEY (table50_id, table51_id),
    FOREIGN KEY (table50_id) REFERENCES table50(id),
    FOREIGN KEY (table51_id) REFERENCES table51(id)


)











