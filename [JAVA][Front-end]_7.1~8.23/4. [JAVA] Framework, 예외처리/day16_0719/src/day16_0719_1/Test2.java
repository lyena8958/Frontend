package day16_0719_1;
import java.util.ArrayList;

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
	
}
public class Test2 {

	public static void main(String[] args) {
		// �÷��� �����ӿ�ũ
		// �÷��� ArrayList
		// : �迭�� Ȯ����
		ArrayList al = new ArrayList(3); 
		al.add(new Point(1,2));
		al.add(new Point(10,20));
		al.add(new Point(11,22));
//		al.add(4); // ũ�� ������ ����.
		System.out.println(al); // toString �������̵�
		
		al.add(10);
		for(Object obj:al) {
			System.out.println(obj);
		}
		// ������ ������ ���ٸ�, ArrayList�� �ڽ��� ��ҵ��� Object�� �Ǵ���
		
		
	}// main����

}
