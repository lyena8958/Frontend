package day23_0728;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

class Menu{
	private int mnum;
	private String mname;
	private int cnt;
	Menu(int mnum, String mname, int cnt){
		this.mnum = mnum;
		this.mname = mname;
		this.cnt = cnt;
		System.out.println(mname+", 등록완료!");
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt += cnt;
	}
	public int getMnum() {
		return mnum;
	}
	public String getMname() {
		return mname;
	}
	@Override
	public String toString() {
		return mnum + ". " + mname + " 재고:  " + cnt;
	}
	void func() {
		this.cnt--;
	}

}
class Member{
	private int num;
	private String name;
	private int point;
	Member(int num, String name, int point){
		this.num = num;
		this.name = name;
		this.point = point;
		System.out.println(name+"님, 등록완료!");
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point += point;
	}
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return num + " " + name + " point=" + point;
	}
	void func() {
		this.point +=100;
	}
}
public class Test2 {
	// Test1 트랜잭션화
	public static void main(String[] args) {


		ArrayList<Menu> menuList = new ArrayList();
		ArrayList<Member> memList = new ArrayList();


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

			String sql1 = "select * from menu";
			String sql2 = "select * from member";

			// menu
			ResultSet rs = stmt.executeQuery(sql1);
			while(rs.next()) {
				int mnum = rs.getInt("mnum");
				String mname = rs.getString("mname");
				int cnt = rs.getInt("cnt");
				menuList.add(new Menu(mnum,mname,cnt));
			}
			rs.close();

			// member
			rs = stmt.executeQuery(sql2);
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int point = rs.getInt("point");
				memList.add(new Member(num,name,point));
			}
			rs.close();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// DB오픈 - 컬렉션에 메뉴,고객 저장 - DB닫기

		// 문제: 컬렉션 주문/포인트적립 후 db저장 후 db닫기
		
		// 강사님
		System.out.println("==메뉴목록==");
		for(Menu v: menuList) {
			System.out.println(v);
		}
		System.out.println();
		
		System.out.println("주문번호입력");
		Scanner sc = new Scanner(System.in);
		
		int mnum = sc.nextInt();
		
		System.out.println();
		System.out.println("==고객목록==");
		for(Member v: memList) {
			System.out.println(v);
		}
		System.out.println();
		
		System.out.println("고객번호입력");
		int num = sc.nextInt();
		
//		menuList.get(mnum-1).setCnt(-1);
//		memList.get(num-1).setPoint(100);
		menuList.get(mnum-1).func();
		memList.get(num-1001).func();
		
		try {
			Class.forName(DName);// 메서드(forName) 예외미루기를 했음

			conn = DriverManager.getConnection(url,user,pw); // 게터류

			stmt = conn.createStatement();

			for(int i = 0; i < menuList.size();i++) {
				stmt.executeUpdate("update menu set cnt = "+menuList.get(i).getCnt()+" where mnum = "+menuList.get(i).getMnum());
			}
			for(int i = 0; i < memList.size();i++) {
				stmt.executeUpdate("update member set point = "+memList.get(i).getPoint()+" where num = "+memList.get(i).getNum());
			}
		

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//예나
		/*
		Scanner sc = new Scanner(System.in);

		System.out.println();
		int mnum;
		while(true) {
			System.out.println("=====회원=====");
			for(Member mem:memList) {
				System.out.println(mem);
			}
			System.out.println();

			System.out.println("=====메뉴=====");
			for(Menu mu:menuList) {
				System.out.println(mu);
			}
			System.out.println();
			System.out.println("주문 번호를 입력해주세요! ");
			mnum = sc.nextInt();

			// 재고가 있다면
			if(menuList.get(mnum-1).getCnt()>0) {
				System.out.println("주문 완료되었습니다.");
				menuList.get(mnum-1).setCnt(-1);
			}
			else {//재고가 없다면
				System.out.println("재고 부족으로 주문이 불가합니다. 다시 주문해주세요!\n\n");
				continue;
			}
			break;
		}

		System.out.println("포인트 적립할 회원번호를 입력해주세요!");
		int num = sc.nextInt();

		boolean flag = true;
		if(!(num<1001 || memList.get(memList.size()-1).getNum()< num)) {
			flag = false;
			System.out.println(memList.get(num-1001).getName()+" 고객님, 안녕하세요!");
			memList.get(num-1001).setPoint(100);
			System.out.println("100포인트가 적립되었습니다!");
		}

		if(flag) {
			System.out.println("회원번호가 맞지 않아 주문이 불가합니다.");
			menuList.get(mnum-1).setCnt(1);
		}

		conn = null;
		stmt = null;
		try {
			conn = DriverManager.getConnection(url,user,pw); // 게터류
			stmt = conn.createStatement();
			for(Menu mu:menuList) {
				String sql = "update menu set cnt = "+mu.getCnt()+" where mnum = "+mu.getMnum();
				stmt.executeUpdate(sql);
			}

			for(Member mem:memList) {
				String sql = "update member set point = "+mem.getPoint()+" where num = "+mem.getNum();
				stmt.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}*/


		System.out.println("프로그램이 종료됩니다.\n\n");
	}

}
