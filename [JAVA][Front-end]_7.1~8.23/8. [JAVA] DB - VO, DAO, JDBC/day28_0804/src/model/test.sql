select * from all_tables;

create table member2(
	mid int primary key,
	mname varchar(20),
	age int
);

insert into member2 values(1, '홍길동', 20);
insert into member2 values(2, '아무무', 21);
insert into member2 values(3, '아리', 22);
insert into member2 values(4, '항아리', 23);
insert into member2 values(5, '아지르', 24);

drop table member2;