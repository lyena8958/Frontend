package day25;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model_student.StudentDAO2;
import model_student.StudentVO;

public class Test1 {

	public static void main(String[] args) {
		// 실제 현업에 이용하듯이 실습
		
		Scanner sc = new Scanner(System.in);
		// 사용자의 요청을 받을 스캐너 객체
		
		StudentDAO2 dao = new StudentDAO2();
		// student 테이블과 DB연동하는 객체
		
		Random rand = new Random();
		// 점수를 랜덤으로 생성하는 객체
		
		StudentVO vo = new StudentVO();
		// DAO의 인자로 사용하는 객체 (CRUD 전달할 객체)
		
		while(true) {

			System.out.println("1.입력 2.변경 3.삭제 4.검색 5.목록출력 6.종료");
			int act =sc.nextInt();
			if(act==1) {
				System.out.println("이름입력");
				String name = sc.next();
				int score1 =  rand.nextInt(101);
				int score2 =  rand.nextInt(101);
				vo.setName(name);
				vo.setScore1(score1);
				vo.setScore2(score2);
				dao.insertStu(vo);
			}
			else if(act==2) {//☆정보변경 --> 마이페이지
				System.out.println("정보변경");
				System.out.println("로그인-인증처리");
				System.out.println("바꿀 학생의 번호입력"); // 로그인(인증)
				int num = sc.nextInt(); // 로그인입력
				vo.setNum(num);
				vo = dao.selectOne(vo); //로그인을 해서 마이페이지에 보여주는 역할
				// 로그인인증 -> 마이페이지 -> 정보변경
				
				// dao.selectOnt(vo)에서 로그인이 안되어 null로 반환받았다면 
				if(vo==null) {
					System.out.println("검색결과가 없습니다!");
					vo = new StudentVO(); // vo초기화(안해주면 null로 고정되기 때문에 타 모드에서 오류뜸)
					continue;
				}
				
				System.out.println("마이페이지: "+vo);
				System.out.println("1.이름 2.성적");
				act= sc.nextInt();
				if(act==1) {
					System.out.println("새로운이름입력");
					String name = sc.next();
				}
				else { //성적
					int score1 = 0;
					int score2 = 0;
					System.out.println("점수리셋완료");
					vo.setScore1(score1);
					vo.setScore2(score2);
				}
				dao.updateStu(vo);
				
			}
			else if(act==3) { //삭제
				//  1) 회원탈퇴	- 일반적임
				/*System.out.println("정보삭제");
				System.out.println("로그인-인증처리");
				System.out.println("삭제할 학생의 번호입력"); // 로그인(인증)
				int num = sc.nextInt(); // 로그인입력
				vo.setNum(num);
				vo = dao.selectOne(vo); //로그인을 해서 마이페이지에 보여주는 역할
				
				if(vo==null) {
					System.out.println("검색결과가 없습니다!");
					vo = new StudentVO(); // vo초기화(안해주면 null로 고정되기 때문에 타 모드에서 오류뜸)
					continue;
				}
				
				// 로그인인증->마이페이지 ->회원탈퇴
				System.out.println("마이페이지: "+vo);
				System.out.println("회원탈퇴를 진행합니다...");
				dao.deleteStu(vo);
				System.out.println("회원탈퇴완료!");
			}
			else if(act==4) {
				System.out.println("학생번호입력");
				int num = sc.nextInt();
				vo.setNum(num);
				vo = dao.selectOne(vo);
				
				if(vo==null) {
					System.out.println("검색결과없음!");
					vo = new StudentVO(); 
					// 결과가 없을 때마다 null처리로 되어 다음 수행시 오류가발생하니 재초기화
					continue;
				}

				System.out.println("검색결과: "+vo);*/
				
				//이렇게는 잘 사용안함 ->많이 사용하는것은템플릿에서 할예정
				// 2) 관리자-데이터삭제(관리차원) 광고성 등
				System.out.println("삭제할 학생의 번호입력");
				int num = sc.nextInt();
				vo.setNum(num);
				dao.deleteStu(vo);
				// delete()의 수행결과를 반환받을수있어야한다!!
			}
			else if(act==5) {
				System.out.println("==학생목록==");
				ArrayList<StudentVO> datas = dao.selectAll(vo);
				for(StudentVO v: datas) {
					System.out.println(v);
				}
				System.out.println("===============");
						
			}
			else if(act==6) {
				break;
			}
			else {
				System.out.println("범위외입력!");
			}
		}



	}//main

}


