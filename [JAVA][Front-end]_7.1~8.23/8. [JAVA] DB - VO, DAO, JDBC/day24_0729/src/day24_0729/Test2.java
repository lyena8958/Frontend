package day24_0729;

import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) {
		// View 
		// ȸ������â(Form)
		// id, pw, name, �ּ�, phone, ...
		// DB: not null Model�����ڴ� �� ����� View �����ڿ��� �˷���!
		//		> �α����� �� ���̵�/pw �Է��� ���� �� ������ �ߴ°�
		// id, pw, name [�ش� �׸��� ����ֽ��ϴ�!] -> view���

		/*
		System.out.println("ȸ�������� �����մϴ�.");
		// [ȸ������ â] - ������Է�
		int a = 3; // nvl �� �Ǿ������� ���ص���
		String b ="ȫ�浿";
		int c = 300;
		
		//�ᱹ ȸ�����Զ� ��üȭ�� �Ǿ� �̰��� DAO���� CRUD�ϰ� �Ǵ� ���̴�.
		
		// view�� �����Է��ϸ� con���� �ް� model�� ���� �Ѵ�
		
		// �䰡 a, b, c �� �ѱ�� 
		// Controller
		TestVO vo = new TestVO();
		vo.setA(a);
		vo.setB(b);
		vo.setC(c);
		
		// Model(�ٵ� Controller�� �Ʒ�ó�� ��κ� ������ �Ϸ�����ش�.)
		TestDAO dao = new TestDAO();
		dao.insertTest(vo); // ȸ������ �Ϸ�
	*/
		
		System.out.println("�˻��� �����մϴ�.");
		TestVO vo1 = new TestVO();
		vo1.setB("Ƽ");
		TestDAO dao1 =new TestDAO();
		ArrayList<TestVO> datas = dao1.getTestList(vo1);
		System.out.println(datas);
	}

}
