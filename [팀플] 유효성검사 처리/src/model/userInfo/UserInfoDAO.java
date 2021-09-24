package model.userInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.DBCP;
import model.userInfo.UserInfoVO;

public class UserInfoDAO {
	
	// 비즈니스 메서드
	private static String sql_SELECT_ALL = "SELECT * FROM userInfo";
	private static String sql_SELECT_ONE = "SELECT * FROM userInfo WHERE id=? AND pw=?";
	private static String sql_INSERT = "INSERT INTO userInfo VALUES(?, ?, ?)";
	private static String sql_DELETE = "DELETE FROM userInfo WHERE id=?";
	private static String sql_UPDATE = "UPDATE userInfo SET name=?, pw=? WHERE id=?";
	
	// 사용자 정의 함수 (아이디/비밀번호 찾기)
	private static String sql_FindID = "SELECT * FROM userInfo WHERE pw=? AND name=?";
	private static String sql_FindPW = "SELECT * FROM userInfo WHERE id=?";
	
	// SELECT ALL -> 전체 DB정보 추출
	public ArrayList<UserInfoVO> SelectAll(){
		Connection conn = DBCP.connect();
		ArrayList<UserInfoVO> datas = new ArrayList();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				UserInfoVO vo = new UserInfoVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("UserDAO SelectAll()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}

	// SELECT ONE -> 로그인 
	public UserInfoVO SelectOne(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		UserInfoVO data=null;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new UserInfoVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
	
	// INSERT -> 회원가입
	public boolean InsertDB(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("UserDAO InsertDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// DELETE -> 회원 탈퇴
	public boolean DeleteDB(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_DELETE);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("UserDAO DeleteDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}

	// UPDATE -> Name, Pw 변경
	public boolean UpdateDB(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("UserDAO UpdateDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// 아이디 찾기
	public UserInfoVO FindID(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		UserInfoVO data=null;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_FindID);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new UserInfoVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserDAO FindID()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
	
	// 비밀번호 찾기
	public UserInfoVO FindPW(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		UserInfoVO data=null;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_FindPW);
			pstmt.setString(1, vo.getId());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new UserInfoVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserDAO FindPW()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
}
