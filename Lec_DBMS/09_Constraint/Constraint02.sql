-- 복합키 

-- Primary Key (기본키)
--   Key (중복허용 안된)

CREATE TABLE test_compkey(
	mb_uid NUMBER,
	mb_nick VARCHAR2(10),
	mb_name VARCHAR2(10),
	CONSTRAINT test_compkeys_pk PRIMARY KEY(mb_uid, mb_nick)
);

INSERT INTO test_compkey VALUES(1, 'aaa', 'John');
INSERT INTO test_compkey VALUES(1, 'bbb', 'John');
INSERT INTO test_compkey VALUES(2, 'aaa', 'John');


SELECT * FROM test_compkey;








