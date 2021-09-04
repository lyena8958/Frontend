package day09_0702;

public class test7 {

	public static void main(String[] args) {
int[][] arr = new int [2][3];
for(int i = 0; i < arr.length;i++) {
	for(int j =0;j<arr[i].length;j++) {
		arr[i][j]=j+1;
	}
}

// arr == &arr[0]
for(int[] v : arr) {
	for(int vv : v) {
	System.out.println(vv);
}
	System.out.println("=====");
}
	}

}
