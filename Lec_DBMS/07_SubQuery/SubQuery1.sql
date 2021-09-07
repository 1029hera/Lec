-- #7101

SELECT sal FROM t_emp WHERE ename = 'SCOTT';

SELECT ename, sal
FROM t_emp
WHERE
	sal > (SELECT sal FROM t_emp WHERE ename = 'SCOTT')
;


-- #7102
SELECT max(height) FROM t_student;

SELECT name, height
FROM t_student
WHERE height = (SELECT max(height) FROM t_student);


-- 1. 단일행 쿼리
-- 결과가 한개 1행만 나오는 것.
-- 단일행 Sub Query 의  WHERE 에서 사용되는 연산자
-- = , <> , >, >= , <, <= 

--#7103)연습
--t_student, t_department 테이블 사용하여 
--이윤나 학생과 1전공(deptno1)이 동일한 학생들의 
--이름(name)과 1전공이름(dname)을 출력하세요

-- subquery 는 먼저 테스트 해보자 
--SELECT deptno1 FROM t_student WHERE name='이윤나'	
	
SELECT 
	s.name "학생이름", 
	d.dname "1전공"
FROM 
	t_student s, t_department d
WHERE 
	s.deptno1 = d.deptno
	AND 
	s.deptno1 = ( SELECT deptno1 
		FROM t_student
		WHERE name='이윤나');
		
-- #7104) 연습
--t_professor, t_department 테이블 : 
--입사일이 송도권 교수보다 나중에 입사한 사람의 
--이름과 입사일, 학과명을 출력하세요

SELECT 
	p.name "교수명", 
	TO_CHAR(p.hiredate, 'YYYY-MM-DD') "입사일", 
	d.dname "학과명"
FROM 
	t_professor p, t_department d
WHERE 
	p.deptno = d.deptno
	AND 
	p.hiredate > ( --송도권 교수 입사일
		SELECT hiredate 
		FROM t_professor
		WHERE name = '송도권');

			
-- #7105) 연습
--t_student 테이블 : 
--1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 
--이름과 몸무게를 출력하세요

SELECT 
	name "이름", 
	weight "몸무게"
FROM 
	t_student
WHERE 
	weight > ( 
		SELECT avg(weight)
		FROM t_student
		WHERE deptno1=101
		);
			
			
--#7106) 연습
--t_professor 테이블에서 
--심슨 교수와 같은 입사일에 입사한 교수 중, 
--조인형 교수보다 월급을 적게 받는 교수의 
--이름과 급여, 입사일을 출력하세요

	
SELECT 
	name "이름", 
	pay "급여", 
	hiredate "입사일"
FROM 
	t_professor
WHERE 
	hiredate = 
			( SELECT hiredate
			FROM t_professor
			WHERE name = '심슨')
	AND 
	pay < ( 
		SELECT pay
		FROM t_professor
		WHERE name = '조인형'
	);

