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
		System.out.println(mname+", ��ϿϷ�!");
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
		return mnum + ". " + mname + " ���:  " + cnt;
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
		System.out.println(name+"��, ��ϿϷ�!");
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
	// Test1 Ʈ�����ȭ
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
			Class.forName(DName);// �޼���(forName) ���̷ܹ�⸦ ����

			conn = DriverManager.getConnection(url,user,pw); // ���ͷ�

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
		// DB���� - �÷��ǿ� �޴�,�� ���� - DB�ݱ�

		// ����: �÷��� �ֹ�/����Ʈ���� �� db���� �� db�ݱ�
		
		// �����
		System.out.println("==�޴����==");
		for(Menu v: menuList) {
			System.out.println(v);
		}
		System.out.println();
		
		System.out.println("�ֹ���ȣ�Է�");
		Scanner sc = new Scanner(System.in);
		
		int mnum = sc.nextInt();
		
		System.out.println();
		System.out.println("==�����==");
		for(Member v: memList) {
			System.out.println(v);
		}
		System.out.println();
		
		System.out.println("����ȣ�Է�");
		int num = sc.nextInt();
		
//		menuList.get(mnum-1).setCnt(-1);
//		memList.get(num-1).setPoint(100);
		menuList.get(mnum-1).func();
		memList.get(num-1001).func();
		
		try {
			Class.forName(DName);// �޼���(forName) ���̷ܹ�⸦ ����

			conn = DriverManager.getConnection(url,user,pw); // ���ͷ�

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
		
		
		//����
		/*
		Scanner sc = new Scanner(System.in);

		System.out.println();
		int mnum;
		while(true) {
			System.out.println("=====ȸ��=====");
			for(Member mem:memList) {
				System.out.println(mem);
			}
			System.out.println();

			System.out.println("=====�޴�=====");
			for(Menu mu:menuList) {
				System.out.println(mu);
			}
			System.out.println();
			System.out.println("�ֹ� ��ȣ�� �Է����ּ���! ");
			mnum = sc.nextInt();

			// ��� �ִٸ�
			if(menuList.get(mnum-1).getCnt()>0) {
				System.out.println("�ֹ� �Ϸ�Ǿ����ϴ�.");
				menuList.get(mnum-1).setCnt(-1);
			}
			else {//��� ���ٸ�
				System.out.println("��� �������� �ֹ��� �Ұ��մϴ�. �ٽ� �ֹ����ּ���!\n\n");
				continue;
			}
			break;
		}

		System.out.println("����Ʈ ������ ȸ����ȣ�� �Է����ּ���!");
		int num = sc.nextInt();

		boolean flag = true;
		if(!(num<1001 || memList.get(memList.size()-1).getNum()< num)) {
			flag = false;
			System.out.println(memList.get(num-1001).getName()+" ����, �ȳ��ϼ���!");
			memList.get(num-1001).setPoint(100);
			System.out.println("100����Ʈ�� �����Ǿ����ϴ�!");
		}

		if(flag) {
			System.out.println("ȸ����ȣ�� ���� �ʾ� �ֹ��� �Ұ��մϴ�.");
			menuList.get(mnum-1).setCnt(1);
		}

		conn = null;
		stmt = null;
		try {
			conn = DriverManager.getConnection(url,user,pw); // ���ͷ�
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


		System.out.println("���α׷��� ����˴ϴ�.\n\n");
	}

}
