-- INITCAP() 

-- #4101
SELECT INITCAP('pretty girl')
FROM dual;

-- LOWER(), UPPER()

SELECT LOWER('Hello Oracle') FROM dual;

-- #4103
SELECT 
	name 이름, id, 
	lower(id) 소문자, upper(id) 대문자
FROM t_student
WHERE deptno1 = 201;

-- length()
-- #4104
-- WHERE 절에도 단일행 함수 사용 가능!

SELECT name 이름, id, LENGTH(id) 글자수
FROM t_student
WHERE LENGTH(id) >= 9;

-- concat()

--SELECT name || position
-- #4106
SELECT concat(name, position)
FROM t_professor
WHERE deptno = 101;

-- SUBSTR() 함수
SELECT substr('ABCDE', 2, 3) FROM dual;

SELECT substr('ABCDE', 20, 3) FROM dual;  -- null 결과  (에러 아님)

-- #4107
-- t_student 테이블 : 
-- jumin 칼럼을 사용해서 
-- 1전공(deptno1)이 101번인 학생의 이름과 생년월일 출력 / substr() 사용

SELECT * FROM t_student;

SELECT name, substr(jumin, 1, 6) 생년월일
FROM t_student WHERE deptno1 = 101
;


-- #4108
SELECT name, substr(jumin, 1, 6) 생년월일
FROM t_student
-- WHERE substr(jumin, 3, 2) = '08'
WHERE jumin LIKE '__08%'
;


-- INSTR()

SELECT INSTR('A*B*C*', '*') FROM dual;
SELECT INSTR('A*B*C*', '*', 1) FROM dual; -- 2
SELECT INSTR('A*B*C*', '*', 1, 2) FROM dual; -- 4
SELECT INSTR('A*B*C*', '*', 3, 2) FROM dual;   -- 6
SELECT INSTR('A*B*C*', '*', -4, 1) FROM dual;  -- 2  음수면 음의 방향으로 검색   
SELECT INSTR('A*B*C*', '*', -4, 2) FROM dual; -- 0   없으면 0

-- #4110
SELECT * FROM T_STUDENT;

SELECT name, tel, instr(tel, ')', 1, 1) AS 위치
FROM T_STUDENT
WHERE deptno1 = 101;

-- [실습] #4111
-- t_student 테이블 : 1전공이 101 인 학생의 이름과 전화번호, 지역번호를 출력하세요. 
-- 지역번호는 숫자만!  / substr(), instr() 사용
SELECT name , tel, SUBSTR(tel, 1, INSTR(tel, ')')-1) 지역번호 
FROM t_student 
WHERE deptno1=101;


-- LTRIM(), RTRIM(), TRIM()
SELECT 
	'     슈퍼슈퍼슈가맨',
	LTRIM('     슈퍼슈퍼슈가맨'),
	LTRIM('슈퍼슈퍼슈가맨', '슈퍼'),  -- 가맨
	RTRIM('우측공백제거     '),
	TRIM('   좌우공백제거    ')
FROM dual;


-- #4117
SELECT * FROM t_dept2;

SELECT dname, RTRIM(dname, '부') FROM t_dept2;

-- REPLACE() 
SELECT REPLACE ('슈퍼맨 슈퍼걸', '슈퍼', '파워')
FROM dual;

SELECT
	'ab cd ef', REPLACE('ab cd ef', ' ', '')
FROM dual;

-- #4118
SELECT name, REPLACE(name, substr(name, 1, 1), '#') 학생
FROM t_student
WHERE deptno1 = 102
;


-- [실습] #4119
-- t_student 테이블에서 101번 학과(deptno1) 의 학생들의 이름을 출력하되 
-- 가운데 글자만 ‘#’  으로 표시되게 출력하세요 / replace() , substr()사용
SELECT REPLACE(name, substr(name, 2, 1), '#') 학생
FROM t_student
WHERE deptno1 = 101;

-- [실습] #4120
-- t_student 테이블에서 1전공(deptno1) 이 101번인 학생들의 
-- 이름과 주민등록번호를 출력하되 주민등록번호의 뒤 7자리는 ‘*’ 로 표시되게 출력

col name for a10;
col 주민번호 for a20;

SELECT name, REPLACE(jumin, substr(jumin, 7, 7), '*******') 주민번호
FROM t_student
WHERE deptno1 = 101;

-- [실습] #4121
-- t_student 테이블에서 다음 과 같이 1전공(deptno1) 이 102번인 학생들의 
-- 이름(name) 과 전화번호(tel), 
-- 전화번호에서 국번 부분만 ‘#’ 처리하여 출력하세요.  
-- 단 모든 국번은 3자리로 간주합니다.
-- 힌트) replace() / substr() / instr() 사용
col 전화번호 for a20;

SELECT name, tel,
replace(tel, substr(tel, instr(tel, ')', 1) + 1, 3), '###') 전화번호
FROM t_student
WHERE deptno1 = 102;
















