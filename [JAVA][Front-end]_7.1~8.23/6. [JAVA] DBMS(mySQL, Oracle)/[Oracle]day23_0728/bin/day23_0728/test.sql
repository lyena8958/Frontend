select * from all_tables;
/*
���Ǳ�
A-�޴� -> ���--
B-�� -> ����Ʈ++
*/
-- 210728

create table menu(
	mnum int primary key,
	mname varchar(30), -- �ѱ��� 2~4����Ʈ
	cnt int
);
	
insert into menu values(1, '�Ƹ޸�ī��',10);
insert into menu values(2, 'ī���',1);
insert into menu values(3, '����Ǫġ��',2);

select * from menu;
drop table menu;

create table member(
   num int primary key,
   name varchar(15),
   point int
);
insert into member values (1001,'�Ƹ�',100);
insert into member values (1002,'Ƽ��',1200);
select * from member;

insert into member values ((select nvl(max(num) ,0)+1 from member ), '����',200); 
-- nvl('����Į���߿�����ū��',0)+1 >> +1�� �� ������ȣ�� ��Ÿ����.
-- select ���� max(num)ū ��ȣ�� �˻��ؾ���  

