package day11_0706;

// 강사님
class IPhone2{
	IPhone2(String name){
		this(name,false,50); // 입력하지 않은것은 고정값을 둔다. false,50
		
	}
	IPhone2(String name, boolean power){
		this(name,power,50); // 입력하지 않은것은 고정값을 둔다. 50
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
			System.out.println(this.name+"님의 현재 음량은"+this.sound+"입니다.");
		}
		else {
			System.out.println("전원 OFF");
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
			System.out.println("사운드++");
		}
		else {
			System.out.println("전원OFF");
		}
	}
	void soundDown() {
		if(this.power) {
			this.sound-=sound;
			if(this.sound<0) {
				this.sound = 0;
			}
			System.out.println("사운드--");
		}
		else {
			System.out.println("전원OFF");
		}
	}
	
	
}


// 예나
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
		//전원 on <> off
		this.onOff = this.onOff==true ? false : true;
		System.out.println("전원이"+onOff+"로 바꼈습니다.");
	}
	void soundUp(int sound) {
		// 전원이 꺼지면 전원 OFF
		if(!this.onOff) {
			System.out.println("[ERROR] 휴대폰 전원 OFF");
		}
		else {
			this.sound += sound;
			if(sound > 100) {
				this.sound = 100;
			}
			System.out.println("sound "+this.sound+"으로 변경 되었습니다.");
		}
	}
	void soundDown(int sound) {
		// 전원이 꺼지면 전원 OFF
		if(!this.onOff) {
			System.out.println("[ERROR] 휴대폰 전원 OFF");
		}
		else {
			this.sound -= sound;
			if(this.sound<0) {
				this.sound = 0;
				System.out.println("sound "+this.sound+"으로 변경 되었습니다.");
			}
		}
	}
	void show() {		
		// 전원OFF
		if(!this.onOff) {
			System.out.println("[ERROR] 휴대폰 전원 OFF");
		}
		else {
			System.out.println(userName+"님의 현재 음량은"+sound+"입니다.");
		}
	}

	String userName;
	Boolean onOff; // ON/OFF
	int sound; // 0~100
}

public class Test5 {

	public static void main(String[] args) {
	/*	##문제##
		class IPhone
		   유저이름
		   전원상태 ON/OFF
		   음량 0~100
		   void show()
		      : 전원 OFF
		      : 홍길동님의 현재 음량은 50입니다.
		   void power()
		      : 전원 ON <-> OFF
		   void soundUp(int sound)
		      : 전원 OFF
		      : sound입력한 값만큼 ++
		   void soundDown(int sound)
		      : 전원 OFF
		      : --
		IPhone("홍길동") -> 홍길동 / OFF / 50
		IPhone("홍길동",true) -> 홍길동 / ON / 50
		IPhone("홍길동",true,77) -> 홍길동 / ON / 77*/
		
		// 예나
		
		IPhone p1 = new IPhone("홍길동");
		IPhone p2 = new IPhone("이길동",true);
		IPhone p3 = new IPhone("홍길동",true,77);
		
		p1.show();
		p2.power();
		p2.power();
		p2.soundDown(100);
		p2.soundUp(100);
		p2.show();
		
		
		System.out.println();
		
		// 강사님
		
		IPhone2 phone = new IPhone2("홍길동", true);
		phone.power();
		phone.soundUp(100);
		phone.show();
	}

}
