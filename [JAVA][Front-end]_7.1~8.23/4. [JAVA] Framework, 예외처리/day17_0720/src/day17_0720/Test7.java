package day17_0720;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {//.
			
			System.out.println("����Է�");
			try {//�Էµ� ��Ʈ���� �ִٸ� ���ۿ� ���ڰ� �����־� ���ѹݺ��� �ϰԵ�
				num = sc.nextInt();
			}
			catch(InputMismatchException e) {
				sc.nextLine(); // ��������(�����ִµ����ʹ� �������.)
				System.out.println("�ڷ����� �ùٸ����ʽ��ϴ�!");
				num=0;//�Ʒ� ����else�� ��������
				//num��� continue;�ε� Ȱ�밡��
			}
			if(num>0) {
				break;
			}
			else {
				System.out.println("�ٽ�!");
			}
			
		}
		
	}

}
