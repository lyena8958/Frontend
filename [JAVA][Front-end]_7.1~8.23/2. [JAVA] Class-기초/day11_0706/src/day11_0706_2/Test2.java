package day11_0706_2;
//public: 외부 패키지에서도 접근이 가능하도록 설정
class Car{
	private int speed;
	
	public int getSpeed() { // 제공해주는 갭터샙터에서는 public가 걸려있다
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	void speedUp(int speed) {
		this.speed+=speed;
	}
	void show() {
		
		System.out.println("현재속도: "+speed);
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
