select * from all_tables;

create table product(
	id int primary key,
	name varchar(50),
	ptype varchar(30),
	price int not null
);

insert into product values (1, '�縻', '��ȭ', 2000);
insert into product values (2, '����', '����', 30000);
insert into product values (3, '�񵵸�', '��ȭ', 17000);
insert into product values (4, '����', '�Ƿ�', 80000);
insert into product values (5, '�����', '�Ǽ��縮', 24000);
insert into product values (6, '����', '�Ǽ��縮', 18000);
insert into product values (7, '���۶�', '��ȭ', 45000);
insert into product values (8, '���ڹ�', '����', 9000);
insert into product values (9, 'û����', '�Ƿ�', 37000);
insert into product values (10, '����', '�Ƿ�', 42000);

-- 1

-- 1-1) 10000�� �̻���� �� �з��� ���
select * from product where price>=10000; 

select * from product where ptype='����';
select * from product where ptype='�Ƿ�';
select * from product where ptype='�Ǽ��縮';
select * from product where ptype='��ȭ';

-- 1-2) Ÿ�Ժ� 10000�� �̻��� ��ǰ ��� 
select * from product where ptype ='����' and price>=10000;
select * from product where ptype ='�Ƿ�' and price>=10000;
select * from product where ptype ='�Ǽ��縮' and price>=10000;
select * from product where ptype ='��ȭ' and price>=10000;


-- 1-3) 10000�� �̻� ��ǰ���� �з� ��������
select * from product where price>=10000 order by ptype;



-- 2 
update product set price = price + 10000 where ptype='��ȭ'; 
select * from product;



select * from product where ptype='�Ǽ��縮'; -- 3

-- 4
select * from product where price=(select min(price) from PRODUCT where ptype='��ȭ');
select * from product where price=(select min(price) from PRODUCT where ptype='����');
select * from product where price=(select min(price) from PRODUCT where ptype='�Ƿ�');
select * from product where price=(select min(price) from PRODUCT where ptype='�Ǽ��縮');


-- 5
create view product_view_bag as
select id, name, ptype, price
from product
where ptype='����';

select * from product_view_bag;

-- 6

-- 7
insert into product values ((select nvl(max(id), 0)+1 from product), '����', '�Ƿ�', 10000);
select * from product where name='����';


-- 8
CREATE USER korea IDENTIFIED BY 1234;
select * from ALL_USERS;




