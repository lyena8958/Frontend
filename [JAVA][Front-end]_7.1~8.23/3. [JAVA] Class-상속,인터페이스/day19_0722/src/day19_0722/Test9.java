package day19_0722;
class Person{
	void eat(Food food) {//�������ƴϳ� �ڷ����� �̷��Թ����Ŵ�
		
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
		System.out.println("�̰� ��...");
		
	}
	
}
class Baaab extends Food{
	void menu() {
		System.out.println("�̰͵���");
	}
}

public class Test9 {

	public static void main(String[] args) {
		//�������ε�(day18_Test7����������)
		Person p =new Person();
		p.eat(new Baaab());
		p.eat(new Bob());
		
		
	}

}
