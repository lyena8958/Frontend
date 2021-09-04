package day24_0729;
// VO(Values Object) - DB테이블 객체화

//MODEL
public class TestVO {
	// 멤버변수는 DB칼럼과 동일하게
	// 직접접근을 막기위해서 -> 오직 메서드로만 접근하기 위해
	private int a; // PK -- 보통 젤 상단에 있는 것이 PK
	private String b;
	private int c;
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	@Override
	public String toString() {
		return "TestVO [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	
}
