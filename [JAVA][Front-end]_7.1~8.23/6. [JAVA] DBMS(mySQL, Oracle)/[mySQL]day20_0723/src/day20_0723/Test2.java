package day20_0723;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// 문제 DBMS(MySQL)에 member 테이블 생성 
		String DName = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3308/leedb";
		String user = "root";
		String password = "8958";

		String sql = "select * from member";
		
		
		
		// 강사님===================================================================
		
		// try에서 오류가 발생하면 close가 안되기때문에
		// finally에서 반드시close 실행시켜준다 
		
		//finally 에서 close하기 위해 아래 null로 초기화
		Connection conn = null; //
		Statement stmt = null;//
		ResultSet rs =null ;//
		try {
				Class.forName(DName); //메모리적재

			// 예외가발생하면 conn가 실행되지않기때문
			 conn = DriverManager.getConnection(url, user, password); // db연동 
																				
			 stmt = conn.createStatement();
			 
			 // 검색@@@@@@@@@@@@@@@@@ num
			 /*
			 System.out.println("알고싶은 번호를 입력하세요!");
			 Scanner sc = new Scanner(System.in);
			 int num =sc.nextInt();
			 // ex)select *from member where mnum=3; 로 연결 ↓
			 String sql2 = "select * from member2 where mnum="+num;
			 rs = stmt.executeQuery(sql2); 

			if (rs.next()) {
				System.out.print(rs.getInt("mnum") + " "); 
				System.out.print(rs.getString("mname") + "님, ");
				System.out.println(rs.getInt("point") + "p");

			}else {
				System.out.println("해당번호의 멤버는 없습니다!");
			}*/
			 
			 
			 // 검색@@@@@@@@@@@@@@@@@ point
			 System.out.println("검색기준이 될 포인트를 입력하세요");
			 Scanner sc = new Scanner(System.in);
			 int point = sc.nextInt();
			 String sql2 = "select * from member2 where point>="+point;
			 rs = stmt.executeQuery(sql2);  // 홍길동아리아무무 복사!(==itr)
			 
			 // rs에 저장된게 1 2 3 이라면 
			 // if에서 1이 지워지고 남은데이터인 23을 while에서 지워짐
			 // 정확하게는 다음 next를만나면 지워진다.(1. next(1) 2. (1)delete next(2 3))
//			 if(!rs.next()) {// 첫번째대상인 홍길동이 날아갔음 == 값을보면 지웠기때문에
//				 System.out.println("검색결과없음");
//			 }
			 boolean flag=true; // 값을 만났는지에 대한 여부
			 while (rs.next()) {//아무무와 아리만나옴
					System.out.print(rs.getInt("mnum") + " "); 
					System.out.print(rs.getString("mname") + "님, ");
					System.out.println(rs.getInt("point") + "p");
					flag=false;
				}
			 if(flag) {
				 System.out.println("검색결과없음");
			 }
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{// 오류가 발생하면 close가 실행안되니(null.close) try -->finally로 실행
			// 해야될 예외처리는 파이널리 안에서 하겠다.(인셉션으로 통합!)
			// 스코프 문제는 밖에서 실행 -> 초기화해라
				
			// re.close는 반드시 안해줘도된다.(stmt에서 하기때문)
			// 오류로인해 객체가 생성되지않으면 null.close로 생성되면 큰 오류가 되기 때문에
			// 조건문으로 필터해준다. (할당받으면 해제!!, 안했으면 해제할 필요없기 때문)
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}

			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//연결해제를 안하면 자리가 자꾸늘어가서 공간이부족해진다.
		
		
		/* 예나================================================================
		try {
			Class.forName(DName);

			Connection conn = DriverManager.getConnection(url, user, password); 
																				
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql); 

			while (rs.next()) {
				System.out.print(rs.getInt("mnum") + " "); 
				System.out.print(rs.getString("mname") + "님, ");
				System.out.print(rs.getInt("mpoint") + "p");

				System.out.println();
			}

			stmt.close(); 
			conn.close(); 

		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/


	}

}
// DBMS(MySQL)에 member 테이블 생성
// 1001 홍길동 100p
// 1002 아무무 120p 
// 1003 아리 70p

// console에서 나오도록 출력하자.
//1001 홍길동님, 100p
//1002 아무무님, 120p 
//1003 아리님, 70p