
-- FROM 절의 테이블에도 별칭(alias)를 줄수 있다.
-- 학생 20명
SELECT s.studno, s.name, s.deptno1
FROM t_student s;

-- 학과 12개
SELECT d.deptno, d.dname
FROM T_DEPARTMENT d;

-- 240개 : 카티션 곱
SELECT *
FROM t_student, T_DEPARTMENT
;


SELECT s.profno, p.profno
FROM t_student s, t_professor p
;


SELECT	s.studno, s.name, s.DEPTNO1,
	   d.deptno, d.dname
FROM t_student s, t_department d


-- 학생의 이름과 제1전공 학과이름을 출력

-- #6101
-- ORACLE 구문
SELECT	s.name "학생이름", s.deptno1 "학과번호", d.dname "학과이름"
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno;  -- JOIN 조건

-- ANSI SQL구문
SELECT	s.name "학생이름", s.deptno1 "학과번호", d.dname "학과이름"
FROM t_student s JOIN t_department d ON s.deptno1 = d.deptno;

-- 제2전공은?
-- null 은 JOIN  에 참여 안함
SELECT s.name, s.deptno2, d.dname
FROM t_student s, t_department d
WHERE s.deptno2 = d.deptno;

-- 연습 #6102)
-- t_student 테이블, t_professor 테이블 을 join하여 
-- ‘학생이름’, ‘지도교수번호’, ‘지도교수이름’ 을 출력하세요

-- ORACLE 구문
SELECT s.name "학생이름", s.profno "지도교수", p.name "지도교수이름" 
FROM t_student s, t_professor p 
WHERE s.profno = p.profno;

-- ANSI SQL 구문
SELECT s.name "학생이름", s.profno "지도교수", p.name "지도교수이름"
FROM t_student s JOIN  t_professor p ON s.profno = p.profno;

-- 3개 테이블 JOIN
-- #6103
-- t_student, t_department, t_professor 테이블 을 join 하여 
--  학생의 이름, 학과이름, 지도교수 이름  을 출력하세요
-- ORACLE 구문
SELECT s.name "학생이름", d.dname "학과이름", p.name "교수이름"
FROM t_student s, t_department d, t_professor p
WHERE s.deptno1 = d.deptno AND s.profno = p.profno
;
-- ANSI 구문
SELECT s.name "학생이름", d.dname "학과이름", p.name "교수이름"
FROM 
	t_student s 
	JOIN t_department d ON s.deptno1 = d.deptno
	JOIN t_professor p ON s.profno = p.profno
;


-- 연습 #6104
-- t_emp2 테이블과 t_post 테이블을 조회하여 
-- 사원의 이름과 직급, 현재연봉, 
-- 해당직급의 연봉의 하한금액(s_pay)과 
-- 상한금액(e_pay)을 출력하세요

select * from t_emp2;   -- 일단 함 보자
select * from t_post;

SELECT 
	e.name "사원이름", e.post "현재직급", e.pay "현재연봉",
	p.s_pay "하한금액", p.e_pay "상한금액"
FROM t_emp2 e, t_post p
WHERE e.post = p.post;

-- ANSI 구문
SELECT 
	e.name "사원이름", e.post "현재직급", e.pay "현재연봉",
	p.s_pay "하한금액", p.e_pay "상한금액"
FROM 
	t_emp2 e 
	JOIN t_post p
	ON e.post = p.post;

-- 연습 #6105
-- t_student - t_professor 테이블 join 하여 
-- 제1전공(deptno1) 이 101번인 학생들의 
-- 학생이름과 지도교수 이름을 출력하세요

SELECT 
	s.name "학생이름", 
	p.name "교수이름"
FROM 
	t_student s, 
	t_professor p
WHERE 
	s.profno = p.profno   -- 요건 join 조건
	AND s.deptno1 = 101;  -- 요건 검색 조건    ..   
	-- 단! 위 join 조건 보다 검색조건을 먼저 수행하게 된다.


-- ANSI Join 구문
SELECT 
	s.name "학생이름", 
	p.name "교수이름"
FROM 
	t_student s JOIN t_professor p
	-- ON s.profno = p.profno AND s.deptno1 = 101;
	ON s.profno = p.profno 
WHERE 
	s.deptno1 = 101;





















