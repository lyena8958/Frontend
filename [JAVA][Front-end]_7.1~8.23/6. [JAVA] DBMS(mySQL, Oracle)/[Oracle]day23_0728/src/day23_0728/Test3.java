package day23_0728;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
	
		// 서브쿼리
		// == 함수를 통한 sql문 처리 (오라클의 장점!)
		// auto_increment == nvl
		// nvl(A,B): A값을 쓰겠습니다. 단, A가 없다면 B로 대체하여 사용하겠습니다. // nollvalue:함수(인자두개)
		// nvl(컬럼값중에 가장큰값, 0)+1
		
		Scanner sc = new Scanner(System.in);
		
		String DName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kim";
		String pw = "8958";

		Connection conn = null;
		PreparedStatement pstmt = null; // Statement보다 많이씀

		try {
			Class.forName(DName);// 메서드(forName) 예외미루기를 했음

			conn = DriverManager.getConnection(url,user,pw); // 게터류

			// 뭘넣을지 모를 땐 ?로 넣을 수 있다. // ?인덱스는 무조건 1부터 시작
			String sql = "insert into member values ((select nvl(max(num),0)+1 from member),?, ?)";
			pstmt = conn.prepareStatement(sql); //생성 당시에 바로 sql을 넣을 수 있다!
			
			System.out.println("등록할 회원의 이름입력");
			String name = sc.next();
			System.out.println("현재 회원가입 이벤트 중으로, 3000포인트 지급!!!");
			
			// 인덱스 위치는 sql의 ? 위치    ?인덱스는 무조건 1부터 시작
			pstmt.setString(1, name);
			pstmt.setInt(2, 3000);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}//main종료

}
