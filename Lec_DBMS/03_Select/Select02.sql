SELECT * FROM t_emp;

-- 직원이름, 현급여, 10%인상분
SELECT ename, sal, sal * 1.1 "10% 인상분"
FROM t_emp;

-- WHERE : 원하는 조건만 검색

-- SELECT [컬럼명 또는 표현식] 
-- FROM [테이블명, 뷰명]  
-- WHERE [조건절] ;

-- 직원 테이블(t_emp) 에서 직책이 salesman 인 사람만 조회 
SELECT * FROM t_emp WHERE job = 'SALESMAN';

--직원 테이블(t_emp) 에서 급여(sal) 가 2000보다 큰 사람의 
--이름(ename)과 급여(sal)를 출력하세요

SELECT ename, sal
FROM t_emp WHERE sal > 2000
;

SELECT ename, hiredate FROM t_emp
WHERE hiredate BETWEEN '1992/01/01' AND '2000/1/1';

SELECT ename, job FROM t_emp 
WHERE job IN ('CLERK', 'ANALYST');


SELECT ename, job FROM t_emp 
WHERE job NOT IN ('CLERK', 'ANALYST');

SELECT ename, job FROM t_emp 
WHERE job ='CLERK' OR job = 'ANALYST';

-- 연습
-- 교수님 (t_professor) 중에서
-- 급여 (pay) 가 300 보다 크고,
-- 직급 (position) 이 '정교수' 인 분들의
-- 이름(name), 급여(pay), 직급(position) 을 출력하세요
SELECT name, pay, position
FROM t_professor
WHERE pay > 300 AND position = '정교수';


SELECT * FROM t_professor;

-- 보너스(bonus)를 못받고 있는 
-- 교수님의 이름(name)과 직급(position)를 출력하세요
SELECT
	name, position
FROM 
	t_professor
WHERE
	bonus IS NULL;


--- 교수님 이름, 급여, 보너스, 급여+보너스
-- 주의!) null 값과 다른 값과의 연산 결과는 null 이다!!!
SELECT name, pay, bonus, pay + bonus
FROM t_professor;

-- 직원(t_emp) 에서 이름이 A로 시작하는 사람
SELECT * FROM t_emp;
SELECT * FROM t_emp WHERE ename LIKE 'A%'

-- 교수님중에 김씨 성을 가진 교수님의 이름 출력
SELECT name FROM t_professor
WHERE name LIKE '김%'
;

SELECT ename FROM t_emp WHERE ename LIKE '_A%';

-- ORDER BY
SELECT ename FROM t_emp
	WHERE ename LIKE '%L%'
	ORDER BY ename ASC;

CREATE TABLE student (
studno NUMBER(10) PRIMARY KEY,
name VARCHAR2(10) NOT NULL,
age NUMBER(3),
grade NUMBER CHECK(grade BETWEEN 1 AND 4),
majorno NUMBER(10),
FOREIGN KEY(majorno) REFERENCES major(majno)
 );



CREATE TABLE major (
majno NUMBER(10) PRIMARY KEY,
majname VARCHAR2(10) NOT NULL UNIQUE,
builno VARCHAR2(10) CONSTRAINT buildno_check CHECK (builno IN ('K301', 'A203', 'B306'))
);







