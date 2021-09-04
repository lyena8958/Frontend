package day17_0720;
// �ݳ������� ����
// ����ڻ���
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
	         System.out.println("�뿩�Ұ���!");
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
	   int cnt; // ���� �Ǽ�
	   int check; // ���� �Ǽ�
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
	         return name+" [�뿩����]";
	      }
	      return name+" [�뿩�Ұ�]";
	   }
	   boolean func0() {
	      if(cnt>0) {
	         return true;
	      }
	      else {
	         System.out.println("�̹� �뿩�� �����Դϴ�.");
	         return false;
	      }
	   }
	   void func1() {
	      System.out.println("�뿩����˴ϴ�.");
	      cnt--;
	   }
	   void func2() {
	      if(cnt==check) {
	         System.out.println("�߸��� ������ �ݳ��ϼ̽��ϴ�.");
	      }
	      else {
	         System.out.println("�ݳ�����˴ϴ�.");
	         cnt++;
	      }
	   }
	}

public class Test2_1 {
			// LinkedList 
			// �����������α׷�
			// 3�� Book ����, �뿩����(����ִ���)
			// 1.�뿩 2.�ݳ� 3.��Ϻ��� 4.����
			// +++)Persom
	public static void main(String[] args) {
		
		
		Member mem = new Member("�Ӳ���");
		
		// �����������α׷�
		
		Scanner sc = new Scanner(System.in);
		LinkedList<Book> data = new LinkedList(); //ArrayList�� ����
		// �������� �뿩������ �뿩�� å�� ���� == LL
		// �뿩������ ������ ���ܵδ� �� == AL
		data.add(new Book("�ظ�����"));
		data.add(new Book("�����"));
		data.add(new Book("������"));
		
		while(true) {
			System.out.println("1.�뿩 2.�ݳ� 3.��� 4.����");
			int act =sc.nextInt();
			if(act==1) {
				if(!mem.func3()) {//�뿩�� �Ұ����ϸ� 
					// false�� ��ȯ�ǹǷ� �ݴ�
					continue;
				}
		          System.out.println("å ��ȣ�Է�");
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
					System.out.println("�ش�å����");
				}
			}//�뿩
			else if(act==2) {
				System.out.println("å ��ȣ�Է�");
				int num = sc.nextInt();
				boolean flag =true;
				for(int i = 0; i < data.size();i++) {
					if(num==data.get(i).num) {//��ü.��ü��ȣ.å��ȣ
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
				System.out.println("�߸��� �Է�!");
			}
		
			
		}

	}

}
