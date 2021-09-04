package day20_0723;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
DB 연동
JDBC API: DBMS의 데이터를 CRUD할 수 있게 연동  (자바DB연결 컬렉터)

 1) JDBC 드라이버 메모리에(JVM) 로드 (자바에서 연동에 통일성을위해 JVM이 있다)
 2) DB에 연결
 3) DB에 데이터를 read, write(CRUD)
 4) DB연결해제☆ 

 */
public class Test1 {
	public static void main(String[] args) {
		
		// 드라이버에 이름을 읽으려고하면 메모리에 적재를 해준다.
		
		// Class.forName(DName);
		String DName="com.mysql.jdbc.Driver"; // 드라이버
		  // Mysql DBMS 주석달아야함 아래 변수명이아니라면
		// String DName_Mysql="com.mysql.jdbc.Driver"; // 드라이버

		
		//DriverManager
		// 아래처럼 유지보수를 위해 미리 만들어놓는다.
		String url="jdbc:mysql://localhost:3308/leedb";
		//			프로토콜			IP주소   :포트번호/DB명(스키마명)
		//						ip:본인pc에서하기때문에 주소를적지않음
		String user="root";
		String password="8958";

		
		String sql ="select * from student2"; 
		
		try {
			// (1) 로드 - sql틀렸거나 해당db가없으면 실행불가
			Class.forName(DName); // 	Class.forName("com.mysql.jdbc.Driver"); 할 순 있으나 유지보수가 안좋다.
			// JDBC의 드라이버 클래스명을 읽게하여
			// 메모리에 적재시킬예정
			
			
			// 리턴타입: 커넥션이기때문에 커넥션 변수생성 (getConnection- 게터류)
			Connection conn=DriverManager.getConnection(url, user, password); //DriverManager.getConnection(url, user, password)
			//url:접근할수있는경로
			// DB연동에 성공하면, 해당DB에 접근할수있게 해주는
			// 커넥션 Connection 객체를 반환받는다!
			// 콘솔에 화면은 write할수있는게 scanner == 커넥션 (같은의미) ->둘다 클래스의 객체!
			
			// DBMS는 자바의 외부, 학생1이 접근, 학생2가 접근 같이접근해도 상관이없다. 라는걸 관리하는게 Connection(커넥션)
			// == 커넥션하나가 사용자 하나 (일정한 폼을 제공->주소입력하면 우편번호가 자동으로뜨듯이)
			Statement stmt = conn.createStatement();
			// Connection 객체에서 생성한 Statement 객체로
			// DB데이터에 접근할수있다!
			ResultSet rs = stmt.executeQuery(sql); // 리턴Result set, 인자 string sql문으로 접근(★인자를 잘입력해야된다. 오류를 모르기때무ㅠㄴ)
			
			//ResultSet 객체(==rs)의 역할
			// table을 --->> class 객체
			while(rs.next()) { // rs는 itr와 비슷하여, 다음이있니?라고 묻는것이다.(리턴 - boolean)
				//타입을 지정할수있다.
				System.out.println(rs.getInt("num")); // (rs.getInt(columnLabel - 속성,애트리뷰트)
				System.out.println(rs.getInt("score"));
				System.out.println(rs.getString("sname"));
				System.out.println("=====");
			}
			
			//(4)db연결해제
			stmt.close(); // 안닫아주면 오류가 많이 발생함 ....re.close();까지 다 해줘서 re.close안해줘도됨
			conn.close(); // 하면 stmt가 높은확률도 닫히기 때문에 열었던 순서대로 닫아준다.
			
		} catch (ClassNotFoundException e) {  //forName 클래스가 찾아지지않는다 란 오류가 생길 수 있다
			e.printStackTrace();
		} catch (SQLException e) {//DriverManager
			e.printStackTrace();
		} 
		
		// DBMS는 자바의 외부, 학생1이 접근, 학생2가 접근 같이접근해도 상관이없다. 라는걸 관리하는게 Connection(커넥션)
		// == 커넥션하나가 사용자 하나 (일정한 폼을 제공->주소입력하면 우편번호가 자동으로뜨듯이)

		
		// --> 이대로 발생하면 오류가 나니 "ClassNotFoundException" jar갖고와야됨
		// 프로젝트 오른쪽버튼->properties -> java blild Path -> Libraries -> add external... -> apply
		// add할 자료는 kim_0621 ->리소스->db파일->jar파일
		
		// 성공!!!!!!!--> Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
	}

}
