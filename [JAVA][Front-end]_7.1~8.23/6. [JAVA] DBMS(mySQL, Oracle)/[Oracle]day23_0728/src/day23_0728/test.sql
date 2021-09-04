select * from all_tables;
/*
자판기
A-메뉴 -> 재고--
B-고객 -> 포인트++
*/
-- 210728

create table menu(
	mnum int primary key,
	mname varchar(30), -- 한글은 2~4바이트
	cnt int
);
	
insert into menu values(1, '아메리카노',10);
insert into menu values(2, '카페라떼',1);
insert into menu values(3, '프라푸치노',2);

select * from menu;
drop table menu;

create table member(
   num int primary key,
   name varchar(15),
   point int
);
insert into member values (1001,'아리',100);
insert into member values (1002,'티모',1200);
select * from member;

insert into member values ((select nvl(max(num) ,0)+1 from member ), '가렌',200); 
-- nvl('현재칼럼중에제일큰값',0)+1 >> +1은 그 다음번호를 나타낸다.
-- select 가장 max(num)큰 번호를 검색해야함  

