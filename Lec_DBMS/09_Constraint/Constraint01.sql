-- 제약조건

SELECT * FROM t_dept2;

-- 제약조건을 컬럼 정의와 함께 명시하는 방법
DROP TABLE t_emp4 CASCADE CONSTRAINT;  -- 테이블 삭제시 제약조건도 함께 삭제
CREATE TABLE t_emp4(
	no NUMBER(4) PRIMARY KEY,
	name VARCHAR2(10) NOT NULL,
	jumin VARCHAR2(13) NOT NULL UNIQUE,
	area NUMBER(1) CHECK(area < 5),
	deptno VARCHAR2(6) REFERENCES t_dept2(dcode)
)

-- 제약조건을 별도의 항목으로 설정 가능.
DROP TABLE t_emp4 CASCADE CONSTRAINT;  -- 테이블 삭제시 제약조건도 함께 삭제
CREATE TABLE t_emp4(
	no NUMBER(4),
	name VARCHAR2(10) NOT NULL,
	jumin VARCHAR2(13) NOT NULL,
	area NUMBER(1),
	deptno VARCHAR2(6),
	PRIMARY KEY(no),
	UNIQUE(jumin),
	CHECK(area < 5),
	FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
)



