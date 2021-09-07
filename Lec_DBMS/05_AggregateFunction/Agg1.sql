SELECT * FROM t_professor;

SELECT count(profno) FROM t_professor;
SELECT count(*) FROM t_professor;  -- 전체 레코드(row) 의 개수
SELECT count(pay), count(bonus) FROM T_PROFESSOR; -- 그룹함수에서는 NULL 값은 (기본적으로) 계산에서 제외
SELECT sum(pay), avg(pay), sum(bonus), avg(bonus) FROM T_PROFESSOR ;
SELECT max(hiredate), min(hiredate) FROM t_emp;


SELECT
	avg(bonus), avg(nvl(bonus, 0))
FROM T_PROFESSOR;


-- 학과별 교수님들의 평균 보너스
SELECT deptno, avg(nvl(bonus, 0))
FROM t_professor
GROUP BY deptno
;

SELECT  * FROM t_professor;


-- #5101
SELECT deptno, POSITION, avg(nvl(pay, 0)) 평균급여
FROM t_professor
GROUP BY deptno, POSITION
ORDER BY 
	deptno ASC,
	POSITION ASC
;


-- 학과별 평균급여 출력, 평균급여가 450보다 많은 학과만 출력
SELECT deptno, avg(nvl(bonus, 0))
FROM t_professor
WHERE avg(nvl(bouns, 0)) > 450  -- group 함수는 where 절에서 사용 불가.
GROUP BY deptno
;

-- HAVING : 그룹함수에 조건 
SELECT deptno, avg(nvl(pay, 0))
FROM t_professor
GROUP BY deptno
HAVING avg(nvl(pay, 0)) > 450
;

-- <SELECT 순서>
-- SELECT
-- FROM
-- WHERE
-- GROUP BY
-- HAVING
-- ORDER BY

-- 실습
-- #5102)연습
-- t_emp 테이블: 매니저별(MGR)로 관리하는 직원들의 
-- ‘매니저’, ‘직원수’와 ‘급여총액’과 ‘급여평균’과 ‘교통비 (COMM) 평균’ 지급액 을 출력하세요.  
-- 단 사장님은 (job = president)제외

SELECT 
	mgr 매니저,
	COUNT(*) 직원수,
	SUM(sal) 급여총액,
	AVG(sal) 급여평균,
	AVG(NVL(comm, 0)) 교통비평균  
FROM t_emp 
WHERE job <> 'PRESIDENT' 
GROUP BY mgr;

-- #5103)연습
-- t_professor 테이블 :  직위가 정교수 혹은 조교수 인 분들 중에서 ‘과별(deptno)’로  
-- 과번호, 소속교수 총수, 근속일 평균, 급여평균, 보너스 평균을 출력해보세요

SELECT
	deptno, count(*) 총인원, 
	avg(sysdate - hiredate) 근속평균, 
	avg(pay) 급여평균, 
	avg(nvl(bonus,0)) 보너스평균 
FROM t_professor 
WHERE position LIKE '%교수'
GROUP BY deptno;

-- #5104)연습
-- t_student 테이블 : 학과별(deptno1) 로,  
-- 학과번호, 최대몸무게 - 최소몸무게 차이 값을 출력해보세요

SELECT 
	deptno1 학과 , 
	max(weight)-min(weight) 최대최소몸무게차 
FROM t_student  
GROUP BY deptno1;

-- #5105) 그 차이가 30 이상인것만 출력하려면?
SELECT 
	deptno1 학과 , 
	max(weight)-min(weight) 최대최소몸무게차 
FROM t_student  
GROUP BY deptno1
HAVING (max(weight)-min(weight)) >= 30
;



-- #5105

















