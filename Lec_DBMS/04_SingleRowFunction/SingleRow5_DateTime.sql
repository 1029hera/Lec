-- 날짜 함수

-- 기본 연산
SELECT
	SYSDATE "오늘"
	, SYSDATE + 1 "내일"
	, SYSDATE - 2 "그저께"
	, SYSDATE + 1/24 "한시간뒤"  -- 소숫점 단위로 일자 계산 가능.
FROM dual;

-- 일자 차이 계산
SELECT
	SYSDATE "오늘"
	, SYSDATE - TO_DATE('2021-01-26') "수업시작한지"
FROM dual;


-- MONTHS_BETWEEN : 둘 날짜 사이 개월수
SELECT
	MONTHS_BETWEEN('2012-03-01', '2012-01-01')  양수값
	, MONTHS_BETWEEN('2012-01-01', '2012-03-01') 음수값
	, MONTHS_BETWEEN('2012-02-29', '2012-02-01') "2/29-2/01"
	, MONTHS_BETWEEN('2013-02-28', '2013-02-01') "2/28-2/01"
	, MONTHS_BETWEEN('2013-04-30', '2013-04-01') "4/30-4/01"
FROM dual;


-- #4501
SELECT 
	name "이름",
	TO_CHAR(sysdate, 'YYYY-MM-DD') "오늘",
	TO_CHAR(hiredate, 'YYYY-MM-DD') "입사일",
	TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(hiredate, 'YYYY') "근속연수",
	ROUND(MONTHS_BETWEEN(SYSDATE, hiredate), 1) "근속개월수",
	ROUND(SYSDATE - hiredate, 1) "근속일"
FROM t_professor






