-- 다중행 SubQuery

-- #7107
SELECT * FROM t_emp2;
SELECT * FROM t_dept2;


-- 근무지역이 서울지사인 부서코드들은?
SELECT dcode FROM t_dept2 WHERE area = '서울지사';


SELECT empno, name, deptno
FROM t_emp2
WHERE deptno IN (SELECT dcode FROM t_dept2 WHERE area = '서울지사')
;


-- #7108
SELECT pay FROM t_emp2 WHERE post = '과장';


SELECT
	name "이름", post "직급", TO_CHAR(pay, '999,999,999') || '원' "연봉"
FROM t_emp2
WHERE pay >=ANY (SELECT pay FROM t_emp2 WHERE post = '과장')
;

-- #7109

SELECT name "이름", grade "학년", weight "몸무게"
FROM t_student
--WHERE weight <ALL (SELECT weight FROM t_student WHERE grade = 4 );
WHERE weight < (SELECT min(weight) FROM t_student WHERE grade = 4);


SELECT weight FROM t_student WHERE grade = 4;


-- 다중컬럼 SubQuery

-- #7201

SELECT grade, max(height) FROM t_student GROUP BY grade;


SELECT grade "학년", name "이름", height "키"
FROM t_student
WHERE (grade , height) IN (SELECT grade, max(height) FROM t_student GROUP BY grade);
;

-- #7202) 연습
-- t_professor , t_department 테이블 :  
-- 각 학과별로 입사일이 가장 오래된 교수의 
-- 교수번호와 이름, 입사일, 학과명을 출력하세요.  
-- 단 학과이름 순으로 오름차순 정렬하세요

SELECT p.profno "교수번호", p.name "교수명",
	    to_char(p.hiredate, 'YYYY-MM-DD') "입사일", d.dname "학과명"
FROM t_professor p, t_department d
WHERE p.deptno = d.deptno
AND (p.deptno, p.hiredate) IN ( SELECT deptno, MIN(hiredate)
					FROM t_professor
					GROUP BY deptno)
ORDER BY d.dname ASC;


--#7203) 연습
--t_emp2 테이블 : 
--직급별로 해당직급에서 최대 연봉을 받는 직원의 
--이름과 직급, 연봉을 출력하세요,  
--단, 연봉순으로 오름차순 정렬하세요

SELECT 
	name "사원명", 
	post "직급", 
	pay "연봉"
FROM 
	t_emp2
WHERE 
	(post, pay) IN 
		( SELECT post, MAX(pay)
			FROM t_emp2
			GROUP BY post )
ORDER BY pay;
				
				
--#7204) 연습
--t_emp2, t_dept2 테이블 : 
--각 부서별 평균 연봉을 구하고 
--그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 
--적게 받는 직원들의 
--부서명, 직원명, 연봉을 출력 하세요	
	
COL 직원명 FOR a6;

SELECT 
	d.dname "부서명", 
	e.name "직원명", 
	e.pay "연봉"
FROM 
	t_emp2 e, t_dept2 d
WHERE 
	e.deptno = d.dcode
	AND e.pay < ALL ( SELECT AVG(pay)
			FROM t_emp2
			GROUP BY deptno )
ORDER BY e.pay;


-- #7205
-- ** 오라클에선 '' 는 null 로 간주.
SELECT a.name "사원이름", NVL(a.post, ' ') "직급" , a.pay "급여"
FROM t_emp2 a
WHERE a.pay >= (
				SELECT avg(b.pay)
				FROM t_emp2 b WHERE NVL(a.post, ' ') = NVL(b.post, ' ')
				)
;

-- #7206
SELECT 
	name "사원이름", 
	(SELECT dname FROM t_dept2 d
		WHERE e.deptno = d.dcode ) "부서이름"
FROM t_emp2 e;






















