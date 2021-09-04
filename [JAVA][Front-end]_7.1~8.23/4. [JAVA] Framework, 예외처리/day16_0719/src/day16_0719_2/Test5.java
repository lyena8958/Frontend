package day16_0719_2;

import java.util.ArrayList;
import java.util.Scanner;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
}
public class Test5 {
	public static void main(String[] args) {
		
		ArrayList<Point> al = new ArrayList();
		Scanner sc= new Scanner(System.in);

		while (true) {
			System.out.println("1. 점등록  2.목록보기   3.점이동  4.프로그램종료");
			int act = sc.nextInt();
			if (act == 1) {
				System.out.println("등록할 점의 x,y 좌표 입력");
				int x = sc.nextInt();
				int y = sc.nextInt();
				al.add(new Point(x, y));
			} else if (act == 2) {
				for (Point p : al) {// 자료형이 point라는 보장이 있어야 출력이 가능
					System.out.println(p);
				}
			} else if (act == 3) {// 점이동작업
				if (al.size() == 0) {// 점등록을 안하면 무조건 오류이므로 조건문 생성
					System.out.println("현재 점이 0개입니다!");
					continue;
				}
				System.out.println("이동할 점의 번호를 입력");
				int num = sc.nextInt();
				if (num < 1 || al.size() < num) {// 유효성 검사
					System.out.println("잘못된 입력입니다!");
					continue;
				}
				al.get(num - 1).move(1, 2);
			} else if (act == 4) {
				break;
			} else {
				System.out.println("잘못된 입력입니다!");
				// 종료하지않고 4번을 눌러야 종료한다.
				// 사용자 편의를 항상 생각해본다!
			}
		}

	}// main종료
}
