select * from all_tables;

create table student(
	num int primary key,
	name varchar(15),
	score1 int,
	score2 int
);

insert into student values (1001, 'ȫ�浿', 100, 99);
insert into student values (1002, '�ƹ���', 10, 90);
insert into student values (1003, 'Ƽ��', 20, 23);

select * from student;