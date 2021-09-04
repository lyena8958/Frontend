package day18_0721;

import java.util.ArrayList;

import controller.StuController;
import model.Student;
import view.StuView2;


public class Test7 {
	static ArrayList<Student> dataFromDB(){
		ArrayList<Student> data =new ArrayList();
		data.add(new Student("홍길동",1,100));// 이름 번호 성적
		data.add(new Student("아무무",2,80));
		data.add(new Student("아리",3,90));
		return data;
	}
	public static void main(String[] args) {
		
		// DBMS (Mysql, Oracle)
		// "음악" -> 악보를 연주하는 수업
		// 꼭 피아노일 필요는 없다
		// 단소
		
		// DB연동을 마쳐야한다!
		ArrayList<Student> data = dataFromDB();
		
		// view 인자를 입력하지 않으면 기본인자view1을 갖고온다. 
		//StuController controller = new StuController(data);
		// view 인자입력시 해당인자로 갖고온다.
		StuController controller = new StuController(data,new StuView2());
		StuController controller2 = new StuController(data);
		controller.updateView();
		controller2.updateView();
		
	}//main종료
}
