package day10_0705;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1�� ����) �޴��� ��ȣ�� �Է��ϼ���
		// 1��°: 010
		// 2��°: 1234
		// 3��°: 5678
		
		/* ����� ��
	     System.out.println("�޴��� ��ȣ�� �Է��ϼ���.");
	      String str=sc.next();
	      String[] number=str.split("-");
	      for(int i=0;i<number.length;i++) {
	         System.out.println((i+1)+"��°: "+number[i]);
	      }*/
		
		
		/* ����
		System.out.println("�޴��� ��ȣ�� �Է��ϼ���.");
		String str = sc.next();
		String[] phoneNum = str.split("-");
		
		int i = 1;
		for(String v:phoneNum) {
			System.out.println(i+"��°: "+v);
			i++;
		}
		*/
		
	    //====================================================
		
		// 2�� ����)
		// ��ҹ��ڰ� ���� ���ڿ��� �Է�
		// �ҹ��ڷ� apple
		// �빮�ڷ� APPLE
	      
		/* ����� ��!
	     System.out.println("��ҹ��ڰ� ���� ���ڿ� �Է�");
	     String str2=sc.next();
	     System.out.println("�ҹ��ڷ� "+str2.toLowerCase());
	     System.out.println("�빮�ڷ� "+str2.toUpperCase());*/
	      
		/*����
		System.out.print("��ҹ��ڰ� ���� ���ڿ��� �Է�");
		String str2 = sc.next();
		System.out.println("�ҹ���: "+str2.toLowerCase());
		System.out.println("�빮��: "+str2.toUpperCase());*/
		
		//====================================================
		
		// 3�� ����)
		// �ٽ��ұ��? y, yes, yEs, Y, YeS ... ��� ����
	    // [�������]
		
	    // ������� ��!
	    // 1. �˿���� - ���ӿ��� �弳���ϸ� *** ó���Ǵ� ��ó��
		/*
		String [] checkData = new String[3]; // �˿����ܾ���
		checkData[0] = "yes";
		checkData[1] = "Yes";
		checkData[2] = "yEs";
		
		while(true) {
			System.out.println("����ұ��?");
			String ans = sc.next();
			Boolean flag = false;
			for(int i = 0; i < checkData.length;i++) {
				if(checkData[i].equals(ans)) {
					flag=true;
					break;
				}
			}
			if(flag) { // �˿��ܾ ans�� �ִٸ�,
				break;
			}
	     } */
		
		// 2. �Ҵ빮�� ��ȯ
		while(true) {
			System.out.println("�ٽ��ұ��?");
			String ans = sc.next();
			ans = ans.toLowerCase();
			// yes, Yes, YES -> yes
			// y, Y -> y
			if(!ans.equals("yes") && !ans.equals("y")) {
				break;
			}
			
		}//while ����
	     
		
		/* ����
		System.out.print("�ٽ� �Ͻðڽ��ϱ�? ");
		String ans = sc.next();
		
		ans = ans.toLowerCase();
		
		while(true)(
		if(ans.equals("y")||ans.equals("yes")) {
			System.out.println("��� ����....");
		}
		else {
			System.out.println("[��� ����]");
			break;
		}
	}*/
		

	} // main����

}
