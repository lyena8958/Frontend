package day10_0705;

class Car4{
	String name;
	int maxSpeed;
	int speed;
	Car4(String name){
		this.name=name;
		this.maxSpeed=120; // �������� ���� this ����
		this.speed=0;	// "
	}
	Car4(String name, int maxSpeed){
	this.name=name;
	this.maxSpeed=120;
	this.speed=0; 
	}

	void speedUp() {
		this.speed+=20;
		if(this.speed>this.maxSpeed) {
			System.out.println("����!");
			this.speed=this.maxSpeed;
		}
	}
	void speedDown() {
		this.speed-=20;
		if(this.speed<0) {
			System.out.println("�̸̹���...");
			this.speed=0;
			
		}
	}
	void show(){
		System.out.println(this.name+"���� �ӵ�: "+this.speed);
		}
}

public class CarTest2 {

	public static void main(String[] args) {
		
		Car4 c1 = new Car4("ȫ�浿");
		c1.speedDown();
		System.out.println(c1.speed);
		c1.show();

		
		
		
	}//main����

}
