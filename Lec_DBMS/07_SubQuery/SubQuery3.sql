CREATE TABLE test_emp_a (
	emp_id NUMBER,
	emp_name VARCHAR2(100)
);

CREATE TABLE test_emp_b (
	emp_id NUMBER,
	emp_name VARCHAR2(100)
);

SELECT * FROM test_emp_a;
SELECT * FROM test_emp_b;

INSERT INTO test_emp_a VALUES(101, '아이언맨');
INSERT INTO test_emp_b VALUES(201, '캡틴아메리카');

-- 동시에 여러개 테이블에 INSERT 하기
-- 다중테이블 INSERT 구문을 사용할때는 반드시 subquery 사용.

INSERT ALL
	INTO test_emp_a VALUES(102, '블랙위도우')
	INTO test_emp_b VALUES(202, '비젼')
SELECT * FROM dual;

-- subquery 로 INSERT
INSERT INTO TEST_EMP_A 
	(SELECT 400, '강감찬' FROM dual);


SELECT * FROM test_emp_a;
SELECT * FROM test_emp_b;

INSERT INTO test_emp_a
	(SELECT * FROM test_emp_a);

INSERT INTO test_emp_b(emp_id)
	(SELECT emp_id FROM test_emp_a)

SELECT * FROM phonebook;

INSERT INTO phonebook
	(SELECT * FROM PHONEBOOK); -- 에러 ,  PK중복

INSERT INTO phonebook(id, name, phone, email, regdate)
	(SELECT PHONEBOOK_SEQ.nextval, name, phone, email, SYSDATE FROM phonebook);

SELECT PHONEBOOK_SEQ.nextval, name, phone, email, SYSDATE FROM phonebook;
DELETE FROM PHONEBOOK WHERE id > 5;





