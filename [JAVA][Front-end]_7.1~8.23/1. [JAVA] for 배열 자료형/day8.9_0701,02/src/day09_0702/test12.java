package day09_0702;

import java.util.Random;
import java.util.Scanner;

/* ���ľ˰��� : �̺а˻� == ����Ž�� �ϱ�@@
1) �������� �� 10�� ����(����,1~100) - �ߺ������Ϸ��� ������ �а�����!
2) ������ ����! �����ؾ���
3) �̺а˻� �˰����� �������ּ���!~~ */
public class test12 {
	public static void main(String[] args) {
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	
	int[] Data = new int[10];
	
	// 10���� �� 0~100���� �������� ����
	for(int i = 0;i<Data.length;i++) {
		Data[i] = rand.nextInt(100)+1; // 1~100
		for(int j = 0; j<i;j++) {
			if(Data[j]==Data[j+1]) {
				System.out.println("Ȯ��"+Data[j]+" "+Data[j+1]);
				int tmp = Data[j];
				Data[j] = Data[j+1];
				Data[j+1] = tmp;
			}
		}
	}
	
	// ����
	for(int i = 0; i < Data.length-1;i++) {
		for(int j= 0; j<Data.length-1;j++) {
			if(Data[j] >Data[j+1]) {
				int tmp = Data[j];
				Data[j] = Data[j+1];
				Data[j+1] = tmp;
			}
		}
		
		int min = 1, max = 100;
		int[] value = new int[10];
		
		while(true) {
			System.out.print("���ڸ� �Է����ּ��� ");
			int ans = sc.nextInt();
			
			if(ans>max) { // ���� �� �Ѿ�� ���α׷� ���� ���ǹ�
				System.out.println("������ �ʰ��� ���ڸ� �Է��Ͽ� ���α׷��� ����˴ϴ�.");
				break;
			}
			// �������� ������ �ݺ� 1 55 66 77 //value[i1] = ans;
			for(int i3 = 0; i3<Data.length;i3++) {
				
				if(ans==Data[i3]) {
					value[i3] = Data[i3];
				if(Data[Data.length-1] < ans) {
						max = ans;
						
						}
					else {
						min = ans;
					}
				break;
				}
			}
			}
			//���ݱ��� ���� �� ���
			int Cnt = 0; //���᰹�� ī��Ʈ
			System.out.print("[ ");
			for(int i2 = 0; i2 < value.length;i2++) {
				
				if(value[i2]>0) {
				System.out.print(value[i2]+" ");
				Cnt++;
				}
				else {
					System.out.print("_"+" ");
				}
				
			}
			if(Cnt == 10) {
				break;
			}
			System.out.println("]");
			System.out.println(min+" ~ "+max+"���̿� �ֽ��ϴ�!");
			
			
			
			
			
			
		}
		  
	

	} //main����

}
