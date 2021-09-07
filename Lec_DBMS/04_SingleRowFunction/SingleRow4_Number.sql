
-- ROUND()  : 반올림
-- TRUNC() : 버림, 자름
-- CEIL, FLOOR

SELECT
	'12.5'
	, ROUND(12.5) "ROUND"
	, TRUNC(12.5) "TRUNC"
	, CEIL(12.5) "CEIL"
	, FLOOR(12.5) "FLOOR"
FROM dual;


-- 오라클은 % 연산자 없슴.
SELECT
	MOD(12, 10),
	MOD(12.6, 4.1)
FROM dual

-- POWER() : 제곱
SELECT
	POWER(3, 2)
	, POWER(-3, 3)
	, POWER(10, -2)
	, POWER(2, 1/2)
	, POWER(27, 1/3)
FROM dual;














