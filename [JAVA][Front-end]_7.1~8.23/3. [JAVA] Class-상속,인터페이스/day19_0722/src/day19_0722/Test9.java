package day19_0722;
class Person{
	void eat(Food food) {//개념은아니나 자료형을 이렇게받을거다
		
		//System.out.println(food);
		food.menu();
	}
}
abstract class Food{
	abstract void menu();
}
class Bob extends Food{

	@Override
	void menu() {
		System.out.println("이건 밥...");
		
	}
	
}
class Baaab extends Food{
	void menu() {
		System.out.println("이것도밥");
	}
}

public class Test9 {

	public static void main(String[] args) {
		//동적바인딩(day18_Test7과같은현상)
		Person p =new Person();
		p.eat(new Baaab());
		p.eat(new Bob());
		
		
	}

}
