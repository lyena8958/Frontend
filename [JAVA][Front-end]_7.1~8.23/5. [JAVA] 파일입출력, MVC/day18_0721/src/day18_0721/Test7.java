package day18_0721;

import java.util.ArrayList;

import controller.StuController;
import model.Student;
import view.StuView2;


public class Test7 {
	static ArrayList<Student> dataFromDB(){
		ArrayList<Student> data =new ArrayList();
		data.add(new Student("ȫ�浿",1,100));// �̸� ��ȣ ����
		data.add(new Student("�ƹ���",2,80));
		data.add(new Student("�Ƹ�",3,90));
		return data;
	}
	public static void main(String[] args) {
		
		// DBMS (Mysql, Oracle)
		// "����" -> �Ǻ��� �����ϴ� ����
		// �� �ǾƳ��� �ʿ�� ����
		// �ܼ�
		
		// DB������ ���ľ��Ѵ�!
		ArrayList<Student> data = dataFromDB();
		
		// view ���ڸ� �Է����� ������ �⺻����view1�� ����´�. 
		//StuController controller = new StuController(data);
		// view �����Է½� �ش����ڷ� ����´�.
		StuController controller = new StuController(data,new StuView2());
		StuController controller2 = new StuController(data);
		controller.updateView();
		controller2.updateView();
		
	}//main����
}
