package controller;

import java.util.ArrayList;

import model_member.MemberDAO;
import model_member.MemberVO;
import view.View;

public class Test1 {
	
	public static void main(String[] args) {
		
		
		View view = new View(); // ★ 뷰
		
		MemberVO vo = new MemberVO();
		vo = view.search(); //검색하겠습니다. : 사용자의 요청
		
		MemberDAO dao = new MemberDAO();  // ★ 모델
		ArrayList<MemberVO> datas = dao.selectAll(vo);
		
		view.showList(datas);
		
		
		//뷰는 사용자, DB는 모델
		
	}
}
