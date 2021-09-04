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
			System.out.println("1. �����  2.��Ϻ���   3.���̵�  4.���α׷�����");
			int act = sc.nextInt();
			if (act == 1) {
				System.out.println("����� ���� x,y ��ǥ �Է�");
				int x = sc.nextInt();
				int y = sc.nextInt();
				al.add(new Point(x, y));
			} else if (act == 2) {
				for (Point p : al) {// �ڷ����� point��� ������ �־�� ����� ����
					System.out.println(p);
				}
			} else if (act == 3) {// ���̵��۾�
				if (al.size() == 0) {// ������� ���ϸ� ������ �����̹Ƿ� ���ǹ� ����
					System.out.println("���� ���� 0���Դϴ�!");
					continue;
				}
				System.out.println("�̵��� ���� ��ȣ�� �Է�");
				int num = sc.nextInt();
				if (num < 1 || al.size() < num) {// ��ȿ�� �˻�
					System.out.println("�߸��� �Է��Դϴ�!");
					continue;
				}
				al.get(num - 1).move(1, 2);
			} else if (act == 4) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�!");
				// ���������ʰ� 4���� ������ �����Ѵ�.
				// ����� ���Ǹ� �׻� �����غ���!
			}
		}

	}// main����
}
