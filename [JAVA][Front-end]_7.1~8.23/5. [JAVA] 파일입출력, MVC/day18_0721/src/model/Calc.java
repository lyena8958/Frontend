package model;
//MVC - 
//M model ��(���� �Ϲ���)
//[����]�� �ٷ���,���� ���� *����
//DB�� ��ȣ�ۿ�

//������ ����, ������ �ٷ����� �̸� �����ص� �޼��常���� ��Ʈ���ϴ¹������� ����!
//�޼ҵ带 ���� ����->������ �並 ���� Ȯ��
// ����� ->  �� -> ��Ʈ�ѷ� -> ��
public class Calc {//�θ�Ŭ�������� �����ֱ� ������ ����
	// ������ ���� ��길 �ߵǸ� �ȴ�!
	
	//����Ʈ!!
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
		use();//res�� �˱�����
		
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
