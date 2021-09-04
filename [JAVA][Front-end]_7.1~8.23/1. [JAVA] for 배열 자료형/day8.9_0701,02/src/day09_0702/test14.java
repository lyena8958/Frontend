package day09_0702;

public class test14 {

	static void swap(int a,int b) {
		int tmp= a;
		a=b;
		b=tmp;
	}
	
	static void func(int[][] data) { // int[] data
		for(int i = 0; i < data.length;i++) {
			data[i][0] = 100;
			
		}
	}
	
	
	
	public static void main(String[] args) {
		int a= 10, b=20;
		swap(a,b);
		System.out.println("a="+a+" b="+b); // 10 20

		//int[] arr=new int[3];
		int[][] arr=new int[2][3];
		func(arr);
		for(int[]v:arr) { //int v:arr
			System.out.println(v); // 100 100 100
		}
	}

}
