package day09_0702;

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr= new int[3];
		for(int i = 0; i < arr.length;i++) {
			arr[i] = i+1;
			// ����!
		}
		
		// value�� ����. ���� ���� ������ �ȴ�
		for(int v:arr) {
			// v�� arr�� �����͵��� ���纻�ϻ�!
			v+=2;
			System.out.println(v);
		}
		for(int v:arr) {
			// �������� ���� 
			System.out.println(v);
		}
		
		for(int i = 0; i < arr.length;i++) {
			System.out.println(arr[i]);
		}
		

	}// main ����

}
