package day17_0720;
// 사용자없는모드
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
class Book{
	
	String name;
	int num;
	boolean check;
	Book(String name){
		this.name = name;
		this.check = true;
		this.num = new Random().nextInt(90)+10; // 10~90
		System.out.println(name+" ["+num+"]");
	}
	@Override
	public String toString() {
		if(check) {
			return name+"   [대여가능]";
		}
		return name+"   [대여불가]";
	}
	void func() {// 대여판단여부 함수
		if(check) {
			System.out.println("대여진행됩니다.");
			check=false;
		}
		else {
			System.out.println("이미 대여된 도서입니다.");
		}
	}
	void func2() {// 반납판단여부 함수
		if(check) {
			System.out.println("잘못된 도서를 반납하셨습니다.");
		}
		else {
			System.out.println("반납 진행 됩니다.");
			check=true;
		}
	}
}
public class Test2 {
			// LinkedList 
			// 도서대출프로그램
			// 3권 Book 제목, 대여여부(몇권있는지)
			// 1.대여 2.반납 3.목록보기 4.종료
			// +++)Persom
	public static void main(String[] args) {
		
		// 도서대출프로그램
		
		Scanner sc = new Scanner(System.in);
		LinkedList<Book2> data = new LinkedList(); //ArrayList도 무관
		// 도서에서 대여했을때 대여된 책을 제거 == LL
		// 대여했을때 공간을 남겨두는 것 == AL
		data.add(new Book2("해리포터"));
		data.add(new Book2("어린왕자"));
		data.add(new Book2("춘향전"));
		
		while(true) {
			System.out.println("1.대여 2.반납 3.목록 4.종료");
			int act =sc.nextInt();
			if(act==1) {
				System.out.println("책 번호입력");
				int num= sc.nextInt();
				boolean flag =true;
				for(int i = 0; i < data.size();i++) {
					if(num==data.get(i).num) {//객체.객체번호.책번호
						flag = false;
						data.get(i).func();
						break;
					}
				}
				if(flag) {
					System.out.println("해당책없음");
				}
			}//대여
			else if(act==2) {
				System.out.println("책 번호입력");
				int num = sc.nextInt();
				boolean flag =true;
				for(int i = 0; i < data.size();i++) {
					if(num==data.get(i).num) {//객체.객체번호.책번호
						flag = false;
						data.get(i).func2();
						break;
					}
				}
			}
			else if(act==3) {
				System.out.println(data);
			}
			else if(act==4) {
				break;
			}
			else {
				System.out.println("잘못된 입력!");
			}
		
			
		}

	}

}
