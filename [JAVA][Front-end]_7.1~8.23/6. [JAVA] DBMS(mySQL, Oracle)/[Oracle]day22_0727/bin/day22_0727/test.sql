-- ���� ����Ű Alt + x
select * from all_tables; -- MySQL == show tables; 
create table test(
	num int -- auto increment�� mysql���� ���Ұ���
);
select * from test;
insert into test values(100); -- Status�� �ƹ��͵� �ȶ߸� �������!
update test set num=123 where num=100;
delete from test where num=100;
select count(*) from test; -- ������ ����




-- ����
/*
 * .Ǯ�̴� ����!
-> java Test4
1) test.sql���� �л������� 5�� �������ּ���
   console�� ������ּ���!~~

2) �л����� �̸��� ���� �������ּ���
  ��, ������ console���� �Է��Ͽ� �����մϴ�!~~

3+) "��"(->console)�̶�� ���� ���� �л��� ���� ������ּ���!~~
  ȫ�浿 �Ƹ� �ƹ��� Ƽ��
  ��ȿ�� �販�� Ƽ���
 */
create table student(
	snum int primary key,
	name varchar(20),
	score int 
);

insert into student values(1, '�ٸ���',50);
insert into student values(2, '�ι̿�',100);
insert into student values(3, 'ȫ�浿',80);
insert into student values(4, '�Ӳ���',90);
insert into student values(5, '�ƹ���',87);

drop table student;
select *from student;

select * from student where name like '%��%';

