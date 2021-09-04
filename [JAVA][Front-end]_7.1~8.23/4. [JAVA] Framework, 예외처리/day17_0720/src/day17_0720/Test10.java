package day17_0720;

class MyException extends Exception{
	MyException(){
		super("내가만든예외클래스");
	}
}

public class Test10 {
	//throw  / throws
static void func1() throws Exception { //Exception =>어떤 오류가 발생할지모르므로 인셉션불러옴
	int a=10, b=0;
	//try-catch 썼어야 하나->메인에서하고싶어!
	System.out.println(a/b); //오류발생지점
	System.out.println("func1()호출됨");//오류를발생하면 아래 명령문으 내려지지않는다.
}
static void func2() throws Exception {
	Exception excep =new Exception("내가만든예외객체");
	throw excep;
}
static void func3() throws MyException {//아니 난 여기다가 하기싫은데?(2) 메인에 떠넘기기
	MyException my = new MyException();
	throw my;//여기서 try-catch를 해야하나(1)
}
	public static void main(String[] args) {
		
		// 예외처리 미루기 : throws
		
		 try {
			//func1();
			 //func2();
			 func3();
		}
		 catch(MyException e) {
			System.out.println("처리완료");
		}
		 catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("예외처리완료");
			System.out.println(e.getMessage());
		}

		// 예외: 선처리를 해야하는 예외
		//func1();반드시 처리를 하지않아도 괜찮은 예외 - ArithmeticException : 해서 try-catch를 강제하고있지않음

	}//main종료

}
