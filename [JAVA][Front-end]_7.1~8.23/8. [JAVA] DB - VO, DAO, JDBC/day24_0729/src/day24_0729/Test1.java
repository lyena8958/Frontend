package day24_0729;

import java.util.ArrayList;

public class Test1 {
	public static void main(String[] args) {
		
		// MODEL
		
		// db ��üȭ
		TestDAO dao = new TestDAO();
		
		TestVO data = new TestVO();
		
		// insert ����
		data.setA(123);
		data.setB("����");
		dao.insertTest(data); 
		
		//select ����
		data = dao.getTest(11); // null
		if(data!=null) { 
			System.out.println(data);
		}
		else { // pk 11���� ���ٸ�
			System.out.println("�˻��������!");
		}
		
		//select ��ü
		ArrayList<TestVO> datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}
		
		
		System.out.println();
		
		
		// update �����ver
		//   ���������� ����?? 1) �α���(getTest) -> 2) 
		// vo��ü ����Ȯ�� > �ٲٰ���� ���� �Է� -> ��ü�� �ݿ� -> db�ݿ�
		data = dao.getTest(123); // null
		if(data!=null) {
			// update�� ������ �� �ִ�!
			System.out.println(data);
			System.out.println("b�� ���Է��ϼ���.");
			String b= "���";
			data.setB(b);
			dao.updateTest(data); 
			// ����ÿ� ���������� �ϱ����ؼ��� ������ �α���/���� ����!
		}
		else {
			System.out.println("�˻��������!");
			// update�Ұ���!
		}
		System.out.println("����� update");
		datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}
		System.out.println();
		
		
		
		// delete �����ver
		dao.deleteTest(123);
		datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}
		System.out.println();
		
		
		
		/*
		//delete ����ver
		dao.daleteTest(123);// a= 123������
		
		System.out.println("==delete==");
		datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}
		
		//update ����ver
		dao.updateTest(datas.get(1), "�Ƹ�");
		
		System.out.println("\n==update==");
		datas = dao.getTestList();
		for(TestVO vo: datas) {
			System.out.println(vo);
		}*/
		
		
		
	}
}
