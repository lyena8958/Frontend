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
		return mnum+"�� ȸ��: "+mname+" ["+address+"/"+phone+ "]";
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
				System.out.println("1.C 2.R 3.U 4.D 5.�˻� 6.����");
				int act=sc.nextInt();
				if(act==1) {
					System.out.println("��������Է�");
					System.out.println("�̸��Է�");
					String mname=sc.next();
					System.out.println("��ȭ��ȣ�Է�");
					String phone=sc.next();
					System.out.println("�ּ��Է�");
					sc.nextLine();
					String address=sc.nextLine();
					String sql="insert into member2 (mname,phone,address) values('"+mname+"','"+phone+"','"+address+"')";
					System.out.println("�������߰���!");
					stmt.executeUpdate(sql);
				}
				else if(act==2) {
					ArrayList<Member> data=new ArrayList();
					String sql="select * from member2";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						//System.out.println("�������߰����� Ȯ��");
						int mnum=rs.getInt("mnum");
						String mname=rs.getString("mname");
						String phone=rs.getString("phone");
						String address=rs.getString("address");
						data.add(new Member(mnum,mname,phone,address));
					}
					System.out.println("==ȸ�����==");
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
						System.out.println("�����Ͻ� ����� ��ȣ�Է�: ");
						mnum = sc.nextInt();
						String sql = "select * from member2 where mnum="+ mnum;
						//ResultSet rs = stmt.executeQuery(sql);
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
							mnum=rs.getInt("mnum"); //mnum��Ȱ��
							String mname=rs.getString("mname");
							String phone=rs.getString("phone");
							String address=rs.getString("address");
							Member mem = new Member(mnum,mname,phone,address);
							//rs.close();
							System.out.println(mem); //������������ ����
							break;
						}else {
							System.out.println("�ش� ����� �����ϴ�! �ٽ��Է��غ�����!");
						}
					}
					rs.close();
					sc.nextLine();
					System.out.println("�ٲ� �ּҸ� �Է��ϼ���.");
					String address = sc.nextLine();
					String sql = "update member2 set address = '"+address+ "' where mnum="+mnum;
					stmt.executeLargeUpdate(sql);
					System.out.println("�ּҺ���Ϸ�!");
				}
				else if(act==4) {
					ResultSet rs = null;
					int mnum = 0;
					while(true) {
						System.out.println("������ ����� ��ȣ�Է�: ");
						mnum = sc.nextInt();
						String sql = "select * from member2 where mnum="+ mnum;
						//ResultSet rs = stmt.executeQuery(sql);
						rs = stmt.executeQuery(sql);
						if(rs.next()) {
							mnum=rs.getInt("mnum"); //mnum��Ȱ��
							String mname=rs.getString("mname");
							String phone=rs.getString("phone");
							String address=rs.getString("address");
							Member mem = new Member(mnum,mname,phone,address);
							//rs.close();
							System.out.println(mem); //������������ ����
							break;
						}else {
							System.out.println("�ش� ����� �����ϴ�! �ٽ��Է��غ�����!");
						}
					}
					rs.close();
					sc.nextLine();
					System.out.println("������ �����մϴ�...");
					String address = sc.nextLine();
					String sql = "delete from member2 where mnum="+mnum;
					stmt.executeLargeUpdate(sql);
					System.out.println("�����Ϸ�!");
				}
				else if(act==5) {
					// �����
					// case1
					System.out.println("[�˻�ȭ��]");
					System.out.println("1.��ȣ 2.�ּҰ˻�");
					act = sc.nextInt();
					if(act==1) {
						ArrayList<Member> data=new ArrayList();
						String sql="select * from member2";
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next()) {
							//System.out.println("�������߰����� Ȯ��");
							int mnum=rs.getInt("mnum");
							String mname=rs.getString("mname");
							String phone=rs.getString("phone");
							String address=rs.getString("address");
							data.add(new Member(mnum,mname,phone,address));
						}
						System.out.println("==ȸ�����==");
						for(Member mem:data) {
							System.out.println(mem);
						}
						// data.clear();
						rs.close();
						System.out.println("���ȸ����ȣ�� ����ұ��?");
						int mnum = sc.nextInt();
						boolean flag = true; // �÷��׺��� ����!
						for(Member mem:data) {
							if(mem.mnum==mnum) {
								System.out.println("�˻��Ͻ� ȸ���� ����...");
								System.out.println(mem);
								flag = false;
								break;
							}
						}
						if(flag){
							System.out.println("�ش�ȸ������!");
						}
					}
					else {//1���� �ƴ� ���� ��� �ּҰ˻�
						sc.nextLine(); // ��������
						System.out.println("�˻��� �ּ��Է�");
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
							System.out.println("�˻��������!");
						}
						else {
							System.out.println("==�˻��� ȸ�����==");
							for(Member mem:data) {
								System.out.println(mem);
							}
						}
						rs.close();
					}
					// ����
					/*
            	ResultSet rs = null;
            	int mnum = 0;
            	String mname = null;
        		String phone = null;
        		String address = null;
        		while(true) {
        			System.out.println("�˻� ����� ��ȣ�Է�: ");
        			mnum = sc.nextInt();
        			String sql = "select * from member2 where mnum="+ mnum;
        			rs = stmt.executeQuery(sql);
        			if(rs.next()) {
        				mnum=rs.getInt("mnum"); //mnum��Ȱ��
        				mname=rs.getString("mname");
        				phone=rs.getString("phone");
        				address=rs.getString("address");
        				sc.nextLine();
        				rs.close();
        				System.out.println("1.�̸� 2. �޴�����ȣ 3.�ּ�");
        				act = sc.nextInt();
        				if(act==1) {
        					System.out.println("�����"+mname +"���� ������ "+mname+"�Դϴ�.");
        				}
        				else if(act==2) {
        					System.out.println("�����" +mname + "���� ��ȭ��ȣ�� "+phone+"�Դϴ�.");
        				}
        				else if(act==3) {
        					System.out.println("�����"+mname+ "���� �ּҴ� "+address+"�Դϴ�.");
        				}else {
        					System.out.println("�߸������̽��ϴ�.");
        					continue;
        				}
        				break;
        			}else {
            			System.out.println("�ش� ����� �����ϴ�! �ٽ��Է��غ�����!");
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