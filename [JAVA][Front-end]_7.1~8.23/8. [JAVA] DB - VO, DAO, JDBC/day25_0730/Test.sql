select * from all_tables;

create table student(
	num int primary key,
	name varchar(15),
	score1 int,
	score2 int
);

insert into student values (1001, '홍길동', 100, 99);
insert into student values (1002, '아무무', 10, 90);
insert into student values (1003, '티모', 20, 23);

select * from student;