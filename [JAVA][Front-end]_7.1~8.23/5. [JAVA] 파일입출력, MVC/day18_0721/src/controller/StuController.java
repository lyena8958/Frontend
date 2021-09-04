package controller;

import java.util.ArrayList;

import model.Student;
import view.StuView;
import view.StuView1;

public class StuController {

	ArrayList<Student> model;
	StuView view;
	
	// �����Ͱ� �־���ؼ� model�� ����´�.
	public StuController(ArrayList<Student> model) {
		this(model,new StuView1());//view �Է¸��� ��ü�� ������ �����ڰ� �ο�
	}
	// view�� ����ü������� �����´�. // imp�� �並 ������������ �Է��� �� �ְ�!!(�������ε� Ȱ��)
	public StuController(ArrayList<Student> model,StuView view) { 
		this.model = model;
		this.view = view;
	}
	public void updateView() {//�䰡 ���� ����Ҽ��ְԿ���
		this.view.printStu(model);
	}
}
