select * from all_tables;

-- 테이블 --> TestVO로 매핑
--  TestVO로 매핑          VO:테이블=1:1
create table test(
	a int primary key,
	b varchar(10),
	c int
);

insert into test values (1,'아리',100);
insert into test values (2,'티모',200);
select * from test;
drop table test;








-- 0729 집체평가 (sql활용)
create table stu(
	snum int primary key,
	sname varchar(20),
	score int,
	grade varchar(5)
);

insert into stu values(1001,'임꺽정', 98, 'A');
insert into stu values(1002,'메르시', 82, 'B');
insert into stu values(1003,'홍길동', 97, 'A');
insert into stu values(1004,'아무무', 76, 'B');

 select * from stu;
 
 update stu set score = score -10;
 
 drop table stu;
 SELECT SNAME, SCORE
FROM STU
WHERE SCORE > (SELECT MIN(SCORE) FROM STU);

 select * from stu where grade = 
(select grade from stu where snum = 1003);

 select sname, score from stu where grade = 'B';

 
select sname, score from stu where grade = 'B';

select sname, score from stu where score > (select min(score) from stu);
select * from stu where grade = (select grade from stu where snum = 1003);

select * from stu;


