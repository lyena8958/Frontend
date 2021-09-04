package day15_0716;

class Point{
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	int x;
	int y;
	public String toString() {
		return "P"+"("+this.x+","+this.y+")";
	}
	//Ÿ Ŭ������ �������̵��� ������ �Ͼ �� ������ object�� �޴°� ����
	public boolean equals(Object obj) {//�������̵�: ���������� Ʋ���� �ʾ����� Point obj�ص��ȴ�. �ٸ�, �ٸ�Ŭ������ ���Ҽ����Ե�
		// ���ڴ�  �Ѱ��̳� �񱳰� �ΰ�������?? Ŭ������������ ��������� �� ������⶧���̴�.
		
		Point p=(Point)obj; //Point obj�� ���ڸ� ������ ����ȯ �����൵��
		// ����ȯ == ��ĳ���á� 		//��������ȯ(�ڷ�����ȯ)
		
		if(p.x==this.x) { // p.x==this.x && p.y==this.y
			if(p.y==this.y) {
				return true;
			}
		}
		return false;
	}
}
public class Test3 {

	public static void main(String[] args) {
		
		Point[] data = new Point[3];
		data[0]=new Point(10,11);
		data[1]=new Point(10,11);
		data[2]=new Point(10,11);
		
		for(Point p: data) {
			System.out.println(p);
		}
		
		String str; // == String extends Object -> equals()�� �������̵�
		
		
		if(data[0]==data[1]) { // data[0]==data[1] -> �����ּҸ� ���ϱ� ������ �ٸ���.
			System.out.println("1");
		}
		else {
			System.out.println("Ȯ��");
		}
		// "�ֻ���Ŭ����" Object �ٷ� ȣ���Ͽ� ���
		// String -> equals()�� �������̵�
		if(data[0].equals(data[2])) {//�������̵� �õ�! ����
			System.out.println("2");
		}
	}

}
