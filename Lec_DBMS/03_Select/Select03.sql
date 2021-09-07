SELECT
	name,
	height
FROM
	t_student
WHERE
	height >=180
;

SELECT 
	name,
	weight
FROM 
	t_student
WHERE
	weight >= 60 AND 
	WEIGHT <= 80
;

SELECT 
	*
FROM
	t_student
WHERE
	deptno1 IN (101, 201)
;

SELECT 
	*
FROM 
	t_student
WHERE
	name LIKE '김%'
;


SELECT 
	name,
	grade,
	height
FROM 
	t_student
WHERE
	grade = 4 AND
	height > 170
;

SELECT 
	name,
	height,
	grade,
	weight
FROM 
	t_student
WHERE
	grade = 1 OR 
	weight >= 80
;

SELECT 
	name,
	grade,
	weight
FROM 
	t_student
WHERE
	grade = 2 AND 
	height > 180 AND 
	weight > 70
;

SELECT 
	name,
	grade,
	height,
	weight
FROM 
	t_student
WHERE
	grade = 2 AND 
	(height > 180 OR weight > 70)
;

SELECT 
	ename,
	hiredate
FROM 
	t_emp
WHERE
	hiredate < '1992.01.01'
;


SELECT 
	name,
	birthday,
	height,
	weight
FROM 
	t_student
WHERE
	grade = 1
ORDER BY
	birthday ASC
;

SELECT 
	name 이름,
	height 키
FROM 
	t_student
WHERE
	grade = 1
ORDER BY
	name ASC
;


SELECT 
	name,
	birthday
FROM 
	t_emp2
WHERE
	birthday >= '1980.01.01' AND 
	birthday <= '1989.12.31'
;





