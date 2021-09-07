-- Non-Equi Join

-- #6201
SELECT * FROM t_customer;
SELECT * FROM t_gift;

-- ORACLE 구문
SELECT c.c_name "고객명", c.c_point "POINT", g.g_name "상품명"
FROM t_customer c, t_gift g
WHERE c.C_POINT BETWEEN g.G_START AND g.G_END 
;

-- ANSI 구문
SELECT c.c_name "고객명", c.c_point "POINT", g.g_name "상품명"
FROM t_customer c JOIN t_gift g
	ON c.C_POINT BETWEEN g.G_START AND g.G_END 
;

-- #6202

-- ORACLE 구문
SELECT g.g_name "상품명", count(*) "필요수량"
FROM t_customer c, t_gift g
WHERE c.C_POINT BETWEEN g.G_START AND g.G_END 
GROUP BY g.g_name
;
-- ANSI 구문
SELECT g.g_name "상품명", count(*) "필요수량"
FROM t_customer c JOIN t_gift g
	ON c.C_POINT BETWEEN g.G_START AND g.G_END 
GROUP BY g.g_name
;

-- #6204
SELECT	c.c_name "고객명", c.c_point "POINT", g.g_name "상품명"
FROM t_customer c, t_gift g
WHERE g.g_start <= c.c_point AND g.g_name = '산악용자전거'
;

-- ANSI
SELECT	c.c_name "고객명", c.c_point "POINT", g.g_name "상품명"
FROM t_customer c JOIN t_gift g
	ON g.g_start <= c.c_point AND g.g_name = '산악용자전거'
;

-- #6203
-- ORACLE
SELECT s.name "학생이름", e.total "점수", h.grade "학점"
FROM t_student s, t_exam01 e, t_credit h
WHERE s.STUDNO = e.STUDNO AND e.total BETWEEN h.MIN_POINT  AND h.MAX_POINT 
;
-- ANSI
SELECT s.name "학생이름", e.total "점수", h.grade "학점"
FROM t_student s
	JOIN t_exam01 e ON s.STUDNO = e.STUDNO
	JOIN t_credit h ON  e.total BETWEEN h.MIN_POINT  AND h.MAX_POINT 
;

-- #6205

SELECT e.name "이름",
	TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(e.BIRTHDAY, 'YYYY') + 1 "현재나이",
	e.post "현재직급",
	p.post "예상직급"
FROM t_emp2 e, t_post p
WHERE (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(e.BIRTHDAY, 'YYYY') + 1)
		BETWEEN p.S_AGE AND p.E_AGE 
;

-- ANSI
SELECT e.name "이름",
	TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(e.BIRTHDAY, 'YYYY') + 1 "현재나이",
	e.post "현재직급",
	p.post "예상직급"
FROM t_emp2 e 
	JOIN t_post p ON (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(e.BIRTHDAY, 'YYYY') + 1)
		BETWEEN p.S_AGE AND p.E_AGE 
;


-----------------------------------------------------------------
-- OUTER JOIN

SELECT s.name, p.name
FROM t_student s, t_professor p
WHERE s.profno = p.PROFNO
;
-- #6206
SELECT s.name, p.name
FROM t_student s LEFT OUTER JOIN t_professor p ON s.profno = p.PROFNO
;

-- #6207
SELECT s.name, p.name
FROM t_student s RIGHT OUTER JOIN t_professor p ON s.profno = p.PROFNO
;

--- #6208
SELECT s.name, p.name
FROM t_student s FULL OUTER JOIN t_professor p ON s.profno = p.PROFNO
;


-- 카티션곱 == CROSS JOIN 결과
SELECT s.name, p.name
FROM t_student s, t_professor p
;

SELECT s.name, p.name
FROM t_student s CROSS JOIN t_professor p
;

-- SELF JOIN
-- #6209

SELECT d1.dname 부서명, d2.dname 상위부서명
FROM t_dept2 d1, t_dept2 d2
WHERE d1.PDEPT = d2.dcode
;

-- #6210)
--t_professor 테이블 : 교수번호, 교수이름, 입사일, 
--그리고 자신보다 입사일 빠른 사람의 인원수를 출력하세요, 
--단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요
--hint: left outer 사용 
--         / 그룹함수 사용

-- left outer 를 사용하는 이유는 '조인형' 교수 때문.
-- 조인형 교수보다 먼저 입사한 사람이 없기 때문에 일반 join으론 하면 조인형 교수가 join 에서 빠져버린다.

-- 우선 자신보다 빨리 입사하신분들을 나열해보자.
SELECT a.name "교수명", a.hiredate, b.name, b.hiredate
FROM t_professor a JOIN t_professor b
     ON a.hiredate > b.hiredate
;

SELECT a.PROFNO "교수번호", a.name "교수명", 
	TO_CHAR(a.hiredate, 'YYYY-MM-DD') 입사일,
	count(b.hiredate) "빠른사람"
FROM t_professor a LEFT OUTER JOIN t_professor b
     ON a.hiredate > b.hiredate
GROUP BY a.PROFNO, a.name, a.hiredate
--ORDER BY "빠른사람"  -- ORDER BY 는 '별칭(alias)'  사용 가능.
ORDER BY 4   -- ORDER BY 는 index  사용 가능.
;

































