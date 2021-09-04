package day24_0729;
// DAO : Data Access Object , DB에 접근하는 객체
// 즉 VO와 연결되는 클래스 ↓

//MODEL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// jdbc로부터 열린 
public class TestDAO {
	
	static String sql_SELECT_ONE = "select * from test where a=?";
	static String sql_SELECT_ALL = "select * from test where b like '%?%' order by a asc";
	static String sql_INSERT = "insert into test values (?, ?)";
	static String sql_UPDATE = 	"update test set b=?, c=? where a=?";
	static String sql_DELETE = 	"delete from test where a=?";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	// CRUD 항상 제공이 되어야한다! --> 특별한 경우가 아니라면 (id/pw등)
	// insert select(단일객체),select(목록) update delete


	// select(단일)객체를 받는다 --> object..?
	//  그러나 --> 객체?? VO에서 테이블의 "객체"를 생성하니 리턴타입을 TestVo로 해준다!!
	
	// select(단일)
	// 클래스 명은 select 이나, 해당 기능은 값을 가져오기때문에 getTest로 클래스명지정한다.
	
	//보통은 인자를 vo로 맞춰주는게 규칙이다!☆
	public TestVO getTest(TestVO vo) { // int a : 사용자가 select할 넘버를 지정
		//String sql = "select * from test where a=?"; // ? : 무조건 pk로 넣어줘야한다.
		conn=JDBC.getConnection(); // jdbc 메서드에서 드라이버연결 및 db연동한다.		
		
		//스코프 문제가 있으니 미리 만들어준다.
		//TestVO vo = new TestVO(); //TestVo 클래스의 객체생성
		TestVO data= null; //만약 검색결과가 없다면 null이 리턴됨! To.view
		//변수명 data, 여러개 데이터면 datas
		
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE); //db접근
			pstmt.setInt(1, vo.getA());
			ResultSet rs =  pstmt.executeQuery();
			
			if(rs.next()) {// 내가 찾은 데이터가 존재할 때만 메모리를 넘겨준다. 
				data = new TestVO(); // 메모리가없으면 new를 못만난다.
				data.setA(rs.getInt("a"));
				data.setB(rs.getString("b"));
				vo.setC(rs.getInt("c"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);// DB접근 객체닫음
		}
		System.out.println("getTest() 수행완료"); // 나에게 알려주는 확인절차
		return data;
	}
	
	// select 목록
	// 네이버 검색창 '아리'라고 검색하면 연관 검색어가 뜨듯이 사용된게 요것!!
	// 검색하고싶은 내용을 객체화 하는것 == vo
	public ArrayList<TestVO> getTestList(TestVO vo){//int, str 등등 받을 수 있으니 전체객체로
		//	String sql = "select * from test order by a asc"; // 전체목록(a칼럼을 오름차순!!)  // desc
	//String sql = "select * from test where b like '%?%' order by a asc";
		
		conn=JDBC.getConnection(); // db연결
		ArrayList<TestVO> datas = new ArrayList(); // 공간이 있어야하므로 객체화해줌
		
		try {//-> 수정해야함
	         pstmt=conn.prepareStatement(sql_SELECT_ALL);
	         pstmt.setString(1, vo.getB());  // '%티%'// ?에 10을 넣겠습니다. (?자릿수: 1)
	         ResultSet rs=pstmt.executeQuery();
	         while(rs.next()) {
	            TestVO data=new TestVO(); // 기본생성자->멤버변수에 값xxx
	            data.setA(rs.getInt("a"));
	            data.setB(rs.getString("b"));
	            data.setC(rs.getInt("c"));
	            datas.add(data);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("getTestList() 수행완료"); // 나에게 알려주는 확인절차
		return datas;
	}
	
	// insert
	public void insertTest(TestVO vo){ // int a, String b
		//String sql = "insert into test values (?, ? ,?)";
		conn = JDBC.getConnection();
		try {
	         pstmt=conn.prepareStatement(sql_INSERT); //sql
	         pstmt.setInt(1, vo.getA());
	         pstmt.setString(2, vo.getB());
	         pstmt.setInt(3, vo.getC());
	         pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("insertTest() 수행완료"); // 나에게 알려주는 확인절차
	}
	
	// update 예나
	public void updateTest(TestVO vo, String b){
		
		String sql = "update test set b = ? where a = ?";
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, b); // 변경할 b
			pstmt.setInt(2, vo.getA()); // 대상을 찾을 pk
			pstmt.executeUpdate();
			vo.setB(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("updateTest() 수행완료");
	}
	
	// delete 예나
	public void daleteTest(int a){
		String sql = "delete from test where a = ?";
		
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		System.out.println("deleteTest() 수행완료");

	}
	
	// 강사님 update
	public void updateTest(TestVO vo) { // 마이페이지의 회원정보변경기능을 생각해보자!
		//일반적으로 모든 칼럼을 바꾼다. 마이페이지-> 비밀번호 바꾸면 모두 업데이트가 된느것
		//한번에 처리하지않으면 전화번호인지, 이름인지, 점수인지 일일이 확인해야하니까.
		//String sql = "update test set sname=?,score=?,phont=?  where id = ?";
		
		//String sql = "update test set b=?, c=? where a=?";
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql_UPDATE); // sql
			pstmt.setString(1, vo.getB());
			pstmt.setInt(2, vo.getC());
			pstmt.setInt(3, vo.getA());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("updateTest 수행완료!");
		
	}
	
	// 강사님 delete
	public void deleteTest(TestVO vo) { // getTest와 비슷

		//String sql = "delete from test where a=?";
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_DELETE); //sql
			pstmt.setInt(1, vo.getA());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("deleteTest 수행완료!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
