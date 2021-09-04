package day17_0720;

import java.util.InputMismatchException;
import java.util.Scanner;
//class Exception{//인셉션 클래스가 사실 이렇게 되어있지않을까?? -> 추측
//	private String message;
//	public String getMessage() {
//		return message;
//	}
//	Exception(){
//		this("");
//	}
//	Exception(String message){
//		this.message =message;
//	}
//}
class Actexception extends Exception{
	Actexception(String msg){
		super(msg);
		
	}
}
public class Test8 {

	public static void main(String[] args) {
		// 내가 만드는 예외!
		
		//int a=10;
		// Car car=new Car(a);  --> car(int a) 생성자일때 저렇게 입력이 가능하듯이
		
		Scanner sc = new Scanner(System.in);
									// ↓생성자가 없어도되고없어도되네? -> 오버로딩된거네!
		//Exception excep = new Exception("1~3만 입력가능!"); //오버로딩)인셉션 객체생성
		//아래 예외처리(오류)를 발생시키기위해 객체화한 것이다. 
		Actexception excep = new Actexception("1~3만 입력가능!");
		//System.out.println(excep.getMessage());
		
		int act;
		while(true) {
			System.out.println("1. 2. 3.");
			try {
				act = sc.nextInt();
				System.out.println(10/act);
				// 예외가 아닌것을 예외로처리하는행위(if로도 가능하다 예외로도 처리할수있다)
				// throw
				if(act<1||3<act) {//캐치로이동
					throw excep; //예외일부러발생!
				}
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("자료형이 올바르지않습니다!");
				continue;
			}catch(Actexception e) {// 정의한 클래스를 입력하고싶을때
				System.out.println(e.getMessage());
				System.out.println("다시입력해보세요!~~");
				continue;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());// 생성자입력부분
				continue;
			}
			
		
			 
			if(act==1) {
				
			}else if(act==2) {
				
			}
			else {//3번을 누르면 브레이크
				break;
			}
		}
		

	}

}
