package day21_0726;

import java.util.Scanner;

class Calc{ // ��
	// db�����͸� ������⶧���� ���� �����̺��� �������� �ټ����� �̿��Ѵ�.
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
			this.res = x+y; //plus(); ���� �޼ҵ常�������� ����
		}
		else {
			this.res = x-y; // minus(); ���� �޼ҵ常�������� ����
		}
	}
}
class CalcView{// �Է°� ��´��
	// �Է��� ���� �����ؾߵż� ��������� �־����
	Scanner sc;
	int x,y;
	String op;
	
	CalcView(){
		sc = new Scanner(System.in);
	}
	void funcA() { // �Ǵ� start
		System.out.println("x�Է�: ");
		int x = sc.nextInt();
		System.out.println("y�Է�: ");
		int y = sc.nextInt();
		System.out.println("�������Է�");
		String op = sc.next();
	}
	void funcB(int res) {// �Ǵ� end
		System.out.println("����� "+res);
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
		//�Էº���!
		view.funcA(); 
		model.calc(view.x, view.y, view.op); // ��� ���� ����
		view.funcB(model.getRes());
	}
}
public class Test4 {

	public static void main(String[] args) {

		// JAVA: MVC
		// WEB: MVC �� �ڹٶ� ���°� �ٸ��� ����

		
		CalcController  c = new CalcController();
		c.calcStart();

	}// main����

}
