package view;

import java.util.ArrayList;
import java.util.Iterator;

import model.Student;

public class StuView1 implements StuView {
	public void printStu(ArrayList<Student> data) {
		
		Iterator itr = data.iterator();
		System.out.println("==�л� ���==");
		while(itr.hasNext()) {
			System.out.println(itr.next());	
		}
		
	}
}
