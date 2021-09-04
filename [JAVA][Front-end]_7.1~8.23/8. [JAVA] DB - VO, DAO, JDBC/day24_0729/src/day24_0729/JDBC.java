package day24_0729;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//MODEL
//���ø�
//����̹� �ε�, ����̹� ����
public class JDBC {

	// 1. Connection ��ü�� ����
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
	// 2. ������ Connection ��ü�� close
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
