package day17_0720;
// ����ھ��¸��
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
			return name+"   [�뿩����]";
		}
		return name+"   [�뿩�Ұ�]";
	}
	void func() {// �뿩�Ǵܿ��� �Լ�
		if(check) {
			System.out.println("�뿩����˴ϴ�.");
			check=false;
		}
		else {
			System.out.println("�̹� �뿩�� �����Դϴ�.");
		}
	}
	void func2() {// �ݳ��Ǵܿ��� �Լ�
		if(check) {
			System.out.println("�߸��� ������ �ݳ��ϼ̽��ϴ�.");
		}
		else {
			System.out.println("�ݳ� ���� �˴ϴ�.");
			check=true;
		}
	}
}
public class Test2 {
			// LinkedList 
			// �����������α׷�
			// 3�� Book ����, �뿩����(����ִ���)
			// 1.�뿩 2.�ݳ� 3.��Ϻ��� 4.����
			// +++)Persom
	public static void main(String[] args) {
		
		// �����������α׷�
		
		Scanner sc = new Scanner(System.in);
		LinkedList<Book2> data = new LinkedList(); //ArrayList�� ����
		// �������� �뿩������ �뿩�� å�� ���� == LL
		// �뿩������ ������ ���ܵδ� �� == AL
		data.add(new Book2("�ظ�����"));
		data.add(new Book2("�����"));
		data.add(new Book2("������"));
		
		while(true) {
			System.out.println("1.�뿩 2.�ݳ� 3.��� 4.����");
			int act =sc.nextInt();
			if(act==1) {
				System.out.println("å ��ȣ�Է�");
				int num= sc.nextInt();
				boolean flag =true;
				for(int i = 0; i < data.size();i++) {
					if(num==data.get(i).num) {//��ü.��ü��ȣ.å��ȣ
						flag = false;
						data.get(i).func();
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
