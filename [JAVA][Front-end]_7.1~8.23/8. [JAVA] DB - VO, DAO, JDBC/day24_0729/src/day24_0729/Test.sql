select * from all_tables;

-- ���̺� --> TestVO�� ����
--  TestVO�� ����          VO:���̺�=1:1
create table test(
	a int primary key,
	b varchar(10),
	c int
);

insert into test values (1,'�Ƹ�',100);
insert into test values (2,'Ƽ��',200);
select * from test;
drop table test;








-- 0729 ��ü�� (sqlȰ��)
create table stu(
	snum int primary key,
	sname varchar(20),
	score int,
	grade varchar(5)
);

insert into stu values(1001,'�Ӳ���', 98, 'A');
insert into stu values(1002,'�޸���', 82, 'B');
insert into stu values(1003,'ȫ�浿', 97, 'A');
insert into stu values(1004,'�ƹ���', 76, 'B');

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


