package day24_0729;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//MODEL
//템플릿
//드라이버 로드, 드라이버 연동
public class JDBC {

	// 1. Connection 객체를 생성
	public static Connection getConnection() {

		Connection conn = null;

		String DName = "oracle.jdbc.driver.OracleDriver";

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kim";
		String pw = "8958";

		try {
			Class.forName(DName);
			conn=DriverManager.getConnection(url, user, pw);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return conn;

	}
	// 2. 생성된 Connection 객체를 close
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
