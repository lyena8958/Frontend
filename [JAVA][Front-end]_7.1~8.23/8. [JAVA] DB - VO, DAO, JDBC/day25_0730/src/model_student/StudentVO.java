package model_student;

public class StudentVO {
	private int num; // PK
	private String name;
	private int score1;
	private int score2;
	private char grade; // 로직적으로 만든 부분이기때문에 sql엔 없다.
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return name+" 학생의 등급 ["+grade+"]";
	}
	
}
