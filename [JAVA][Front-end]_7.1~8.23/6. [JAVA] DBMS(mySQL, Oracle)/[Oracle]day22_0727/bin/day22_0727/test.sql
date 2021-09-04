-- 실행 단축키 Alt + x
select * from all_tables; -- MySQL == show tables; 
create table test(
	num int -- auto increment는 mysql꺼라 사용불가능
);
select * from test;
insert into test values(100); -- Status가 아무것도 안뜨면 정상실행!
update test set num=123 where num=100;
delete from test where num=100;
select count(*) from test; -- 데이터 개수




-- 문제
/*
 * .풀이는 내일!
-> java Test4
1) test.sql에서 학생정보를 5개 저장해주세요
   console로 출력해주세요!~~

2) 학생들의 이름을 전부 수정해주세요
  단, 수정은 console에서 입력하여 진행합니다!~~

3+) "김"(->console)이라는 값을 가진 학생을 전부 출력해주세요!~~
  홍길동 아리 아무무 티모
  김효경 김꺽정 티김모
 */
create table student(
	snum int primary key,
	name varchar(20),
	score int 
);

insert into student values(1, '줄리엣',50);
insert into student values(2, '로미오',100);
insert into student values(3, '홍길동',80);
insert into student values(4, '임꺽정',90);
insert into student values(5, '아무무',87);

drop table student;
select *from student;

select * from student where name like '%김%';

