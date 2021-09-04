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
		System.out.println("�˻��� �������� �̸��� �Է�");
		String name = sc.next();
		vo.setName(name);
		
		return vo;
		// VO�� Model��Ʈ�� �ƴ�!
		// DAO�� Model��Ʈ!
	}
	
	
	public void showList(ArrayList<MemberVO> datas) {
		if(datas.size()==0) {
			System.out.println("�˻��������!");
			return;
		}
		System.out.println("==�˻� ��� ���==");
		for(MemberVO v: datas) {
			System.out.println(v.getName()+"���� ���̴� "+v.getAge());
		}
	}
}
