package day22_0727;
// 강사님
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Student2{

	private int num; // 학번
	private String name; // 이름
	private double avg;
	private int rank;
	private boolean grade;
	Student2(int num, String name, int score1, int score2, int dateCnt){
		this.num = num;
		this.name = name;
		this.avg = (score1+score2)/2.0;
		this.rank = 1; // 우선 1등처리 후, 다른 데이터오ㅓ 비교
		this.grade = false;
		if(this.avg >= 90.0 && dateCnt<=1) {
			this.grade = true;
		}
		System.out.println(name+"학생 등록완료!");
	}
	// 사용할 멤버변수에만 게터셋터 생성
	public boolean isGrade() {// getter (boolean은 다르다)
		return grade;
	}
	public int getRank() {
		return rank;
	}
	public void setRank() {
		this.rank++;
	}
	public double getAvg() {
		return avg;
	}
	@Override
	public String toString() {
		return num + "번학생 " + name + " 등수는" + rank + " [" + grade + "]";
	}
}
public class Test2_1 {

	public static void main(String[] args) {

		// 1. 데이터 가져오기
		// 2. 수상여부 출력하기
		//		평균이 90.0점이상, 결석일수 1일 이하 (아리)
		// 3. 등수출력하기(평균점수만 판단, 결석일수는 포함xxx)
		// 홍길동->아리->아무무->티모

		// +) 결과제출하는것까지!

		
		ArrayList<Student2> data = new ArrayList();

		String DName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3308/leedb";
		String user = "root";
		String pw = "8958";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DName); // 드라이버 연결
			conn = DriverManager.getConnection(url,user,pw); // db연동
			stmt = conn.createStatement(); // db접근

			//String sql = "select * from student";
			String sql = "select * from student order by dateCnt asc";
			rs = stmt.executeQuery(sql);	
			while(rs.next()) {
				int num = rs.getInt("snum"); 
				String name = rs.getString("name"); 
				int score1 = rs.getInt("score1");
				int score2 = rs.getInt("score2");
				int dateCnt= rs.getInt("dateCnt");

				data.add(new Student2(num,name,score1,score2,dateCnt));
			}

			rs.close();

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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		System.out.println();
		System.out.println("수상여부");
		for(Student2 stu:data) {
			if(stu.isGrade()) {
				System.out.println(stu);
			}
		}

		// 등수작업
		for(int i = 0; i < data.size();i++) {
			for(Student2 stu:data) {
				if(data.get(i).getAvg()< stu.getAvg()) {
					data.get(i).setRank(); //rank++
				}
			}
		}
		
		// 등수정렬 1.java에서
		System.out.println("점수확인");
		for(int i=1;i<=data.size();i++) {
			for(Student2 stu:data) {
				if(i==stu.getRank()) {
					System.out.println(stu);
					break;
				}

			}
		}
		// 등수정렬 2. db에서 등수 칼럼추가 - select order by asc;


	} //main

}
