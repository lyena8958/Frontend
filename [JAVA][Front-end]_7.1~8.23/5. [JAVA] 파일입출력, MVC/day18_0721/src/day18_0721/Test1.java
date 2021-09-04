package day18_0721;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

//�����
class EvenException extends Exception{
	EvenException(){
		super("¦���� �Է��ϼ̽��ϴ�.");
	}
}


//����
class ActException extends Exception{
	ActException(String msg){
		super(msg);
	}
	
	
}
public class Test1 {
	public static void main(String[] args) {
		// ����
		/*ArrayList data 
		 1) ������ �Է�
		-> ���ڿ� �Է�xxx
		=> ���ܰ��߻��ϸ� �ٽ� �Է�
		 2) �����߿����� Ȧ���� �Է�
		-> ¦�� => ���ܷν� ó�����ּ���!~~
		 3) 5���� ����Ǹ� ����
		 4) itr�� ����Ͽ� �ѹ��� �����͸� ���*/

		Scanner sc = new Scanner(System.in);
	
		//�����
		ArrayList<Integer> data = new ArrayList();
		EvenException excep =  new EvenException();
		int num;
		while(data.size()<5) {
			System.out.println("�����Է�");
			try {
				 num =sc.nextInt();
				if(num%2==0) {
					throw excep;
					// Exception���� �ϰԵǸ� Ȧ����?�� �ٸ� ����ó���� �������°� ���ϱ� �����Ƿ� ��������ó���� �����.
				}
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("�ٸ�Ÿ���� �Է��ϼ̽��ϴ�!");
				continue;
			}catch(EvenException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(Exception e) {
				System.out.println("��Ȯ�ο��ܹ߻�!");
				continue;
			}
			data.add(num);
		}
		Iterator itr = data.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		
		// ����
		/*
		ArrayList al = new ArrayList();
		ActException exc = new ActException("¦���Է� �Ұ�! Ȧ���� �ٽ��Է����ּ���.");
		
		while(al.size()<5) {
			int num = 0;
			System.out.println("������ �Է��ϼ���.");
			try {
				num = sc.nextInt();	
				if(num%2==0) {
					throw exc;
				}
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("Ÿ�� ����! �ٽ� �Է��ϼ���.");
				continue;
			}
			catch(ActException e) {
				System.out.println(e.getMessage());
				continue;
			}
			catch(Exception e) {
				e.printStackTrace();
			}			 	
			System.out.println(num+"�Է¿Ϸ�!");
			al.add(num);
			
		}
		
		Iterator<Integer> itr = al.iterator();
		
		System.out.println("����� Ȧ�� �����Դϴ�.");
		System.out.println(al);*/
		
		
		
	}


}
