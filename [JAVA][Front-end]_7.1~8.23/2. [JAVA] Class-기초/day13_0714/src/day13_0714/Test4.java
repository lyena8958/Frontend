package day13_0714;

public class Test4 {

	public static void main(String[] args) {
		/* º°Âï±â
		      ****
		     ****
		    ****
		   ****
		*/
		 
		int n = 5;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1-i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
