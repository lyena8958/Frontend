package view;

import java.util.ArrayList;
import java.util.Scanner;

import model_member.MemberVO;

public class View {
	
	Scanner sc;
	
	public View() {
		sc = new Scanner(System.in);
	}
	
	public MemberVO search() {
		MemberVO vo = new MemberVO();
		System.out.println("검색할 데이터의 이름을 입력");
		String name = sc.next();
		vo.setName(name);
		
		return vo;
		// VO가 Model파트는 아님!
		// DAO가 Model파트!
	}
	
	
	public void showList(ArrayList<MemberVO> datas) {
		if(datas.size()==0) {
			System.out.println("검색결과없음!");
			return;
		}
		System.out.println("==검색 결과 목록==");
		for(MemberVO v: datas) {
			System.out.println(v.getName()+"님의 나이는 "+v.getAge());
		}
	}
}
