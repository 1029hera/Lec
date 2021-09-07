-- 계층형 쿼리 (Hierarchical Query)

SELECT * FROM t_dept2;

SELECT LPAD(dname, 10, '*') FROM t_dept2;

-- LEVEL
SELECT dname, LEVEL
FROM t_dept2
CONNECT BY PRIOR dcode = pdept
-- START WITH dcode = 0001;
START WITH dcode = 1000;
;

/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

SELECT dname, LEVEL
FROM t_dept2
CONNECT BY  dcode = PRIOR pdept
-- START WITH dcode = 0001;   --  결과) 사장실만 달랑~
START WITH dcode = 1011; -- 영업4팀 부터.. - 영업기획팀 - 영어부 - 사장님



SELECT LPAD(dname, LEVEL * 6, '*') 부서명
FROM t_dept2
CONNECT BY  PRIOR dcode = pdept
START WITH dcode = 0001;

-- CONNECT BY 절에는 subQuery 사용 불가!
-- 계층형 쿼리가 수행되는 순서
--  1. START WITH 절에 시작조건을 찾습니다.
--  2. CONNECT BY 절에 연결조선을 찻습니다.
--  3. WHERE 절의 조건을 검색


SELECT * FROM t_emp2;

SELECT e.name || ' ' || d.dname || ' ' || NVL(e.post, '사원')
FROM t_emp2 e, (SELECT dname, dcode, pdept FROM t_dept2) d
WHERE e.deptno = d.dcode
;


SELECT LPAD(e.name || ' ' || d.dname || ' ' || NVL(e.post, '사원'), LEVEL * 22, '-')
FROM t_emp2 e, (SELECT dname, dcode, pdept FROM t_dept2) d
WHERE e.deptno = d.dcode
CONNECT BY PRIOR e.empno = e.pempno
START WITH e.empno = 20000101
;







