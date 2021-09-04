package day10_0705;

class Car4{
	String name;
	int maxSpeed;
	int speed;
	Car4(String name){
		this.name=name;
		this.maxSpeed=120; // °¡µ¶¼ºÀ» À§ÇØ this °Á¾¸
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
			System.out.println("À§Çè!");
			this.speed=this.maxSpeed;
		}
	}
	void speedDown() {
		this.speed-=20;
		if(this.speed<0) {
			System.out.println("ÀÌ¹Ì¸ØÃã...");
			this.speed=0;
			
		}
	}
	void show(){
		System.out.println(this.name+"´ÔÀÇ ¼Óµµ: "+this.speed);
		}
}


public class testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Car4 c1 = new Car4();
	}

}
