package day24_0729;
// VO(Values Object) - DB���̺� ��üȭ

//MODEL
public class TestVO {
	// ��������� DBĮ���� �����ϰ�
	// ���������� �������ؼ� -> ���� �޼���θ� �����ϱ� ����
	private int a; // PK -- ���� �� ��ܿ� �ִ� ���� PK
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
