select * from all_tables;

create table member2(
	mid int primary key,
	mname varchar(20),
	age int
);

insert into member2 values(1, 'ȫ�浿', 20);
insert into member2 values(2, '�ƹ���', 21);
insert into member2 values(3, '�Ƹ�', 22);
insert into member2 values(4, '�׾Ƹ�', 23);
insert into member2 values(5, '������', 24);

drop table member2;