-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
-- SELECT 결과물중 n 번째 부터 m 개를 출력하고 싶다면?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT empno, ename, sal FROM t_emp;

-- 오라클이 자동으로 붙여주는 ROWNUM 객체 (행번호)
SELECT ROWNUM, empno, ename, sal FROM t_emp;

SELECT ROWNUM, empno, ename, sal FROM t_emp ORDER BY empno DESC;

-- 상위 5개만 보이기
SELECT ROWNUM, empno, ename, sal FROM t_emp 
WHERE ROWNUM <= 5
ORDER BY empno DESC;

-- SELECT 에 굳이 ROWNUM  없어도 동작.
SELECT empno, ename, sal FROM t_emp 
WHERE ROWNUM <= 5
ORDER BY empno DESC;

--- ROWNUM > 5  ?????????????????????????????????????????????????????
SELECT empno, ename, sal FROM t_emp 
WHERE ROWNUM > 5  -- 앙된다...
ORDER BY empno DESC;
-- rownum 조건범위가 1부터 포함안되면 곤란...


-- 한 페이지 당 5개 출력하는 상황
-- 1page : 1 <= ROWNUM <= 5
SELECT ROWNUM, empno, ename, sal FROM t_emp 
WHERE ROWNUM >= 1 AND ROWNUM < 1 + 5
ORDER BY empno DESC;

-- 2page : 6 <= ROWNUM <= 10
SELECT ROWNUM, empno, ename, sal FROM t_emp 
WHERE ROWNUM >= 6 AND ROWNUM < 6 + 5
ORDER BY empno DESC;  -- 안나와...

---------------------------------------------------------------------
SELECT T.*
FROM (SELECT empno, ename, sal FROM t_emp ORDER BY empno DESC) T
;


SELECT ROWNUM AS RNUM, T.*
FROM (SELECT empno, ename, sal FROM t_emp ORDER BY empno DESC) T
;


SELECT * FROM
(
	SELECT ROWNUM AS RNUM, T.*
	FROM (SELECT empno, ename, sal FROM t_emp ORDER BY empno DESC) T
)
WHERE RNUM >= 11 AND RNUM < 11 + 5
;








































