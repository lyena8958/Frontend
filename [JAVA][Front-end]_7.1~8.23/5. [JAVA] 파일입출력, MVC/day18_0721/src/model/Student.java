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
	public String toString() {//����Ʈ�� �������̵�
		return num+"���л� "+name+"�� "+score+"���Դϴ�.";
	}
	
} // �л�: ������ -> �л���: ���������� = DBMS(�� ����)

