package day22_0727;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

class Member{
	int mnum;
	String mname;
	String phone;
	String address;
	Member(int mnum,String mname,String phone,String address){
		this.mnum=mnum;
		this.mname=mname;
		this.phone=phone;
		this.address=address;
	}
	@Override
	public String toString() {
		return mnum+"번 회원: "+mname+" ["+address+"/"+phone+ "]";
	}
}
public class Test1 {

	public static void main(String[] args) {

		String DName="com.mysql.cj.jdbc.Driver";

		String url="jdbc:mysql://localhost:3308/leedb";
		String user="root";
		String password="8958";

		Connection conn=null;
		Statement stmt=null;

		try {
			Class.forName(DName);

			conn=DriverManager.getConnection(url, user, password);

			stmt=conn.createStatement();

			Scanner sc=new Scanner(System.in);
			while(true) {
				System.out.println("1.C 2.R 3.U 4.D 5.검색 6.종료");
				int act=sc.nextInt();
				if(act==1) {
					System.out.println("멤버정보입력");
					System.out.println("이름입력");
					String mname=sc.next();
					System.out.println("전화번호입력");
					String phone=sc.next();
					System.out.println("주소입력");
					sc.nextLine();
					String address=sc.nextLine();
					String sql="insert into member2 (mname,phone,address) values('"+mname+"','"+phone+"','"+address+"')";
					System.out.println("고객정보추가됨!");
					stmt.executeUpdate(sql);
				}
				else if(act==2) {
					ArrayList<Member> data=new ArrayList();
					String sql="select * from member2";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						//System.out.println("데이터추가됨을 확인");
						int mnum=rs.getInt("mnum");
						String mname=rs.getString("mname");
						String phone=rs.getString("phone");
						String address=rs.getString("address");
						data.add(new Member(mnum,mname,phone,address));
					}
					System.out.println("==회원목록==");
					for(Member mem:data) {
						System.out.println(mem);
					}
					// data.clear();
					rs.close();
				}
				else if(act==3) {
					ResultSet rs = null;
					int mnum = 0;
					while(true) {
						System.out.println("변경하실 멤버의 번호입력: ");
						mnum = sc.nextInt();
						String sql = "select * from member2 where mnum="+ mnum;
						//ResultSet rs = stmt.executeQuery(sql);
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
							mnum=rs.getInt("mnum"); //mnum재활용
							String mname=rs.getString("mname");
							String phone=rs.getString("phone");
							String address=rs.getString("address");
							Member mem = new Member(mnum,mname,phone,address);
							//rs.close();
							System.out.println(mem); //마이페이지의 역할
							break;
						}else {
							System.out.println("해당 멤버는 없습니다! 다시입력해보세요!");
						}
					}
					rs.close();
					sc.nextLine();
					System.out.println("바꿀 주소를 입력하세요.");
					String address = sc.nextLine();
					String sql = "update member2 set address = '"+address+ "' where mnum="+mnum;
					stmt.executeLargeUpdate(sql);
					System.out.println("주소변경완료!");
				}
				else if(act==4) {
					ResultSet rs = null;
					int mnum = 0;
					while(true) {
						System.out.println("삭제할 멤버의 번호입력: ");
						mnum = sc.nextInt();
						String sql = "select * from member2 where mnum="+ mnum;
						//ResultSet rs = stmt.executeQuery(sql);
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
							mnum=rs.getInt("mnum"); //mnum재활용
							String mname=rs.getString("mname");
							String phone=rs.getString("phone");
							String address=rs.getString("address");
							Member mem = new Member(mnum,mname,phone,address);
							//rs.close();
							System.out.println(mem); //마이페이지의 역할
							break;
						}else {
							System.out.println("해당 멤버는 없습니다! 다시입력해보세요!");
						}
					}
					rs.close();
					sc.nextLine();
					System.out.println("삭제를 진행합니다...");
					String address = sc.nextLine();
					String sql = "delete from member2 where mnum="+mnum;
					stmt.executeLargeUpdate(sql);
					System.out.println("삭제완료!");
				}
				else if(act==5) {
					// 강사님
					// case1
					System.out.println("[검색화면]");
					System.out.println("1.번호 2.주소검색");
					act = sc.nextInt();
					if(act==1) {
						ArrayList<Member> data=new ArrayList();
						String sql="select * from member2";
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next()) {
							//System.out.println("데이터추가됨을 확인");
							int mnum=rs.getInt("mnum");
							String mname=rs.getString("mname");
							String phone=rs.getString("phone");
							String address=rs.getString("address");
							data.add(new Member(mnum,mname,phone,address));
						}
						System.out.println("==회원목록==");
						for(Member mem:data) {
							System.out.println(mem);
						}
						// data.clear();
						rs.close();
						System.out.println("몇번회원번호를 출력할까요?");
						int mnum = sc.nextInt();
						boolean flag = true; // 플래그변수 로직!
						for(Member mem:data) {
							if(mem.mnum==mnum) {
								System.out.println("검색하신 회원의 정보...");
								System.out.println(mem);
								flag = false;
								break;
							}
						}
						if(flag){
							System.out.println("해당회원없음!");
						}
					}
					else {//1번이 아닌 것은 모두 주소검색
						sc.nextLine(); // 버퍼제거
						System.out.println("검색할 주소입력");
						String address = sc.nextLine();
						String sql = "select * from member2 where address like '"+address+"%'";
						ResultSet rs = stmt.executeQuery(sql);
						ArrayList<Member> data=new ArrayList();
						boolean flag = true;
						while(rs.next()) {
							flag=false;
							int mnum=rs.getInt("mnum");
							String mname=rs.getString("mname");
							String phone=rs.getString("phone");
							address=rs.getString("address");
							data.add(new Member(mnum,mname,phone,address));
						}
						if(flag) {
							System.out.println("검색결과없음!");
						}
						else {
							System.out.println("==검색한 회원목록==");
							for(Member mem:data) {
								System.out.println(mem);
							}
						}
						rs.close();
					}
					// 예나
					/*
            	ResultSet rs = null;
            	int mnum = 0;
            	String mname = null;
        		String phone = null;
        		String address = null;
        		while(true) {
        			System.out.println("검색 멤버의 번호입력: ");
        			mnum = sc.nextInt();
        			String sql = "select * from member2 where mnum="+ mnum;
        			rs = stmt.executeQuery(sql);
        			if(rs.next()) {
        				mnum=rs.getInt("mnum"); //mnum재활용
        				mname=rs.getString("mname");
        				phone=rs.getString("phone");
        				address=rs.getString("address");
        				sc.nextLine();
        				rs.close();
        				System.out.println("1.이름 2. 휴대폰번호 3.주소");
        				act = sc.nextInt();
        				if(act==1) {
        					System.out.println("저장된"+mname +"님의 성함은 "+mname+"입니다.");
        				}
        				else if(act==2) {
        					System.out.println("저장된" +mname + "님의 전화번호는 "+phone+"입니다.");
        				}
        				else if(act==3) {
        					System.out.println("저장된"+mname+ "님의 주소는 "+address+"입니다.");
        				}else {
        					System.out.println("잘못누르셨습니다.");
        					continue;
        				}
        				break;
        			}else {
            			System.out.println("해당 멤버는 없습니다! 다시입력해보세요!");
            		}
            	}    */     	
				}
				else {
					break;
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close(); // if(stmt!=null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}