package day09_0702;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		�迭2)
//		������ 1���Է� 6
//		[ 1 2 3 4 5 6 ] �迭������ ����
//		������ 1���Է� 2
//		[ 5 6 1 2 3 4 ] ���������� >> 2ĭ �̵�!
		
		// ������� ��!
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭ũ���Է�: ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length;i++) {
			arr[i] = i+1;
		}
		System.out.print("��ĭ�̵�? ");
		int move = sc.nextInt();
		//move %= num; // ������ Ƚ���� ���̱� ����
		
		// -�Է¿� ���ؼ��� -2 == 4 �� ����. 
		
		//	if(move < 0) {
		//		move += num; 
		//	}
		
		int[] res = new int[num];
		for(int i = 0; i < arr.length;i++) {
			res[(i+move)%num] = arr[i];
		}
		
		
		/* ���� �ٸ�ǰ
		System.out.print("������ 1���Է�: ");
		int num2 = sc.nextInt();
		System.out.print("������ 1���Է�: ");
		int move = sc.nextInt();
		
		int [] arr2 = new int[num2];
		
		int[] moveArr = new int[num2];
		// 1~6
		for(int i = 0; i< arr2.length; i++) {
			arr2[i] = i+1;
			System.out.print(arr1[i]+" ");
		}
		
		// 0 ~ 5
		for(int i = 0; i< arr2.length; i++) {
			// 0 ~ 5
			for(int j = 0; j<arr2.length;j++) {
				if(move+j < arr2.length) {
					moveArr[i] = arr2[move+j];	
				}
				else {
					moveArr[i] = arr2[0];
				}
			}}
			for(int i = 0; i<arr2.length;i++) {
					System.out.print(moveArr[i]+" "); 
			}
				
*/
	}

}
