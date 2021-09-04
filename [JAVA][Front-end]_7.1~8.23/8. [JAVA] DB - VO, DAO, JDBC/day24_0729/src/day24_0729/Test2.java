package day24_0729;

import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) {
		// View 
		// 회원가입창(Form)
		// id, pw, name, 주소, phone, ...
		// DB: not null Model관리자는 이 사실을 View 관리자에게 알려줌!
		//		> 로그인할 때 아이디/pw 입력을 안할 때 오류가 뜨는것
		// id, pw, name [해당 항목이 비어있습니다!] -> view담당

		/*
		System.out.println("회원가입을 시작합니다.");
		// [회원가입 창] - 사용자입력
		int a = 3; // nvl 가 되어있으면 안해도됨
		String b ="홍길동";
		int c = 300;
		
		//결국 회원가입때 객체화가 되어 이것을 DAO에서 CRUD하게 되는 것이다.
		
		// view가 뭔갈입력하면 con에서 받고 model로 연결 한다
		
		// 뷰가 a, b, c 로 넘기면 
		// Controller
		TestVO vo = new TestVO();
		vo.setA(a);
		vo.setB(b);
		vo.setC(c);
		
		// Model(근데 Controller가 아래처럼 대부분 가입을 완료시켜준다.)
		TestDAO dao = new TestDAO();
		dao.insertTest(vo); // 회원가입 완료
	*/
		
		System.out.println("검색을 시작합니다.");
		TestVO vo1 = new TestVO();
		vo1.setB("티");
		TestDAO dao1 =new TestDAO();
		ArrayList<TestVO> datas = dao1.getTestList(vo1);
		System.out.println(datas);
	}

}
