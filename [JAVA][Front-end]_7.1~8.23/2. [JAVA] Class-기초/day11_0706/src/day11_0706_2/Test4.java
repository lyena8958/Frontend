package day11_0706_2;

class Car2{
	String name;
	int speed;
	void show() {
		System.out.println(name+"���� �ӵ�: "+speed);
	}
}
public class Test4 {

	public static void main(String[] args) {
		// Ŭ����:��ü= 1:N
		// ��ü:������ ȣ��=1:1 <= " ��ü �迭 " !!!!!!��ü�� ������ȣ���� 1:1!!!!!!
		
//		Car2 c1=new Car2();
//		Car2 c2=new Car2();
//		Car2 c3=new Car2();
		// �� �迭�� ������
		
		Car2[] car = new Car2[3]; // �����ڰ� ȣ���� �ȵƱ� ������, �� ���� 3���� �θ��ų� ����������.
//		car[0] = new Car2(); // ���� ������1�� ���� �ִ´�.(�ּҰ� ����.)
//		car[1] = new Car2(); // "2
//		car[2] = new Car2(); // "3
		
//      �� 3�� �ִ� ������ �ݺ������� �ڵ���
		for(int i = 0; i < car.length;i++) {
			car[i] = new Car2();
		}
		for(int i = 0; i < car.length;i++) {
			car[i].show();
		}
		for(Car2 v: car) {
			v.show();
		}

		
		// �Ϲݹ迭
		int[] arr = new int[3]; // 4����Ʈ�� �����ִ� 3�� ������ ����
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
				
		

	}

}
// ���� 3��� - ũ�� �ּ� �̸�
// ������
// ���ǹ�
// �ݺ���
// �迭, �������迭, ���ڿ� (C���� �ٸ��� heap������ ����ؼ� ������ ���������ִ�.)
// �Լ� 3��� - input, output, ��ȣ
// �Լ� -> static("��ü�� �����ϰ�")
// *Ŭ������ ��ü
//   : 1 : N, ��üȭ(�ν��Ͻ�ȭ), ������(��üȭ�� ���), �����ε�, �������(.), this
//		�����ڿ� new�� ����ϱ⶧���� �ʱ�ȭ�� ����
//  4���� Ư¡
//	 1) �߻�ȭ  
//	 2) ĸ��ȭ-����������,getter,setter  
//	 3) ���  
//	 4) ������