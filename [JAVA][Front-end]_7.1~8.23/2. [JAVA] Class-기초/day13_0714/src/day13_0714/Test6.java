package day13_0714;

import java.util.Random;
import java.util.Scanner;

public class Test6 {
static int NumCheck(int a, int num) {
	Scanner sc = new Scanner(System.in);
	while(true) {
		if(num<a) {
			System.out.println("¼ýÀÚ¸¦ Àß¸øÀÔ·ÂÇÏ¼Ì½À´Ï´Ù. "+a+"ÀÌ»óÀ¸·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			num = sc.nextInt();
			continue;
		}
		break;
	}
	return num;
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 Å¾ÀÇ °³¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä.
		5
 		´Ü, Å¾ÀÇ °³¼ö´Â 0ÀÌÇÏxxx
		5°³ÀÇ Å¾ÀÇ ³ôÀÌ¸¦ ÀÔ·ÂÇÏ¼¼¿ä. 6 9 5 7 4 [ 0 0 2 2 4]
		1: 6
		2: 9
		3: 5
		4: 7
		5: 4
 		´Ü, ³ôÀÌ´Â 0ÀÌÇÏxxx
		=> [ 0 0 2 2 4 ] */
		
		// °­»ç´ÔÀÇ ´ä
		System.out.println("Å¾ÀÇ °³¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
		int n = sc.nextInt();
		
		int[] data = new int[n];
		Random rand = new Random();
		
		for(int i = 0; i < data.length;i++) {
			data[i] = rand.nextInt(9)+1; // 1~9
		}
		
		for(int v:data) {
			System.out.print(v+" ");
		}
		System.out.println();
		/* ¹è¿­
		int[] res = new int[n];

		for (int a = data.length-1; a >= 0; a--) {
			// data[4]¸¦ ±âÁØÀ¸·Î ÁøÇà!
			for (int i = a-1; i >= 0; i--) {
				if (data[a] <= data[i]) { // ³ªº¸´Ù Å©°Å³ª ¯˜Àº Å¾À» ¸¸³ª¸é,
					res[a] = i + 1;
					break;
				}
			}
		}
		
		for(int v:res) {
			System.out.print(v+" ");
		}*/
		
		// º¯¼ö
		for (int a = 0; a <data.length; a++) { // À§¿¡¼­ ´ë·Î Á¶°ÇÀ» ±×´ë·Î ÇÏ¸é °ªÀÌ ¹Ý´ë·Î Ãâ·ÂµÈ´Ù.
			int pos= 0; //Æ÷Áö¼Ç
			for (int i = a-1; i >= 0; i--) {
				if (data[a] <= data[i]) { // ³ªº¸´Ù Å©°Å³ª ¯˜Àº Å¾À» ¸¸³ª¸é,
					pos = i + 1;
					break;
				}
			}
			System.out.print(pos+" ");
		}
		
		/* ¿¹³ª
		System.out.println("Å¾ÀÇ °³¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
		int num = NumCheck(1,sc.nextInt());
		
		int[] NumArr = new int[num];
		
		for(int i = 0; i < NumArr.length;i++) {
			System.out.println((i+1)+"¹øÂ° Å¾ÀÇ ³ôÀÌ¸¦ ÀÔ·ÂÇÏ¼¼¿ä");
			NumArr[i] = NumCheck(1,sc.nextInt());
		}
		
		int[] NumIndex = new int[num]; // Àüº¿´ë ºÎµúÈ÷´Â ¹øÈ£¸¦ ÀúÀå
		
		for(int i = num-1; i > 0; i--) {
			for(int j = i-1; j >= 0; j--) {
			if(NumArr[i] <NumArr[j]) {
				NumIndex[i] = j+1;
				break;
			}
		}
	}
		System.out.print("[ ");
		for(int v: NumIndex) {
			System.out.print(v+" ");
		}
		System.out.println("]");
		*/

}//mainÁ¾·á
}