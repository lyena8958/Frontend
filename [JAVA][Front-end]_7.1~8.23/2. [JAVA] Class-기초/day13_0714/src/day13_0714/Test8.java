/*
자판기 프로그램
메뉴명 + 가격
 -> 클래스(class) 
class Menu{
	String name;
	int price;
	void show(){ // 멤버로서 메서드를 작성할수있음!
		syso();

	}
	void changeName(){
		변경할 이름은?
		- 
	}

}
*/
package day13_0714;

import java.util.Scanner;

class Point{
	int x;
	int y;
	Point(){
		this(0,0); // 밑에 생성자 호출
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	void show() {
		System.out.println("("+this.x+", "+this.y+")");
	}
	void movePoint() {
		this.x++;
		this.y++;
	}
	void movePoint(int x) {
		this.x += x;
		this.y += y;
	}
	void movePoint(int x, int y) {
		this.x+=x;
		this.y+=y;
	}
	
}
// 강사님
class ColorPoint2 extends Point{
	// 부모클래스 생성자x -> 기본생성자가 제공되고있음
	// 그 기본생성자에서는 부모의 생성자를 호출하는 중
	
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	ColorPoint2(String color, int x, int y){
		super(x, y);
		this.color = color;
	}
	// 함수 재정의 == 오버라이딩
	void show() {
		System.out.println(this.color+"("+this.x+", "+this.y+")");
	}

}

// 예나 풀이
class ColorPoint extends Point{
	ColorPoint(String color){
		super();
		this.color = color;
	}
	ColorPoint(String color, int x, int y){
		super(x, y);
		this.color = color;
	}
	
	String color;
	void movePoint(){
		this.x++;
		this.y++;
	}
	void movePoint(int a){
		this.x += a;
		this.y += a;
	}
	void movePoint(int x, int y){
		this.x += x;
		this.y += y;
	}
	void show() {
		System.out.println(this.color+"("+this.x+", "+this.y+")");
	}
	
}
public class Test8 {

	//static
	// 주체가 없는 함수를 선언 == static
	// "객체와 무관하게", "프로그램 수준으로" -> 프로그램이 무거워짐(안쓰는게 유리)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	/*	Point p1 = new Point();
		p1.show();

		Point p2 = new Point(11,20);
		p2.show();
		
		
		Point[] data = new Point[5]; // 배열의 저장공간 생성
		
		for(int i = 0; i < data.length; i++) {
			data[i] = new Point(i+1,i+1);
		}
		for(Point v: data) {
			// System.out.print(v); 주소 값이 나옴
			v.show();
		}*/
		
		/*문제★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		Test2에 마저 코딩해주세요!~~

		Point를 상속받는 ColorPoint 클래스가 있다.
		 - String color
		 - show() 호출했을때,
		   빨강(10,10) 이라고 출력됨
		 - 색깔은 외부에서 변경할수가없습니다.(접근제어자)

		추가로, 모든 점들은(색깔점 포함)
		"이동"할수있게됨
		 movePoint() -> x++, y++
		 movePoint(10) -> x+=10, y+=10
		 movePoint(1,2) -> x+=1, y+=2*/
		
		// 강사님
		ColorPoint2 cp1=new ColorPoint2("빨강",10,20);
		cp1.movePoint(2);
		cp1.show();
		
		// 예나
		ColorPoint[] c1 = new ColorPoint[3];
		
		c1[0] = new ColorPoint("빨강",10,1);
		c1[1] = new ColorPoint("주황");
		c1[2] = new ColorPoint("핑크", 5, 5);
		
		c1[0].show();
		c1[1].show();
		c1[2].show();
		
		System.out.println();
		
		c1[0].movePoint(5, 10);
		c1[0].show();
		
		c1[1].movePoint(20);
		c1[1].show();
		
		c1[2].movePoint();
		c1[2].show();
		
		
		// 번외
	      ColorPoint2[] data=new ColorPoint2[3];
	      for(int i=0;i<data.length;i++) {
	         System.out.println("색입력");
	         String color=sc.next();
	         System.out.println("x좌표입력");
	         int x=sc.nextInt();
	         System.out.println("y좌표입력");
	         int y=sc.nextInt();
	         data[i]=new ColorPoint2(color,x,y);
	      }

		
		for(int i = 0; i < 5; i++) {
			System.out.println("1:점이동\t2:현재점 데이터 전체출력\t3: 프로그램 종료");
			int act = sc.nextInt();
			if(act == 1) {
				System.out.println("점 선택: 1번 2번 3번 중에 선택해주세요!");
				int num;
				do {
					num = sc.nextInt();
				}while(num<1 || data.length<num);
				num--; // 선택과 인덱스넘버사이의 1 차이
				System.out.println("모드: 1번 2번 3번 중에 선택해주세요!");
				act= sc.nextInt();
				if(act == 1) {
					data[num].movePoint();
				}
				else if(act ==2 ) {
					System.out.println("x 입력");
					int x= sc.nextInt();
					data[num].movePoint(x);
				}
				else if(act == 3) {
					System.out.println("x 입력");
					int x= sc.nextInt();
					System.out.println("y 입력");
					int y = sc.nextInt();
					data[num].movePoint(x, y);
				}
				else {
					System.out.println("해당없음!");
				}
			} // 1번 모드 종료
			else if(act == 2) {
				System.out.println();
				System.out.println("==점 목록==");
				for(Point p:data) {
					p.show();
				}
			}
			else if(act == 3) {
				System.out.println("프로그램 종료됨...");
				break;
			}
			else {
				//유효성검사
				System.out.println("잘못된 입력!");
				// 5번을 꽉채워서 하지않을거기 때문에 i--ㄴ 패스
			}
		}
		
		
	}// main종료

}
