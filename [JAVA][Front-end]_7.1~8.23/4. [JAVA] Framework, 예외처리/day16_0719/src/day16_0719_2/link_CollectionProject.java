package day16_0719_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Book{
	Book(String name){// 사용자 전용
		this.name = name;
	}
	Book(String name, int cnt){// 사서 전용
		this.name = name;
		this.cnt = cnt;
		System.out.println(this.name+" 추가 완료!");
	}
	
	String name; // 책이름
	int cnt; //재고
	@Override
	public String toString() {
		return this.name + ": [" + this.cnt + "]" ;
	}
}
class Person{
	Person(String name){
		this.name = name;
		this.MemberNum++;
		System.out.println(this.name+"님 반갑습니다! 앞으로 사용될 회원번호는 "+ this.MemberNum+"입니다.");
	}
	
    String name; // 회원 이름
	static int MemberNum = 0000; // 회원번호
	//ArrayList <Book>bookList = new ArrayList(); //배열리스트 생성(캐스팅: Book클래스)
	
	//void BookAdd(int bookNum) {
	//	bookList.add(new Book(bookNum));
	//}
	ArrayList <Integer>bookList = new ArrayList(); //배열리스트 생성(캐스팅: Book클래스)
	
	void BookAdd(int bookNum) {
		bookList.add(bookNum);
	}


}

public class link_CollectionProject {
	//유효성검사 함수
	static int NumCheck(int a, int b, int num) {
		
		while (true) {
			if (num < a || b < num) {
				System.out.println("[오류] " + a + "이상 " + b + "이하로 다시 입력해주세요!");
				num = new Scanner(System.in).nextInt();
				continue;
			}
			break;
		}
		
		return num; // 올바른 숫자 리턴
	}
	//회원번호 유효성검사
	static Boolean MemCheck(int memNum, ArrayList<Person> member) {
		for(int i = 0; i < member.size();i++) {
			if(memNum==member.get(i).MemberNum) {
				System.out.println(member.get(i).name+"님 반갑습니다!");
				return false;
			}
		}
		System.out.println("회원번호가 일치하지않아 이용이 불가합니다.");
		return true;
	}
	// LinkedList 
	// 도서대출프로그램
	// 3권 Book 제목, 대여여부(몇권있는지)
	// 1.대여 2.반납 3.목록보기 4.종료
	// +++)Person
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Book> book = new LinkedList();
		ArrayList<Person> member= new ArrayList();

		book.add(new Book("어린왕자", 3));
		book.add(new Book("백설공주", 2));		
		book.add(new Book("인어공주", 1));
				
		while(true) {
			System.out.println("0. 사용자등록     1. 대여     2. 반납     3. 목록보기     4. 종료");
			int PickNum = sc.nextInt();
			if (PickNum==0) { // 사용자등록
				System.out.print("회원등록을 위한 이름을 입력해주세요!! ");
				 member.add(new Person(sc.next()));
			}
			else if(PickNum==1) {// 대여
				System.out.println("=====책 목록=====");
				for(int i = 0; i < book.size(); i++) {
					System.out.println((i+1)+". "+book.get(i));
				}
				System.out.println("============\n");
				System.out.println("대여할 책 번호를 입력해주세요.");
				int bookNum = NumCheck(1, book.size(), sc.nextInt()); // 1번부터 책개수이하 유효성검사
				if(book.get(bookNum-1).cnt==0) {
					System.out.println("현재 재고가 없어 대여가 불가합니다. 첫 화면으로 이동됩니다.");
					continue;
				}
				System.out.print("회원번호를 입력해주세요: ");
				int memNum = sc.nextInt();
				if(MemCheck(memNum, member)) { // 회원번호가 같지않다면
					continue;
				}
				book.get(bookNum-1).cnt--;
				member.get(memNum-1).BookAdd(bookNum-1);// 대여책 번호입력 //회원번호 - 1번 == 인덱스
				System.out.println(book.get(bookNum-1).name+"책 대여 완료되었습니다!!\n");
			}
			else if(PickNum==2) { // 반납
				System.out.print("회원번호를 입력해주세요: ");
				int memNum = sc.nextInt();
				if(MemCheck(memNum, member)) {
					System.out.println("회원번호가 일치하지 않아 서비스 이용이 불가합니다.\n");
					continue;
				}
				System.out.println("반납할 책 번호를 입력해주세요! ");
				int bookNum = sc.nextInt();
				boolean flag = true; //반납완료여부
					for(int j = 0; j < member.get(memNum-1).bookList.size(); j++) { // 해당 회원의 대여개수까지 반복
						if(bookNum == (Integer)member.get(memNum-1).bookList.get(j)) { // 책번호와 회원의 대여한 책의 번호가 같다면
							System.out.println("반납 완료 되었습니다!\n");
							member.get(memNum-1).bookList.remove(j); //사용자 반납처리
							book.get(bookNum-1).cnt++;
							flag = false;
							System.out.println("=====현재 미납된 책번호입니다.=====");
							for(Person v: member) {
								System.out.println(member.get(j).bookList);
							}
							System.out.println();
						}
					}//for종료
				if(flag) { // 번호가 같지않으면 반납불가
					System.out.println("입력하신 책은 반납 대상이 아닙니다!\n");
					continue;
				}
			}
			else if(PickNum==3) {// 목록보기
				System.out.println("====책 목록====");
				for(int i = 0; i < book.size();i++) {
					System.out.println((i+1)+". "+book.get(i)+"\t");
				}
				System.out.println("============\n");
			}
			else if(PickNum==4) {//종료
				System.out.println("도서 프로그램이 종료됩니다. 이용해 주셔서 감사합니다. *^^*");
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다. 1~4번 을 선택해주세요.");
			}
			
			
		}
		
		
	}//main종료

}
