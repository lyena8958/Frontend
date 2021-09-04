package controller;

import java.util.ArrayList;

import model.Student;
import view.StuView;
import view.StuView1;

public class StuController {

	ArrayList<Student> model;
	StuView view;
	
	// 데이터가 있어야해서 model을 갖고온다.
	public StuController(ArrayList<Student> model) {
		this(model,new StuView1());//view 입력못한 객체가 있으면 개발자가 부여
	}
	// view를 갖고올수있으면 가져온다. // imp된 뷰를 여러종류에도 입력할 수 있게!!(동적바인딩 활용)
	public StuController(ArrayList<Student> model,StuView view) { 
		this.model = model;
		this.view = view;
	}
	public void updateView() {//뷰가 모델을 사용할수있게연결
		this.view.printStu(model);
	}
}
