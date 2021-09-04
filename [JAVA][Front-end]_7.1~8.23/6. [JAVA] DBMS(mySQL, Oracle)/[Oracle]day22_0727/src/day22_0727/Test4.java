package day22_0727;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
class Student1{
	Student1(int snum, String name, int score){
		this.snum = snum;
		this.name = name;
		this.score = score;
		System.out.println(this.name+" �л� �ݰ����ϴ�!");
	}

	private int snum;
	private	String name;
	private int score;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	@Override
	public String toString() {
		return snum + " " + name + ": [" + score + "�� ]";
	}

}
public class Test4 {

	public static void main(String[] args) {
		// ����
		/*
		 * .Ǯ�̴� ����!
		 * �Ӽ��� ��ȣ �̸� ����
		-> java Test4    -> test.sql
		1) test.sql���� �л������� 5�� �������ּ���
		   console�� ������ּ���!~~

		2) �л����� �̸��� ���� �������ּ���
		  ��, ������ console���� �Է��Ͽ� �����մϴ�!~~

		3+) "��"(->console)�̶�� ���� ���� �л��� ���� ������ּ���!~~
		  ȫ�浿 �Ƹ� �ƹ��� Ƽ��
		  ��ȿ�� �販�� Ƽ���
		 */
		Scanner sc = new Scanner(System.in);
		String DName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kim";
		String pw = "8958";

		String sql = "select * from student";


		Connection conn = null;
		Statement stmt = null;
		try {
			ArrayList<Student1> data = new ArrayList();
			Class.forName(DName);
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int snum = rs.getInt("snum");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				data.add(new Student1(snum,name,score));
			}
			rs.close();

			while(true) {
				System.out.println("\n1.�̸�����\n2.�л���� ���\n3.�̸��˻�\n4.����");
				int act = sc.nextInt();
				
				if(act==1) {
					System.out.println("�̸� ������ ����!");
					System.out.println("������ �л���ȣ�� �Է����ּ���");
					int num = sc.nextInt();
					boolean flag = true;
					for(Student1 v:data) {
						if(num==v.getSnum()) {
							flag = false;
							System.out.println(v.getName()+"�� �ȳ��ϼ���!");
							System.out.println("\n�����Ͻ� �̸��� �Է����ּ���.");
							String name = new Scanner(System.in).next();
							sql = "update student set name='"+name+"' where name='"+v.getName()+"'";
							stmt.executeUpdate(sql);
							v.setName(name); // �����̸� ����
							System.out.println("����Ϸ� �Ǿ����ϴ�.");
							break;
						}
					}
					if(flag) {
						System.out.println("�Էµ� ������ �����ϴ�. ���â���� ���ư��ϴ�.");
					}
				}
				else if(act==2) {
					System.out.println("- - - - - - - -�л���� ���- - - - - - - -");
					for(Student1 stu : data) {
						System.out.println(stu);
					}
				}
				else if(act==3) {
					System.out.println("- - - - - - - -�̸� �˻�- - - - - - - -");
					System.out.println("�˻��� �̸��� �� �ڸ� �Է����ּ���.");
					String word = sc.next();
					sql = "select *from student where name like '%"+word+"%'";
					rs = stmt.executeQuery(sql);
					System.out.println("\n�˻��� �̸��Դϴ�.");
					while(rs.next()) {
						System.out.println(rs.getString("name"));
					}
				}
				else if(act==4) {
					System.out.println("���α׷��� ����˴ϴ�. �̿��� �ּż� �����մϴ�!");
					break;
				}
				else {
					System.out.println("�߸��� �Է��Դϴ�.�ٽ� �Է����ּ���!");
					continue;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();	
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}



	}

}
