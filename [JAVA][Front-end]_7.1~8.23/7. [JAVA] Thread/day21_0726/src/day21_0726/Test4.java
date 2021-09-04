package day21_0726;

import java.util.Scanner;

class Calc{ // 모델
	// db데이터를 갖고오기때문에 보통 프라이빗을 가려놓고 겟셋으로 이용한다.
	private int x;
	private int y;
	private String op;
	private int res;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	
	public void calc(int x, int y, String op) {
		this.x = x;
		this.y = y;
		this.op = op;
		if(op.equals("+")) {
			this.res = x+y; //plus(); 원랜 메소드만들어야지만 생략
		}
		else {
			this.res = x-y; // minus(); 원랜 메소드만들어야지만 생략
		}
	}
}
class CalcView{// 입력과 출력담당
	// 입력할 값을 저장해야돼서 멤버변수가 있어야함
	Scanner sc;
	int x,y;
	String op;
	
	CalcView(){
		sc = new Scanner(System.in);
	}
	void funcA() { // 또는 start
		System.out.println("x입력: ");
		int x = sc.nextInt();
		System.out.println("y입력: ");
		int y = sc.nextInt();
		System.out.println("연산자입력");
		String op = sc.next();
	}
	void funcB(int res) {// 또는 end
		System.out.println("결과는 "+res);
	}
}
class CalcController{
	Calc model;
	CalcView view;
	CalcController(){
		model = new Calc();
		view = new CalcView();
	}
	public void calcStart() {
		//입력부터!
		view.funcA(); 
		model.calc(view.x, view.y, view.op); // 뷰와 모델의 조합
		view.funcB(model.getRes());
	}
}
public class Test4 {

	public static void main(String[] args) {

		// JAVA: MVC
		// WEB: MVC 와 자바랑 형태가 다르니 참고

		
		CalcController  c = new CalcController();
		c.calcStart();

	}// main종료

}
