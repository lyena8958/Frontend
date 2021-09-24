package team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class U_SignUp_Action implements Action {
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		// VO DAO 인스턴스화
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoVO userInfoVO = new UserInfoVO();
		
		// DAO수행 필요데이터 SET
		userInfoVO.setId(request.getParameter("id"));
		userInfoVO.setPw(request.getParameter("pw"));
		userInfoVO.setName(request.getParameter("name"));
		
		// DAO수행		
	     // 가입 성공 - 스크립트 수행(안내창 출력 및 페이지 이동)
		if(userInfoDAO.InsertDB(userInfoVO)) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			// 자바스크립트를 이용하여 알림창 뒤, Login.jsp 페이지 이동
			out.println("<script>alert('회원가입이 정상적으로 반영되었습니다.');  location.href='Login.jsp'; </script>");
		}
		 // 가입 실패시 - 오류 수행
		else {
			try {
				throw new Exception("SignUp_Action DB 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
	    
	    // 전송페이지가 없으므로, null반환 처리
		return null;
	}
	

	
	
	
}
