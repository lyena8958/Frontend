package day17_0720;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

class AgeException extends Exception{
	AgeException(){
		super("���̹�������!"); // �����ڰ� ���ϴ¸�Ʈ�� �����Բ� �ϱ�����
	}
}

public class Test9 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		// ����ī��������
		
		// ���̸��Է��ϼ���
		// 1~100�� �Է°���
		// 0, -1, 101, 20000 => ��������!
		// 10��=> Ÿ�Թ���!
		//------------------------------------�ٽ��Է�
		//String[] data = [1. ���ұ��� 2. �ĺұ���ī�� ]
		// 1,2 => ī�����!
		// 1,2xx => �ε�����������!
		//------------------------------------�������ּ���
		//�׻� "�ȳ���������." ���� ������ּ���
		
		//Exception excep = new Exception("");
		AgeException ae = new AgeException();
		
	      while(true) {
	          System.out.println("�����Է�");
	          try {
	             int age=sc.nextInt();
	             if(age<1||100<age) {
	                throw ae;
	             }
		}catch(AgeException e) {//���������� �ϰ�; ������
			System.out.println(e.getMessage());
			System.out.println("���Է�!");
			continue;
		}catch(Exception e) {
			System.out.println("����� �����߻�!");
			return;
		}
		break;
	}
	      ArrayList<String> al=new ArrayList();
	      al.add("���ұ���ī��");
	      al.add("�ĺұ���ī��");
	      Iterator itr=al.iterator();
	      while(itr.hasNext()) {
	         System.out.print(itr.next()+" ");
	      }
	      System.out.println();

	      System.out.println("����ī���ȣ�Է�");

	      try {
	         int num=sc.nextInt();
	         System.out.println(al.get(num-1)+"�� �����˴ϴ�.");
	      }catch(IndexOutOfBoundsException e) {
	         System.out.println(e.getMessage());
	         System.out.println("�ڵ����� "+al.get(al.size()-1)+"�� �����˴ϴ�.");
	         //return;
	      }finally {
	         System.out.println("�ȳ���������.");
	      }


		/*���Ƴ�
		Exception excep = new Exception("1~100 ������ ������ �Է��� �����մϴ�.");
		int ans;
		while(true) {// �����Է�
			
			System.out.println("���̸� �Է��ϼ���");
			try {
				ans = sc.nextInt();
				if(ans<1||100<ans) {
					throw excep;
				}
			}catch(InputMismatchException e) {
				System.out.println("�ڷ����� �ùٸ����ʽ��ϴ�. ������ �ٽ� �Է����ּ���!");
				sc.nextLine();//��������
				continue;
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("�ٽ� �Է��ϼ���!");
				sc.nextLine();//��������
				continue;
			}
			break;
		}
		String[] data = {"���ұ���", "�ĺұ���"};
		
		System.out.println("1. "+data[0]+"\t2. "+data[1]);
		System.out.print("�� ���� ���� �� �ϳ��� �������ּ���(1��, 2��)");
		
		ans = 0;
		try {
			ans= sc.nextInt();
			System.out.println(data[ans-1]+"ī�� ������ �Ǿ����ϴ�!");
		}catch(ArrayIndexOutOfBoundsException e) {
			sc.nextLine();
			System.out.println("�ùٸ��� ���� �Է����� �߱��� �ȵǾ����ϴ�.");
		}finally {
			System.out.println("�̿��� �ּż� �����մϴ�. �ȳ��� ������!");
		}*/
		
		
		
	}//main����

}
