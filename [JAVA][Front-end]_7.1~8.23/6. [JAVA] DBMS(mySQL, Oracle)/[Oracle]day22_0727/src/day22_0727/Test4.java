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
		System.out.println(this.name+" 학생 반갑습니다!");
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
		return snum + " " + name + ": [" + score + "점 ]";
	}

}
public class Test4 {

	public static void main(String[] args) {
		// 문제
		/*
		 * .풀이는 내일!
		 * 속성은 번호 이름 성적
		-> java Test4    -> test.sql
		1) test.sql에서 학생정보를 5개 저장해주세요
		   console로 출력해주세요!~~

		2) 학생들의 이름을 전부 수정해주세요
		  단, 수정은 console에서 입력하여 진행합니다!~~

		3+) "김"(->console)이라는 값을 가진 학생을 전부 출력해주세요!~~
		  홍길동 아리 아무무 티모
		  김효경 김꺽정 티김모
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
				System.out.println("\n1.이름변경\n2.학생목록 출력\n3.이름검색\n4.종료");
				int act = sc.nextInt();
				
				if(act==1) {
					System.out.println("이름 변경모드 접속!");
					System.out.println("변경할 학생번호를 입력해주세요");
					int num = sc.nextInt();
					boolean flag = true;
					for(Student1 v:data) {
						if(num==v.getSnum()) {
							flag = false;
							System.out.println(v.getName()+"님 안녕하세요!");
							System.out.println("\n변경하실 이름을 입력해주세요.");
							String name = new Scanner(System.in).next();
							sql = "update student set name='"+name+"' where name='"+v.getName()+"'";
							stmt.executeUpdate(sql);
							v.setName(name); // 변경이름 적용
							System.out.println("변경완료 되었습니다.");
							break;
						}
					}
					if(flag) {
						System.out.println("입력된 정보가 없습니다. 모드창으로 돌아갑니다.");
					}
				}
				else if(act==2) {
					System.out.println("- - - - - - - -학생목록 출력- - - - - - - -");
					for(Student1 stu : data) {
						System.out.println(stu);
					}
				}
				else if(act==3) {
					System.out.println("- - - - - - - -이름 검색- - - - - - - -");
					System.out.println("검색할 이름의 한 자를 입력해주세요.");
					String word = sc.next();
					sql = "select *from student where name like '%"+word+"%'";
					rs = stmt.executeQuery(sql);
					System.out.println("\n검색된 이름입니다.");
					while(rs.next()) {
						System.out.println(rs.getString("name"));
					}
				}
				else if(act==4) {
					System.out.println("프로그램이 종료됩니다. 이용해 주셔서 감사합니다!");
					break;
				}
				else {
					System.out.println("잘못된 입력입니다.다시 입력해주세요!");
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
