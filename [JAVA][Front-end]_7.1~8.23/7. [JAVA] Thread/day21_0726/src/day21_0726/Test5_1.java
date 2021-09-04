package day21_0726;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// Test5
//class Student{ // 테이블을 받을 객체
//	int snum;
//	String sname;
//	int score;
//	int srank;
//	String grade;
//	Student(int snum, String sname, int score, int srank, String grade){
//		this.snum = snum;
//		this.sname = sname;
//		this.score = score;
//		this.srank = srank;
//		this.grade = grade;
//		System.out.println(sname+"학생 등록완료!");
//	}
//	@Override
//	public String toString() {
//		return "Student [snum=" + snum + ", sname=" + sname + ", score=" + score + ", srank=" + srank + ", grade="
//				+ grade + "]";
//	}
//	
//	
//}
public class Test5_1 {

	public static void main(String[] args) {
		// db -> 자바 데이터이동
		String DName="com.mysql.cj.jdbc.Driver"; // 업데이트 문구가 나와서 cj붙임 원래는 : com.mysql.jdbc.Driver 사용 

		String url = "jdbc:mysql://localhost:3308/leedb"; // localhost== ex) 10.219.130.80
		String user="root";
		String password = "8958";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from student";
		
		ArrayList <Student> data =new ArrayList();
		
		try {
			// 드라이버 연결
			Class.forName(DName); // 해당 명령어는 예외처리 필요
			
			// db연결
			conn = DriverManager.getConnection(url, user, password); // Connection = conn 이었으나 파이널리 실행을위해 위에서 생성
			// 예외미루기가 있는 기능이다.
			
			//컬렉션의 일종
			stmt = conn.createStatement(); 
			
			rs = stmt.executeQuery(sql);
			
			// DB->자바로 데이터 가져오기!
			while(rs.next()) {
				int snum = rs.getInt("snum");
				String sname = rs.getString("sname");
				int score = rs.getInt("score");
				int srank = rs.getInt("srank");
				String grade = rs.getString("grade");
				data.add(new Student(snum, sname,score,srank,grade));
//				System.out.println(rs.getString("sname")); // rs 주소같은게 뜸
//				System.out.println(rs.getInt("score"));
			}
			System.out.println();
			System.out.println("==학생부==");
			
			// 추가★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
			// 자바에있는 데이터 변경
			for(int i = 0; i < data.size();i++) {
				data.get(i).sname = "학생"+(i+1); // 이름을 모두 바꿀거야 
				stmt.executeUpdate("update student set sname='"+data.get(i).sname+"' where snum="+data.get(i).snum); // executeQuery는 rs이란 차이점이있다.
				// 문자(이름)를 넣어야하니 db에서 작성한 것 처럼 작은 따옴표를 넣어줘야한다. 
			}
			for(Student stu:data) {
				System.out.println(stu);
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {//conn 오류미루기
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("확인");
		
	}

}
