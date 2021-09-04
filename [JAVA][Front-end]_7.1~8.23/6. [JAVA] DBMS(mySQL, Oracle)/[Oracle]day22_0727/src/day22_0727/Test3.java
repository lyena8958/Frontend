package day22_0727;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test3 {

	public static void main(String[] args) {
		// 오라클 연결!
		// jar로 시작하는 드라이버는 mysql와 비슷하기 때문에 서로 엮이지않도록 하나를 삭제~!
		
		//String DName = "com.mysql.cj.jdbc.Driver";
		String DName = "oracle.jdbc.driver.OracleDriver";
		
		//String url = "jdbc:mysql://localhost:3308/leedb";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		
		//String user = "root";
	    String user="kim";
	    
	    //String pw = "8958";
	    String password="8958";
		
		String sql = "select * from student";

		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(DName); // 드라이버 연결
			conn = DriverManager.getConnection(url,user,password); // db연동
			stmt = conn.createStatement(); // db접근
			
			ResultSet rs = stmt.executeQuery("select * from test");
			while(rs.next()) {
				System.out.println(rs.getInt("num"));
			}
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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

	}

}
