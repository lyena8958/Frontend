package day11_0706_2;
//public: �ܺ� ��Ű�������� ������ �����ϵ��� ����
class Car{
	private int speed;
	
	public int getSpeed() { // �������ִ� ���ͻ��Ϳ����� public�� �ɷ��ִ�
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	void speedUp(int speed) {
		this.speed+=speed;
	}
	void show() {
		
		System.out.println("����ӵ�: "+speed);
	}
}

public class Test2 {

	public static void main(String[] args) {
		
		
		Car car=new Car();
		car.speedUp(100);
		car.show();
		System.out.println(car.getSpeed());

		
	}

	
}
