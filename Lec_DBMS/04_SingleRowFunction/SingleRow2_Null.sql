SELECT * FROM T_PROFESSOR;

-- null 값과 산술 연산 결과는 null  이다.
SELECT name, pay, bonus, pay + bonus
FROM T_PROFESSOR;

SELECT name, pay, bonus, 
		pay + bonus,
		pay + nvl(bonus, 0)
FROM T_PROFESSOR;

SELECT * FROM T_PROFESSOR 

-- #4201
SELECT name, pay, NVL(bonus, 0) BONUS, 
		(pay * 12 + NVL(bonus, 0)) 연봉 
FROM 
	t_professor 
WHERE 
	deptno = 101;

-- #4202
SELECT name, pay, NVL(bonus, 0) BONUS, 
		nvl2(bonus, pay * 12 + bonus, pay * 12) 연봉 
FROM 
	t_professor 
WHERE 
	deptno = 101;







