package day10_0705;

import java.util.Scanner;

public class Test4 {
// next - �ΰ� ���Ծȵ�(���� x), 	nextLine - �ΰ� ���԰���(���� ����)
	public static void main(String[] args) {
		/*
		String str = "BanaNA";
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.toLowerCase()); // �ҹ��ڸ� ��������(���� �� ��ȭ����)
		System.out.println(str);*/
		// �� String�� value�� �ƴ϶�, ��ü�� �̷�����ִ�.
		
		String str2 = "����� ������ xx��";
		String[] strData = str2.split(" "); // ���� �������� �ڸ���! // ��ȭ��ȣ "-" �� ���ӻ� ����
		for(String v:strData) {
			System.out.println(v);
		}
		
		String str3 = "applepiebanana";
		System.out.println(str3.substring(5)); //0~4���� �ε����� �ڸ��� �׵��� ���� ���
		// substring�� �����ε����� �Ѱ��� �� �ִµ�, �ε����� ���ڸ��� ������ �� �ִ�~!
		// �ε�����ŭ �߶� ���ڿ��� ���δ�
		
		
		// int a = 10; (�������, �ּ�, ������) -> ����Ÿ��!!
		
		// String 
		// 1)�迭������ŭ ���� ����(������ ���� ������ִ�, �޸𸮿��� �ּҸ� ����Ǿ� ����) 
		//   -> �񱳽��� �ϸ� strarr[0] == strarr[1]�� �ּҰ��� ���İ� ����°Ŵ�.
		
		
		Scanner sc = new Scanner(System.in);
		// String�� �ڷ���(int..)���ٴ� Scanner�� ���� Ŭ���� �����̴�.
		String[] strArr=new String[3];
		strArr[0] = "apple";
		System.out.print("�ι�° �ܾ�: ");
		strArr[1] = sc.next();
		System.out.print("����° �ܾ�: ");
		sc.nextLine(); // �Ʒ� ���ڿ��� �ȵ��� ���鰪�� �־���� �Ѵ�.
		strArr[2] = sc.nextLine(); //next() ��������ν� ���Ͱ��� ��
		
		for(String v:strArr) {
			System.out.println(v);
		}
		
		// strArr[0~2] ���� ���� �ܾ �Է����� �� �Ʒ� Ȯ��!�� ����� �ȵȴ�.
		// ����? 18~20Line ���� -> �ּҶ� ���ϱ� ����
		//��ºҰ�!!!!
		if(strArr[0]==strArr[1]) { // ���� c������ strcmp����߾���.
			System.out.println("Ȯ");
		}
		else if(strArr[0]==strArr[2]) {
			System.out.println("��");
		}
		else if(strArr[1]==strArr[2]) {
			System.out.println("!");
		}
		
		//1���� ��°���!!!!!
		// ����? next(), nextLine() ������ �ٸ��� �����̴�. ->���⸦ ������� �ʴ��̻�: next����ϴ°��� �� ����.
		// nextLine: "apple\0"�� �Ǿ��ְ�, next: "apple"�� �Ǿ��ִ°Ŷ� �ٸ�����
		if(strArr[0].equals(strArr[1])) {
			// �������� ���� ���Ҽ��ְԵ�!! -> equals �޼ҵ�
			System.out.println("Ȯ");
		}
		else if(strArr[0].equals(strArr[2])) {
			System.out.println("��");
		}
		else if(strArr[1].equals(strArr[2])) {
			System.out.println("!");
		}
		
		
		
		
		
		
		
	} // main����

}
