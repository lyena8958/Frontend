package day17_0720;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
class Person{
	String name;
	int num;
	Person(String name){
		this.name = name;
		this.num = new Random().nextInt(90)+10; // 10~99
		System.out.println(this.name+"님, 예약번호는 ["+num+"]");
	}
	@Override
	public String toString() {
		return name + "님  [" + num + "]";
	}
	
}

public class Test1 {
	// Queue
	// 영화 대기열 프로그램
	// 1. 예약 2.입장 3.대기열출력 4.종료
	// 1) 몇명?
	// 2) 입장
	// Person 
//			이름
//			예약번호
	public static void main(String[] args) {

		// 영화 대기열 프로그램
		Scanner sc = new Scanner(System.in);
		
		Queue <Person>q = new LinkedList<Person>();
		
		while(true) {
			System.out.println("1예약 2입장 3대기열 4종료");
			int act = sc.nextInt();
			if(act==1) {
				System.out.println("몇명?");
				int num = sc.nextInt();
				for(int i = 0; i < num; i++) {
					System.out.println("예약자 성함을 입력하세요.");
					String name=sc.next();
					q.offer(new Person(name));
				}
			}
			else if(act ==2) {
				System.out.println("몇명?");
				int num = sc.nextInt();
				if(q.size()<num) {// 오입력시 모두 입장
					num = q.size();
					System.out.println("예약자수보다 많습니다. 최대입력...");
				}
	            for(int i=0;i<num;i++) {
	                System.out.println(q.peek().name+"님의 예약번호는?");
	                int pw=sc.nextInt();
	                if(pw==q.peek().num) {
	                   System.out.println("예약번호일치!");
	                   System.out.println(q.poll().name+"님 입장!");
	                }
	                else {
	                   System.out.println(q.peek().name+"님, 다시대기!");
	                   q.offer(q.poll());//마지막으로이동
	                }
	             }
	          }

			else if(act==3) {
				System.out.println("==예약자 목록==");
				for(Person p:q) {
					System.out.println(p);
				}
			}
			else if(act==4) {
				break;
			}
			else {
				System.out.println("잘못된 종료!");
			}
		} // while
		
		
		

	}//main종료
}
