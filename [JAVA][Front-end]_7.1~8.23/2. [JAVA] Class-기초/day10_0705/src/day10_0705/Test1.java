package day10_0705;

import java.util.Random;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// Scanner -> Ŭ���� (���� �빮�ڸ� Ŭ������.)
		System.out.print("�迭�����Է�: ");
		int num = sc.nextInt();
		
		int[] data = new int[num];
		// new������
		// heap �޸𸮿��� ��� -> ������ ����
		// �ڵ��ʱ�ȭ, ���α׷��������Ŀ��� �̿밡���� ����
		
		Random rand = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100)+1; // 0~99 -> 1~100
		
		}
		System.out.print("[ ");
		for(int v:data) {
			System.out.print(v+" ");
		}
		System.out.println("]");

		// �������� ���� == ��������
		for(int i = 0; i < data.length-1;i++) { // data.length �� �ص� ��� ����
		//���������� ������ ������ŭ ȸ������!
			for(int j = 0; j<data.length-1;j++) {
				// �񱳼����� [�����Ͱ���-1]�� !!!!
				if(data[j] > data[j+1]) { // �ռ�>�޼�
					// ��ȯ�� ������ �����ӿ� ���� -> if
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
		
		System.out.print("[ ");
		for(int v:data) {
			System.out.print(v+" ");
		}
		System.out.print("] ");
		
	}//main ����

}
