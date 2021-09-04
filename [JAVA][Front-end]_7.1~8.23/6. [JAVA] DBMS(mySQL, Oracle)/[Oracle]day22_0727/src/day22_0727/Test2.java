package day22_0727;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// 예나
class Student{
	Student(int snum, String name, int score1, int score2, int dateCnt){
		this.snum = snum;
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.dateCnt = dateCnt;
		this.scoreAvg = (score1+score2) / 2.0; //평균점수 산출
		this.grade = false;
		this.rank = 1;
		if(this.scoreAvg>=90.0 && this.dateCnt<=1) {
			this.grade= true;
		}
		System.out.println(this.name+"님 등록완료!!");
	}
	int snum; // 학번
	String name; // 이름
	int score1; // 점수1
	int score2; // 점수2
	int dateCnt; // 결석일수
	int rank;
	double scoreAvg;
	boolean grade; 

}
public class Test2 {

	public static void main(String[] args) {

		// 1. 데이터 가져오기
		// 2. 수상여부 출력하기
		//		평균이 90.0점이상, 결석일수 1일 이하 (아리)
		// 3. 등수출력하기(평균점수만 판단, 결석일수는 포함xxx)
		// 홍길동->아리->아무무->티모

		// +) 결과제출하는것까지!

		ArrayList<Student> data = new ArrayList();

		String DName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3308/leedb";
		String user = "root";
		String pw = "8958";
		String sql = "select * from student";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DName); // 드라이버 연결
			conn = DriverManager.getConnection(url,user,pw); // db연동
			stmt = conn.createStatement(); // db접근
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int snum = rs.getInt("snum");
				String name = rs.getString("name");
				int score1 = rs.getInt("score1");
				int score2 = rs.getInt("score2");
				int dateCnt = rs.getInt("dateCnt");
				data.add(new Student(snum, name, score1, score2, dateCnt));
			}		

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally

		// 수상대상자 출력
		System.out.println("=====수상대상자=====");
		for(Student v: data) {
			if(v.grade) {
				System.out.println(v.snum+" "+v.name);
			}
		}
		System.out.println("=================");

		// 등수 계산
		for(int i = 0; i < data.size();i++) {
			for(Student v: data) {
				if(data.get(i).scoreAvg < v.scoreAvg) {
					data.get(i).rank++;
				}
			}
		}

		// 등수 정렬출력
		for(int i = 0; i < data.size(); i++) {
			for(Student stu:data) {
				if(i+1==stu.rank) { // i등수와 같다면 출력
					System.out.println(stu.name+"님,  "+stu.rank+"등");
				}
			}
		}
		
	} //main

}
