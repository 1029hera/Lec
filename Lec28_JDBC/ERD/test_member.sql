
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_member
(
	mb_no number,
	mb_name varchar2(40),
	mb_birthdate date
);

SELECT * FROM test_member;

INSERT INTO test_member(mb_name) VALUES('김이박');

CREATE SEQUENCE test_member_seq;







