package controller;

import java.util.ArrayList;

import model_member.MemberDAO;
import model_member.MemberVO;
import view.View;

public class Test1 {
	
	public static void main(String[] args) {
		
		
		View view = new View(); // �� ��
		
		MemberVO vo = new MemberVO();
		vo = view.search(); //�˻��ϰڽ��ϴ�. : ������� ��û
		
		MemberDAO dao = new MemberDAO();  // �� ��
		ArrayList<MemberVO> datas = dao.selectAll(vo);
		
		view.showList(datas);
		
		
		//��� �����, DB�� ��
		
	}
}
