-- Java/Js :  "1" + 1  ==>  "11"
-- Python : "1" + 1  ==>  에러
-- SQL : '1' + 1 ==> 2  허걱???

-- 묵시적 자동 형변환 발생
SELECT '1' + 1 FROM dual;
SELECT to_number('1') + 1 FROM dual;
-- 묵시적 형변환은 편한것 같지만,
-- 튜닝에서 뜻하지 않은 성능정하를 가져올 수 있다.

SELECT '100', 100 FROM dual;

SELECT 1 + 'A' FROM dual;  --  에러


-- TO_CHAR()  (날짜 -> 문자)
SELECT
	SYSDATE,
	TO_CHAR(SYSDATE, 'YYYY') 연도4자리,
	TO_CHAR(SYSDATE, 'YY')  연도2자리,
	To_chAR(sYsDaTe, 'YEAR') 연도영문
FROM dual;

SELECT
	TO_CHAR(SYSDATE, 'MM') 월2자리
	, TO_CHAR(SYSDATE, 'MON') 월3자리
	, TO_CHAR(SYSDATE, 'MONTH') 월전체
	, TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월3자리
	, TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH') 월전체
FROM dual;


SELECT
	TO_CHAR(SYSDATE, 'MM') 월
	, TO_CHAR(SYSDATE, 'DD') 일2자리
	, TO_CHAR(SYSDATE, 'HH') 시간
	, TO_CHAR(SYSDATE, 'MI') 시간
	, TO_CHAR(SYSDATE, 'SS') 초
FROM dual;


-- #4302
SELECT name, birthday, TO_CHAR(birthday, 'YYYY-MM-DD'), TO_CHAR(birthday, 'YYYY"년"MM"월"DD"일"')
FROM t_student
;

-- TO_CHAR()  숫자 -> 문자

SELECT
	to_char(1234)
	, to_char(1234, '99999') "9하나당 1자리"
	, to_char(1234.1278, '9999.99') "소숫점이하2자리"
	, to_char(1234, '99,999')  "천단위 구분기호"
	, to_char(12345, '99,999')  "천단위 구분기호"
FROM dual;

-- #4303
-- t_professor 테이블에서 101번 학과 교수들의 이름(name), 연봉(pay) 를 출력하세요,
-- 단, 연봉은 (pay * 12) + bonus로 계산하고 천단위 구분기호로 표시하세요.
-- nvl / to_char() 사용

SELECT 
	name, TO_CHAR( (pay*12) + nvl(bonus, 0), '99,999') 연봉
FROM
	t_professor
WHERE
	deptno=101;

-- TO_NUMBER()

SELECT TO_NUMBER('123.44') FROM dual; 
SELECT TO_NUMBER('aaa') FROM dual;


-- TO_DATE() 날짜로 변환
SELECT
	'2012-01-01'
	, TO_DATE('2012-01-01', 'YYYY-MM-DD') to_date
FROM dual;


--#4304
--t_professor 테이블에서 2000년 이전에 입사한 교수명과 입사일,
--현재 연봉과 10% 인상 후 연봉을 출력하세요.
--연봉은 보너스(bonus)를 제외한 pay * 12 로 계산하고
--연봉과 인상후 연봉은 천단위 구분 기호를 추가하여 출력하세요

COL 입사일 FOR a10;
COL 연봉 FOR a7;
COL 인상후 FOR a7;

SELECT
	name, 
	TO_CHAR(hiredate, 'YYYY-MM-DD') 입사일,
	TO_CHAR(pay * 12, '99,999') 연봉,
	TO_CHAR((pay * 12) * 1.1, '99,999') 인상후
FROM
	t_professor
WHERE
	TO_CHAR(hiredate, 'YYYY') < '2000';














