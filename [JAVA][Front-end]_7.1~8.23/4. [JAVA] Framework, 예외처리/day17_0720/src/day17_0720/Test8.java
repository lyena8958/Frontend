package day17_0720;

import java.util.InputMismatchException;
import java.util.Scanner;
//class Exception{//�μ��� Ŭ������ ��� �̷��� �Ǿ�����������?? -> ����
//	private String message;
//	public String getMessage() {
//		return message;
//	}
//	Exception(){
//		this("");
//	}
//	Exception(String message){
//		this.message =message;
//	}
//}
class Actexception extends Exception{
	Actexception(String msg){
		super(msg);
		
	}
}
public class Test8 {

	public static void main(String[] args) {
		// ���� ����� ����!
		
		//int a=10;
		// Car car=new Car(a);  --> car(int a) �������϶� ������ �Է��� �����ϵ���
		
		Scanner sc = new Scanner(System.in);
									// ������ڰ� ����ǰ����ǳ�? -> �����ε��Ȱų�!
		//Exception excep = new Exception("1~3�� �Է°���!"); //�����ε�)�μ��� ��ü����
		//�Ʒ� ����ó��(����)�� �߻���Ű������ ��üȭ�� ���̴�. 
		Actexception excep = new Actexception("1~3�� �Է°���!");
		//System.out.println(excep.getMessage());
		
		int act;
		while(true) {
			System.out.println("1. 2. 3.");
			try {
				act = sc.nextInt();
				System.out.println(10/act);
				// ���ܰ� �ƴѰ��� ���ܷ�ó���ϴ�����(if�ε� �����ϴ� ���ܷε� ó���Ҽ��ִ�)
				// throw
				if(act<1||3<act) {//ĳġ���̵�
					throw excep; //�����Ϻη��߻�!
				}
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("�ڷ����� �ùٸ����ʽ��ϴ�!");
				continue;
			}catch(Actexception e) {// ������ Ŭ������ �Է��ϰ������
				System.out.println(e.getMessage());
				System.out.println("�ٽ��Է��غ�����!~~");
				continue;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());// �������Էºκ�
				continue;
			}
			
		
			 
			if(act==1) {
				
			}else if(act==2) {
				
			}
			else {//3���� ������ �극��ũ
				break;
			}
		}
		

	}

}
