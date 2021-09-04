package model_member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;

public class MemberDAO {

	//select��

	//�˻� SELECT
	// �ڹ��ڵ�� �򰥸��� ���� �����ϱ� ���� SQL���� �빮�ڷ� ����Ѵ�.
	static String sql_SELECT_ALL = "SELECT * FROM MEMBER WHERE MNAME LIKE '%'|| ? || '%'";
	// ���� �������� �ڵ�

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public ArrayList<MemberVO> selectAll(MemberVO vo) {

		conn= JDBC.getConnection();
		ArrayList<MemberVO> datas = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setString(1, vo.getName()); // �̸����� �˻�
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
