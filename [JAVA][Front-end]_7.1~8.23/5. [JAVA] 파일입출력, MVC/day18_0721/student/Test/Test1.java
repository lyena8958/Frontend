package Test;

import stuController.Controller;

public class Test1 {

	public static void main(String[] args) {
		/*학생부프로그램의 일부를 MVC로 구현
		View는 콘솔을 사용

		학생
		 -국어 영어 수학
		 -100~80 A / 79~50 B / C
		 -학점


		==학생의 학점을 출력하는 프로그램==
		(정지버튼을 누를때까지 계속)
		국어: 100
		수학: 80
		영어: 90
		결과 [A]*/
		Controller con = new Controller();
		con.Crrstart();
		
		
	}

}

