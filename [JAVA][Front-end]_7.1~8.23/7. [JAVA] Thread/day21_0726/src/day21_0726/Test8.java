//이예나
// 강사님 답 -> day22_0727 Test1
package day21_0726;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//사용자 지정 예외처리
class MyException extends Exception {
	MyException(String msg) {
		super(msg);
	}
}

// 고객 데이터 클래스
class Customer {
	Customer(int cnum, String cname, String cphonenum, String address) {
		this.cnum = cnum;
		this.cname = cname;
		this.cphonenum = cphonenum;
		this.address = address;
	}

	// 고객정보
	int cnum; // 고객번호
	String cname; // 성함
	String cphonenum; // 휴대폰번호
	String address; // 주소

	// 고객출력
	@Override
	public String toString() { 
		return "고객번호: " + cnum + ", 성함: " + cname + ", 휴대폰번호:" + cphonenum + ", 주소:" + address;
	}

}

public class Test8 {
	// 개인프로젝트
	/*
	 * 개인-프로젝트 / 오늘 고객 관리 프로그램 테이블-고객정보 고객번호(pk),이름,전화번호(String),주소 1 아리
	 * 010-1234-5678 서울시 관악구
	 * 
	 * 1)고객정보추가 C 2)고객정보변경 U -> 전화번호변경-1 주소-2 3)고객정보삭제 D 4)고객목록출력 R 5+) 고객정보검색 6)종료
	 */

	//int형 예외처리함수
	static int NumCheck(int a, int b) {
		MyException excp = new MyException("[입력오류] 다시 입력해주세요.");

		int num;
		while (true) {
			try {
				num = new Scanner(System.in).nextInt();
				if(num<a||b<num) {
					System.out.println("");
					throw excp;
				}
			}catch(InputMismatchException e) {
				new Scanner(System.in).next();
				System.out.println("[타입오류] 다시입력해주세요.");
				continue;
			}catch(MyException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}

			break;
		}
		return num;
	}
	// (오버로딩) int형 예외처리함수 (인자없음)
	static int NumCheck() {
		MyException excp = new MyException("[입력오류] 다시 입력해주세요.");
		int num;
		while (true) {
			try {
				num = new Scanner(System.in).nextInt();
			}catch(InputMismatchException e) {
				new Scanner(System.in).next();
				System.out.println("[타입오류] 다시입력해주세요.");
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}

			break;
		}
		return num;
	}
	// String형 예외처리함수 (인자없음)
	static String strCheck() {
		MyException excp = new MyException("[입력오류] 다시 입력해주세요.");
		String str;
		while (true) {
			try {
				str = new Scanner(System.in).nextLine();
			}catch(InputMismatchException e) {
				new Scanner(System.in).next();
				System.out.println("[타입오류] 다시입력해주세요.");
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}

			break;
		}
		return str;
	}
	// 고객번호 비교 함수 - boolean반환
	static boolean cnumCom(ArrayList<Customer> data,int cnum) {
		for(int i = 0; i < data.size(); i++) {
			if(cnum == data.get(i).cnum) {
				System.out.println(data.get(i).cname+"님, 반갑습니다.");
				return true;
			}
		}
		return false;
	}
	// 고객번호 비교 함수 (오버로딩) - index 반환 
	static int cnumIndex(ArrayList<Customer> data,int cnum) {
		for(int i = 0; i < data.size(); i++) {
			if(cnum == data.get(i).cnum) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 고객정보 저장할 배열리스트
		ArrayList<Customer> data = new ArrayList<Customer>();

		// 드라이버 주소
		String DName = "com.mysql.cj.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3308/leedb";
		String user = "root";
		String pw = "8958";
		String sql = "select * from customer order by cnum asc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 드라이버 연결
			Class.forName(DName);

			// db연동
			conn = DriverManager.getConnection(url, user, pw);

			// db접근
			stmt = conn.createStatement();

			// 복사체 생성
			rs = stmt.executeQuery(sql); // select만 할때만 씀

			// db에 입력된 데이터 customer클래스 객체화
			while (rs.next()) {
				data.add(new Customer(rs.getInt("cnum"), rs.getString("cname"), rs.getString("cphonenum"),
						rs.getString("address")));
			}


			// 다음 고객번호 (data.size()-1.cnum == Last index cnum) 마지막번호
			int nextCnum = data.get(data.size()-1).cnum;


			// 고객프로그램 *********************S T A R T***********************
			while (true) {

				System.out.println("\n\n○○회사 고객정보관리 입니다. 원하시는 버튼을 입력하여 주세요.\n");
				System.out.println("1.회원가입\n2.고객정보변경\n3.회원탈퇴\n4.고객목록출력\n5.정보검색\n6.종료");

				int act = NumCheck(1, 6); // 모드선택,  예외처리함수호출 1이상 6이하 입력

				// [회원가입]
				if (act == 1) {
					System.out.println("- - - - - - - - - - -회원가입 모드- - - - - - - - - - -");
					// 개인정보 입력
					System.out.println("성함을 입력해주세요. ");
					String cname = strCheck(); 
					System.out.println("휴대폰번호를 입력해주세요. ");
					String cphonenum = strCheck();
					System.out.println("주소를 입력해주세요. ");
					String address = strCheck();

					nextCnum++;// 부여될 고객번호

					// DB 데이터 저장
					sql = "insert into customer values(" + nextCnum + ", '" + cname + "', '" + cphonenum + "', '"
							+ address + "')";
					// 가입고객 데이터 객체화 
					data.add(new Customer(nextCnum, cname, cphonenum, address));

					stmt.executeUpdate(sql); // 데이터 업데이트
					System.out.println(cname+"님, 반갑습니다!! 회원가입 완료되었습니다! :D");
				}
				// [고객정보변경]
				else if (act == 2) {
					System.out.println("- - - - - - - - - - -고객정보변경 모드- - - - - - - - - - -");
					System.out.println("본인확인을 위해 고객번호를 입력해주세요. ");

					int cnum = NumCheck(); // 고객번호 입력

					// (고객번호 비교)
					// 정보에 고객번호가 일치하지않다면
					if(!cnumCom(data, cnum)) {//함수호출 -> 고객번호가 없으면 false반환
						System.out.println("고객번호가 일치하지 않습니다. 정보변경 모드 종료됩니다.");
						continue; // 프로그램 처음으로 이동
					}
					// 함수호출 -> 고객대상의 index 반환
					int index = cnumIndex(data,cnum); 

					// 번호가 일치하다면 변경진행
					System.out.println("변경할 목록을 선택해주세요!!");
					System.out.println("1. 이름\t2.휴대폰번호\t3.주소");
					act = NumCheck(); // 변경목록선택

					if (act == 1) {// 이름변경
						System.out.println("변경할 이름을 입력해주세요. ");
						String cname = strCheck();; // 변경이름입력
						sql = "update customer set cname='" + cname + "' where cnum=" + cnum;
						stmt.executeUpdate(sql); // db데이터 변경
						data.get(index).cname = cname; // 객체 데이터변경
						System.out.println(cname + "으로 변경 완료되었습니다.");
					}

					else if (act == 2) {// 휴대폰번호변경
						System.out.println("변경할 휴대폰번호를 입력해주세요. ");
						String cphonenum = strCheck(); // 변경번호입력
						sql = "update customer set cphonenum='" + cphonenum + "' where cnum=" + cnum;
						stmt.executeUpdate(sql); // db데이터 변경
						data.get(index).cphonenum = cphonenum; // 객체 데이터변경;
						System.out.println(cphonenum + "으로 변경 완료되었습니다.");
					} else if (act == 3) {// 주소변경
						System.out.println("변경할 주소를 입력해주세요. ");
						String address = strCheck();// 변경주소입력
						sql = "update customer set address='" + address + "' where cnum=" + cnum;
						stmt.executeUpdate(sql);// db데이터 변경
						data.get(index).address = address; // 객체 데이터변경;
						System.out.println(address + "으로 변경 완료되었습니다.");
					} else {// 모든 번호가 아니라면
						System.out.println("선택된 모드가 아닙니다. 재입력해주세요!");
						continue;
					}
				} 
				// [고객정보삭제]
				else if (act == 3) {
					System.out.println("- - - - - - - - - - -회원탈퇴 모드- - - - - - - - - - -");
					System.out.println("본인확인을 위해 고객번호를 입력해주세요. ");

					int cnum = NumCheck(); // 고객번호 입력

					// 정보에 고객번호가 일치하지않다면
					if(!cnumCom(data, cnum)) {//함수호출 -> 고객번호가 없으면 false반환
						System.out.println("고객번호가 일치하지 않습니다. 정보변경 모드 종료됩니다.");
						continue; // 프로그램 처음으로 이동
					}
					// 함수호출 -> 고객대상의 index 반환
					int index = cnumIndex(data,cnum); 

					data.remove(index);// 회원탈퇴된 데이터삭제
					sql = "delete from customer where cnum="+cnum;
					stmt.executeLargeUpdate(sql);
					System.out.println("회원 탈퇴가 완료 되었습니다.\n\n");
				}
				// [고객목록출력]
				else if (act == 4) { 
					System.out.println("==========================고객목록==========================");
					for (int i = 0; i < data.size(); i++) {
						System.out.println(data.get(i)); // 고객별 출력
						System.out.println();
					}
					System.out.println("========================================================\n\n");
				} 
				// [고객검색]
				else if (act == 5) {
					System.out.println("- - - - - - - - - - -고객정보검색 모드- - - - - - - - - - -");
					System.out.println("본인확인을 위해 고객번호를 입력해주세요. ");

					int cnum = NumCheck(); // 고객번호 입력

					// 정보에 고객번호가 일치하지않다면
					if(!cnumCom(data, cnum)) {//함수호출 -> 고객번호가 없으면 false반환
						System.out.println("고객번호가 일치하지 않습니다. 정보변경 모드 종료됩니다.");
						continue; // 프로그램 처음으로 이동
					}
					// 함수호출 -> 대상의 index 반환
					int index = cnumIndex(data,cnum); 

					sql = "select * from customer where cnum=" + cnum;
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						System.out.println("성명: " + rs.getString("cname") + "\t" + "휴대전화: " + rs.getString("cphonenum")
						+ "\t" + "주소: " + rs.getString("address"));
						System.out.println();
					}
				}
				// [프로그램 종료]
				else {
					System.out.println("\n- - - - - - - - - - -프로그램 종료- - - - - - - - - - -");
					System.out.println("이용해 주셔서 감사드립니다. 좋은 하루 보내세요!\n\n");
					break;
				}

			} // while 프로그램종료
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { // 오류로인해 실행이 되지 않았다면 닫지않음
				if (!(conn == null)) {
					conn.close();
				}
				if (!(stmt == null)) {
					stmt.close();
				}
				if (!(rs == null)) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}//main종료

}
