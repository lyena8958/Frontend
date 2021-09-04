package day11_0706;

// �����
class IPhone2{
	IPhone2(String name){
		this(name,false,50); // �Է����� �������� �������� �д�. false,50
		
	}
	IPhone2(String name, boolean power){
		this(name,power,50); // �Է����� �������� �������� �д�. 50
	}
	IPhone2(String name, boolean power, int sound){
		this.name = name;
		this.power =power;
		this.sound=sound;
		
	}
	String name;
	boolean power;
	int sound;
	void show() {
		if(this.power) {
			System.out.println(this.name+"���� ���� ������"+this.sound+"�Դϴ�.");
		}
		else {
			System.out.println("���� OFF");
		}
	}
	void power() {
		if(this.power) {
			this.power=false;
		}
		else {
			this.power=true;
		}
	}
	void soundUp(int sound) {
		if(this.power) {
			this.sound+=sound;
			if(this.sound>100) {
				this.sound = 100;
			}
			System.out.println("����++");
		}
		else {
			System.out.println("����OFF");
		}
	}
	void soundDown() {
		if(this.power) {
			this.sound-=sound;
			if(this.sound<0) {
				this.sound = 0;
			}
			System.out.println("����--");
		}
		else {
			System.out.println("����OFF");
		}
	}
	
	
}


// ����
class IPhone{
	IPhone(String userName){
		this(userName, false, 50);
	}
	IPhone(String userName, Boolean onOff){
		this(userName, onOff, 50);
	}
	IPhone(String userName, Boolean onOff, int sound){
		this.userName = userName;
		this.onOff = onOff;
		this.sound = sound;
	}

	void power() {
		//���� on <> off
		this.onOff = this.onOff==true ? false : true;
		System.out.println("������"+onOff+"�� �ٲ����ϴ�.");
	}
	void soundUp(int sound) {
		// ������ ������ ���� OFF
		if(!this.onOff) {
			System.out.println("[ERROR] �޴��� ���� OFF");
		}
		else {
			this.sound += sound;
			if(sound > 100) {
				this.sound = 100;
			}
			System.out.println("sound "+this.sound+"���� ���� �Ǿ����ϴ�.");
		}
	}
	void soundDown(int sound) {
		// ������ ������ ���� OFF
		if(!this.onOff) {
			System.out.println("[ERROR] �޴��� ���� OFF");
		}
		else {
			this.sound -= sound;
			if(this.sound<0) {
				this.sound = 0;
				System.out.println("sound "+this.sound+"���� ���� �Ǿ����ϴ�.");
			}
		}
	}
	void show() {		
		// ����OFF
		if(!this.onOff) {
			System.out.println("[ERROR] �޴��� ���� OFF");
		}
		else {
			System.out.println(userName+"���� ���� ������"+sound+"�Դϴ�.");
		}
	}

	String userName;
	Boolean onOff; // ON/OFF
	int sound; // 0~100
}

public class Test5 {

	public static void main(String[] args) {
	/*	##����##
		class IPhone
		   �����̸�
		   �������� ON/OFF
		   ���� 0~100
		   void show()
		      : ���� OFF
		      : ȫ�浿���� ���� ������ 50�Դϴ�.
		   void power()
		      : ���� ON <-> OFF
		   void soundUp(int sound)
		      : ���� OFF
		      : sound�Է��� ����ŭ ++
		   void soundDown(int sound)
		      : ���� OFF
		      : --
		IPhone("ȫ�浿") -> ȫ�浿 / OFF / 50
		IPhone("ȫ�浿",true) -> ȫ�浿 / ON / 50
		IPhone("ȫ�浿",true,77) -> ȫ�浿 / ON / 77*/
		
		// ����
		
		IPhone p1 = new IPhone("ȫ�浿");
		IPhone p2 = new IPhone("�̱浿",true);
		IPhone p3 = new IPhone("ȫ�浿",true,77);
		
		p1.show();
		p2.power();
		p2.power();
		p2.soundDown(100);
		p2.soundUp(100);
		p2.show();
		
		
		System.out.println();
		
		// �����
		
		IPhone2 phone = new IPhone2("ȫ�浿", true);
		phone.power();
		phone.soundUp(100);
		phone.show();
	}

}
