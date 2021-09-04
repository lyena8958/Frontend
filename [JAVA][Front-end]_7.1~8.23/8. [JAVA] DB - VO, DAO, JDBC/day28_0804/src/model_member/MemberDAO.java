package model_member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;

public class MemberDAO {

	//select만

	//검색 SELECT
	// 자바코드랑 헷갈리는 점을 방지하기 위해 SQL문은 대문자로 사용한다.
	static String sql_SELECT_ALL = "SELECT * FROM MEMBER WHERE MNAME LIKE '%'|| ? || '%'";
	// 높은 응집도의 코딩

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public ArrayList<MemberVO> selectAll(MemberVO vo) {

		conn= JDBC.getConnection();
		ArrayList<MemberVO> datas = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setString(1, vo.getName()); // 이름으로 검색
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				MemberVO data = new MemberVO();
				data.setAge(rs.getInt("age"));
				data.setMid(rs.getInt("mid"));
				data.setName(rs.getString("name"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}

		return datas;
	}
}
