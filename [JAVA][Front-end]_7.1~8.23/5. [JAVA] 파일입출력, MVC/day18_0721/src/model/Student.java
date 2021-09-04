package model;

public class Student{
	String name;
	int num;
	int score;
	public Student(String name, int num, int score){
		this.name = name;
		this.num = num;
		this.score = score;
	}
	public String toString() {//투스트링 오버라이딩
		return num+"번학생 "+name+"은 "+score+"점입니다.";
	}
	
} // 학생: 데이터 -> 학생부: 데이터집합 = DBMS(로 연결)

