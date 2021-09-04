package day16_0719_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		// 정수를 10번 입력
		// 짝수만 al에 저장
		// +) 오름차순으로 저장
		
		//강사님
		Scanner sc = new Scanner(System.in);
		ArrayList data =new ArrayList();
		
		for(int i = 0; i < 3; i++) {
			System.out.println("정수"+(i+1)+"입력");
			int num = sc.nextInt();
			if(num%2==0) {
				boolean flag = true;
				// 컬렉션에서의 요소 교환xxx -> 처음부터 add시 올바르게!!
				for(int j = 0; j < data.size(); j++) {
					if(num < (Integer)data.get(j)) {//캐스팅(형변환)
						data.add(j, num);
						flag = false;
						break;
					}
				}
				if(flag) { // for-if문에서 모두가 false인 경우(가장큰값일때)
					data.add(num);
				}
				
			}
			System.out.println(data);
		}
		
		// 컬렉션은 종류가 많다!
		// AL : 변경이 잘 되지않으며, 삭제가 이루어지지않는 데이터저장에 유리
		
		
		// 예나 // 오름차순 정렬 안됨 ㅠㅠ
		ArrayList al = new ArrayList(10);
		int i = 0;
		while(i < 10) {
			System.out.print((i+1)+"번째 짝수인 정수를 입력하세요: ");
			int num = new Random().nextInt(50)+1;
			if(num%2==0) {
				System.out.println(num+" 저장완료!");
				al.add(num);
				i++;
				continue;
			}
			System.out.println("홀수 입력으로 저장이 안됩니다.");
		}
		System.out.println(al);		
//		// 오름차순 정렬
//		for(int a = 0; a< al.size()-1;a++) {
//			if((int)al.get(a)> (int)al.get(a+1)) {
//				al.add(a, al.get(a+1));
//			}
//			
//		}
		
		
		

	}// main종료

}
