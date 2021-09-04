package day15_0716;

class Car {
	String name;
	int speed;
	int maxSpeed;

	Car(String name) {
		this(name, 60); // 2
		// System.out.println("a");//4
	}

	Car(String name, int maxSpeed) { // 3(12~16)
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.speed = 0;
		System.out.println("자동차생성완료!");
	}

	public String toString() {// public -> 부모의 범위보다 자식이 무조건 같거나 커야해서
		// 오버로딩(상속x) vs 오버라이딩(상속o)
		return "Car [name=" + name + ", speed=" + speed + ", maxSpeed=" + maxSpeed + "]";
	}

}

public class Test1 {

	public static void main(String[] args) {
	
		Car car = new Car("홍길동"); // 1
		System.out.println(car);
		//출력되는이유?? 
		// 1) Object(최상위클래스)
		// 2) .toStrong() 자동호출
		
		
		
	}//main종료
}
