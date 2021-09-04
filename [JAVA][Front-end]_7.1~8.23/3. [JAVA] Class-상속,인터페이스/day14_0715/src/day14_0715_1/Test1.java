package day14_0715_1;

import java.util.Scanner;

// 1) 상속->계층 설계(==정의단계)
// 2) 멤버변수, 메서드 정의(구현)
// 3) 생성자 정의
abstract class Phone{ //class Phone{ 
	String name; // 이름
	String num; // 전화번호
	String[][] data; // 전화번호부(이름,전화번호)
	int index; // 전화번호부에 현재 저장된 데이터의 개수(강사님)
	Phone(String name, String num){
		this.name = name;
		this.num = num;
		this.data = new String[2][3]; // 3명의 이름과 전화번호(2행 5열)
		this.index=0;
	}
	void play() {
		System.out.println("음악재생");
	}
	abstract void call();
//	void call() { // 스마트폰 호출
//		System.out.println("스마트폰 호출");
//	}
//	void addData() { // 강사님
//		// 직접입력
//	}
	void addData(String name, String num) { // 강사님
		// 데이터공간 한정되어있기때문에, 크기를 가장먼저 물어본다!!!!!!
		if(data[0].length ==index) {
			System.out.println("메모리부족!");
			return;
		}
		
		// ...인자로 값을 받아옴
		// 중복입력값이 인자로 들어오면 메서드 즉시종료
		
		// 이 부분에서 중복체크를 진행할예정!
		// 중복체크를 통과한 데이터만이 저장가능한 데이터이다!!!
		for(int i =0; i<index; i++) {
			// 현재 데이터를 2개 추가하여 index==2인 상황(가정)
			// 내가 검사할 데이터의 개수는 2개(0, 1)
			// i = 0, i = 1 총 2번 검사한다!
			if(name.equals(data[0][i])) {
				System.out.println("이름중복");
				return; //메서드 즉시종료(함수종료하는 기능)
			}
			else if(num.equals(data[1][i])) {
				System.out.println("번호중복");
				return; //(메서드 즉시종료(함수종료하는 기능)
			}
		}
		
		// 전화번호부에 데이터의 개수를 측정하는 방법
		// 1) null일때까지 계속 
		// 2) 개수를 저장하는 변수가 필요
		data[0][index]= name;
		data[1][index]= num;
		index++; // index가 0-> 1
		System.out.println("저장완료!");
		for(int i = 0; i < index; i++) {
			System.out.println((i+1)+". "+data[0][i]+" "+data[1][i]);
		}
	}
	void DataAdd() { //예나
		Scanner sc = new Scanner(System.in);
		int i = 0; 
		while(true) {
			System.out.println("전화번호부를 추가하시겠습니까? 예: 1번, 종료: 2번");
			int ans = sc.nextInt();
			if (ans == 1) {
				while (i<3) {
					Boolean flag = false; // 동일값있는지여부
					System.out.println((i+1)+"번 이름을 입력해주세요. ");
					String name = sc.next();
					System.out.println((i+1)+"번 전화번호를 입력해주세요.(\"-\" 표시)");
					String num = sc.next();
					for (int j = i; j >= 0; j--) {
						if (name.equals(this.data[0][j])|| num.equals(this.data[1][j])) {
							flag = true;
							break;
						}
					} // for 종료
					if(flag) {
						System.out.println("동일 데이터가 있어 저장이 불가합니다. 다시 입력해주세요.\n");
						continue;
					}
						System.out.println("입력완료!! "+name+" "+num);
						this.data[0][i] = name;
						this.data[1][i] = num;
						i++;
						System.out.println();
				}
				System.out.println("최대 저장값 초과로 전화번호 부가 종료됩니다.");
			}
			else if(ans == 2) {
				System.out.println("종료됩니다!");
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.(1~2번)");
			}
		}
	}

}
class Galaxy extends Phone{
	Galaxy(String name, String num) {
		super(name, num);
		System.out.println(this.name+"님, 갤럭시 등록완료!");
	}
	// 오버라이딩을 해야하는 상황(호출->빅스비)
	// 강제하지않고있음!
	void call() { 
		System.out.println("하이 빅스비~");
	}
}

class IPhone extends Phone {
	IPhone(String name, String num) {
		super(name, num);
		System.out.println(this.name + "님, 아이폰 등록완료!");
	}
	// 오버라이딩
	void call() {
		System.out.println("시리야!~~");
	}
}

public class Test1 {
static int NumCheck(int a, int b, int num) {
	/* !!!!!!!!!!!!!!문제!!!!!!!!!!!!!!!!
	1. 아이폰 생성
	2. 갤럭시 생성

	"폰"은 전화번호부에 사람을 추가할수있습니다!
	사람의 수는 한정되어있다.
	이름이나 번호가 중복되어 저장되지않도록 해주세요!~~
	 -> 기능 추가 (메서드 구현)

	1,2의 객체를 이용하여 전화번호부를 등록해주세요!~~ */ 
	Scanner sc = new Scanner(System.in);
	while(true) {
		if(num<a || b< num) {
			System.out.println("오입력: "+a+"이상 "+b+"이하로 입력해주세요.");
			num = sc.nextInt();
			continue;
		}
		break;
	}
	return num;
}
	public static void main(String[] args) {
		Galaxy g1 = new Galaxy("푸딩", "010-3333-6666");
		IPhone i1 = new IPhone("망고", "010-7777-7777");
		
		g1.call();
		i1.call();
		g1.DataAdd();
		System.out.println(g1.data[0][0]+" "+g1.data[1][0]);
		g1.DataAdd();
//		for(String[][] v: data) {
//			System.out.print(v+" ");
//		}
		
		//강사님
		IPhone phone = new IPhone("이름","010-1111-1111");
		// 사용자들은 일반 Phone 객체보다
		// IPhone, Galaxy를 더 이용한다. -> Phone call를 사용할 필요가 없다.
		
	      IPhone iPhone=new IPhone("아무무","010-1234-1234");
	      iPhone.addData("아리","010-1234-5678");
	      iPhone.addData("티모","010-1234-9876");
	      iPhone.addData("가렌","010-4321-9876");
	      iPhone.addData("제드","010-1111-9876");
	      

	}

}
