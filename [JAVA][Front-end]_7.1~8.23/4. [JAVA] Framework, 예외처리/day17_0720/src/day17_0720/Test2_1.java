package day17_0720;
// 반납로직은 제외
// 사용자생성
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
class Member{
	   String name;
	   int num;
	   LinkedList<Book> data;
	   int limit;
	   Member(String name){
	      this.name=name;
	      this.num=new Random().nextInt(900)+100; // 100~999
	      this.data=new LinkedList();
	      this.limit=2;
	   }
	   boolean func3() {
	      if(data.size()==limit) {
	         System.out.println("대여불가능!");
	         return false;
	      }
	      return true;
	   }
	   void func4(Book book) {
	      data.add(book);
	   }
	}

	class Book{
	   String name;
	   int num;
	   int cnt; // 현재 권수
	   int check; // 원래 권수
	   Book(String name){
	      this.name=name;
	      this.cnt=2;
	      this.check=2;
	      this.num=new Random().nextInt(90)+10; // 10~99
	      System.out.println(name+" ["+num+"]");
	   }
	   @Override
	   public String toString() {
	      if(this.cnt!=0) {
	         return name+" [대여가능]";
	      }
	      return name+" [대여불가]";
	   }
	   boolean func0() {
	      if(cnt>0) {
	         return true;
	      }
	      else {
	         System.out.println("이미 대여된 도서입니다.");
	         return false;
	      }
	   }
	   void func1() {
	      System.out.println("대여진행됩니다.");
	      cnt--;
	   }
	   void func2() {
	      if(cnt==check) {
	         System.out.println("잘못된 도서를 반납하셨습니다.");
	      }
	      else {
	         System.out.println("반납진행됩니다.");
	         cnt++;
	      }
	   }
	}

public class Test2_1 {
			// LinkedList 
			// 도서대출프로그램
			// 3권 Book 제목, 대여여부(몇권있는지)
			// 1.대여 2.반납 3.목록보기 4.종료
			// +++)Persom
	public static void main(String[] args) {
		
		
		Member mem = new Member("임꺽정");
		
		// 도서대출프로그램
		
		Scanner sc = new Scanner(System.in);
		LinkedList<Book> data = new LinkedList(); //ArrayList도 무관
		// 도서에서 대여했을때 대여된 책을 제거 == LL
		// 대여했을때 공간을 남겨두는 것 == AL
		data.add(new Book("해리포터"));
		data.add(new Book("어린왕자"));
		data.add(new Book("춘향전"));
		
		while(true) {
			System.out.println("1.대여 2.반납 3.목록 4.종료");
			int act =sc.nextInt();
			if(act==1) {
				if(!mem.func3()) {//대여가 불가능하면 
					// false가 반환되므로 반대
					continue;
				}
		          System.out.println("책 번호입력");
		            int num=sc.nextInt();
		            boolean flag=true;
		            for(int i=0;i<data.size();i++) {
		               if(num==data.get(i).num) {
		                  flag=false;
		                  if(data.get(i).func0()) {
		                     data.get(i).func1();
		                     mem.func4(data.get(i));
		                  }
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
