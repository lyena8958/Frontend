package day23_0728;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

// 4단계
// 드라이버로드
// DB연결
// DB데이터에 read, write ☆
// DB연결해제
public class Test1 {

	public static void main(String[] args) {
		
		String DName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kim";
		String pw = "8958";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(DName);// 메서드(forName) 예외미루기를 했음
			
			conn = DriverManager.getConnection(url,user,pw); // 게터류
			
			stmt = conn.createStatement();
			
			int menuCnt = 0;
			
			// 메뉴개수를 생성
			String sql = "select count(*) from menu"; // count함수 == 요소의 개수
			ResultSet rs = stmt.executeQuery(sql); // executeQuery 리턴 -> rs
			
			
			while(rs.next()) {// select할 요소의 자릿수 == count 1번째
				menuCnt = rs.getInt(1); // 메뉴개수 3개
				// System.out.println("데이터 개수는 "+rs.getInt(1)+"개 입니다."); // 데이터 총 개수
			}
			
			rs.close();
			
			// 메뉴목록을 출력
			sql = "select * from menu";
			rs = stmt.executeQuery(sql);
			System.out.println("==메뉴목록==");
			
			ArrayList<Integer> numMem = new ArrayList();
			ArrayList<Integer> data = new ArrayList();
			ArrayList<Integer> point = new ArrayList();
			while(rs.next()) {// 1, 2, 3 --> 요소의 자릿수 (0이아니라 1부터시작)
				System.out.println(rs.getInt("mnum")+"."+rs.getString("mname")+"  재고: "+rs.getInt("cnt"));
				data.add(rs.getInt("cnt"));
			}
			System.out.println();
			sql = "select point, num from member";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				point.add(rs.getInt(1)); // 포인트저장
				numMem.add(rs.getInt(2)); // 번호저장
			}
			rs.close();
			
			Scanner sc = new Scanner(System.in);
			int mnum;
			while(true) {
				System.out.println("메뉴번호 입력");
				mnum = sc.nextInt();
				
				if(mnum <1 || menuCnt<mnum) {
					System.out.println("해당메뉴번호는 없습니다! 다시입력하세요!");
					continue;
				}
				if(data.get(mnum-1)<=0) {
					System.out.println("해당메뉴는 현재 재고가 없습니다! 다른 메뉴를 주문해주세요!");
					continue;
				}
				//sql="update menu set cnt=cnt-1 where mnum = "+mnum; // sql는 증감연산자가없다
				//stmt.executeUpdate(sql);
				System.out.println("주문완료!");
				data.set(mnum-1, data.get(mnum-1)-1); // 위에서 초기화가 다시 되기때문에 굳이 차감시키지 않음.
				break;
			}
			
			System.out.println("구매자 번호입력");
			int num = sc.nextInt();		// 결제금액에서 포인트를 산정할수도있음
			//String sqlP = "update member set point=point+100 where num="+num; // num을 1로 입력하면 member테이블의 num과 달라서 입력이 안됨
			//int res = stmt.executeUpdate(sql);
			// System.out.println("res= "+res); num에 1001번 등 회원번호가 아닌 1이나 입력하면 
			// 수행된 결과가 없다면, 0이 리턴(반환)된다. => 1(결과가 있다면 1이 반환)
			boolean flag = true;
			for(Object obj:numMem) {
				if((int)obj==num) {
					flag=false;
					System.out.println("구매완료!");
					point.set(num-1001, (point.get(num-1001)+100));
					String sqlP = "update member set point=point+100 where num="+num;
					stmt.executeUpdate(sqlP);
				}
			}
			if(flag) {//구매 완료가 안되었다면
				System.out.println("해당 고객번호는 유효하지 않아 구매가 불가합니다!");
				data.set(mnum-1, data.get(mnum-1)+1); // 재고추가
			}
			
			sql="update menu set cnt="+data.get(mnum-1)+" where mnum = "+mnum;
			stmt.executeUpdate(sql);
			
			
			
		}catch (Exception e) { // 귀찮다면 최상위 인셉션으로 해도됨
			e.printStackTrace();
		} finally {
			try {//만들어낸 역순으로 클로즈 해줘야함
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}//main종료

}
