package day24_0729;

import java.util.ArrayList;

public class Test1 {
	public static void main(String[] args) {
		
		// MODEL
		
		// db 객체화
		TestDAO dao = new TestDAO();
		
		TestVO data = new TestVO();
		
		// insert 삽입
		data.setA(123);
		data.setB("가렌");
		dao.insertTest(data); 
		
		//select 단일
		data = dao.getTest(11); // null
		if(data!=null) { 
			System.out.println(data);
		}
		else { // pk 11번이 없다면
			System.out.println("검색결과없음!");
		}
		
		//select 전체
		ArrayList<TestVO> datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}
		
		
		System.out.println();
		
		
		// update 강사님ver
		//   마이페이지 접속?? 1) 로그인(getTest) -> 2) 
		// vo객체 정보확인 > 바꾸고싶은 것을 입력 -> 객체에 반영 -> db반영
		data = dao.getTest(123); // null
		if(data!=null) {
			// update를 진행할 수 있다!
			System.out.println(data);
			System.out.println("b를 재입력하세요.");
			String b= "사과";
			data.setB(b);
			dao.updateTest(data); 
			// 설계시에 정보변경을 하기위해서는 무조건 로그인/인증 먼저!
		}
		else {
			System.out.println("검색결과없음!");
			// update불가능!
		}
		System.out.println("강사님 update");
		datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}
		System.out.println();
		
		
		
		// delete 강사님ver
		dao.deleteTest(123);
		datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}
		System.out.println();
		
		
		
		/*
		//delete 예나ver
		dao.daleteTest(123);// a= 123번삭제
		
		System.out.println("==delete==");
		datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}
		
		//update 예나ver
		dao.updateTest(datas.get(1), "아릿");
		
		System.out.println("\n==update==");
		datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}*/
		
		
		
	}
}
