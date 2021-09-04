package model;
//MVC - 
//M model 모델(백이 일반적)
//[무엇]을 다룰지,할지 정의 *초점
//DB와 상호작용

//무엇을 할지, 무엇을 다룰지는 미리 정의해둔 메서드만으로 컨트롤하는방향으로 설계!
//메소드를 통해 접근->실행은 뷰를 통해 확인
// 사용자 ->  뷰 -> 컨트롤러 -> 모델
public class Calc {//부모클래스에게 맞춰주기 범위를 위해
	// 무엇을 할지 계산만 잘되면 된다!
	
	//모델파트!!
	private int n1;
	private int n2;
	private String op;
	private int res;
	public int getRes() {
		return res;
	}
	public Calc(int n1, int n2, String op) {
		this.n1 = n1;
		this.n2 = n2;
		this.op = op;
		use();//res를 알기위해
		
	}
	private void use() {
		if(this.op.equals("+")) {
			plus();
		}
		else if(this.op.equals("-")) { // else if(this.op.equals("-"))
			minus();
		}
	} 
	public void plus() {
		this.res = this.n1+this.n2;
	}
	public void minus() {
		this.res = this.n1-this.n2;
	}
	
	
}
