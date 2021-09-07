-- dual 은 row 1개짜리 dummy table;
SELECT 'abcde' FROM dual;

SELECT 100 FROM dual;
SELECT 10 * 5 FROM dual;
SELECT 'hello', 100 / 3 FROM dual;

SELECT '안녕하세요' FROM dual;

-- 이클립스 단축키 사용
-- Lower case: CTRL+SHIFT+Y
-- Upper case: CTRL+SHIFT+X


-- SELECT - 데이터 조회/질의
-- SELECT [컬럼명 또는 표현식] FROM [테이블명, 뷰명]

-- ‘모든 컬럼’ 조회  :  * 사용 
SELECT * FROM t_emp;

SELECT empno, ename FROM t_emp;
SELECT ename, empno, empno, empno FROM t_emp;


SELECT * FROM T_PROFESSOR;  

SELECT name, '교수님 배고파요' FROM T_PROFESSOR;  

-- 컬럼 별칭(alias) 사용하여 출력
SELECT 
	studno "학생 학번", name 이름
FROM 
	T_STUDENT
;

SELECT
	empno 사원번호,
	ename 사원명,
	job 직업
FROM
	t_emp
;

SELECT
	deptno 부서#,
	dname 부서명,
	loc 위치
FROM 
	t_dept
;


-- DISTINCT
SELECT deptno FROM t_emp;
SELECT DISTINCT deptno FROM t_emp;

SELECT job FROM t_emp;
SELECT DISTINCT  job FROM t_emp;

-- || : 문자열 연결

SELECT name, position
FROM T_PROFESSOR ;

SELECT name || '-' ||POSITION AS 교수님명단 FROM t_professor;

-- 학생테이블(t_student)를 사용하여 
-- 모든 학생들이 
-- ‘서진수의 키는 180cm, 몸무게는 55kg 입니다’ 
-- 와 같은 형식으로 출력되도록 문자를 추가하고, 
-- 칼럼 이름은 ‘학생의 키와 몸무게’ 라는 별명으로 출력하세요	

SELECT  
	name || '의 키는' || 
	height || 'cm, ' || 
	'몸무게는 ' || weight || 
	'kg 입니다' "학생의 키와 몸무게"
FROM 
	t_student
;
