select * from all_tables;

create table product(
	id int primary key,
	name varchar(50),
	ptype varchar(30),
	price int not null
);

insert into product values (1, '양말', '잡화', 2000);
insert into product values (2, '백팩', '가방', 30000);
insert into product values (3, '목도리', '잡화', 17000);
insert into product values (4, '자켓', '의류', 80000);
insert into product values (5, '목걸이', '악세사리', 24000);
insert into product values (6, '반지', '악세사리', 18000);
insert into product values (7, '선글라스', '잡화', 45000);
insert into product values (8, '에코백', '가방', 9000);
insert into product values (9, '청바지', '의류', 37000);
insert into product values (10, '셔츠', '의류', 42000);

-- 1

-- 1-1) 10000원 이상출력 및 분류별 출력
select * from product where price>=10000; 

select * from product where ptype='가방';
select * from product where ptype='의류';
select * from product where ptype='악세사리';
select * from product where ptype='잡화';

-- 1-2) 타입별 10000원 이상의 상품 출력 
select * from product where ptype ='가방' and price>=10000;
select * from product where ptype ='의류' and price>=10000;
select * from product where ptype ='악세사리' and price>=10000;
select * from product where ptype ='잡화' and price>=10000;


-- 1-3) 10000원 이상 상품들의 분류 오름차순
select * from product where price>=10000 order by ptype;



-- 2 
update product set price = price + 10000 where ptype='잡화'; 
select * from product;



select * from product where ptype='악세사리'; -- 3

-- 4
select * from product where price=(select min(price) from PRODUCT where ptype='잡화');
select * from product where price=(select min(price) from PRODUCT where ptype='가방');
select * from product where price=(select min(price) from PRODUCT where ptype='의류');
select * from product where price=(select min(price) from PRODUCT where ptype='악세사리');


-- 5
create view product_view_bag as
select id, name, ptype, price
from product
where ptype='가방';

select * from product_view_bag;

-- 6

-- 7
insert into product values ((select nvl(max(id), 0)+1 from product), '바지', '의류', 10000);
select * from product where name='바지';


-- 8
CREATE USER korea IDENTIFIED BY 1234;
select * from ALL_USERS;




