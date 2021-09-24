package team;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class U_JoinUs_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		
		// VO DAO 인스턴스화
		UserInfoVO userInfoVO = new UserInfoVO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		
		// DAO수행 필요데이터 SET
		userInfoVO.setId(request.getParameter("id"));
		userInfoVO.setPw(request.getParameter("pw"));
		
		// 유저정보 받아오기
	    UserInfoVO userInfoData = userInfoDAO.SelectOne(userInfoVO);
		
	    // 로그인 실패 - 스크립트 수행(안내창 출력 및 뒤로가기)
	    if(userInfoData == null) {
	    	response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인에 실패하셨습니다. 아이디 혹은 비밀번호를 확인해주세요.');  history.go(-1); </script>");
			return null; // 전송페이지가 없으므로, null처리
	    }
	    
	    // 로그인 성공 - session 등록
	    HttpSession session = request.getSession();
		session.setAttribute("userInfoData", userInfoData);
	    // 페이지 전송설정
	    forward.setRedirect(false); // forward
	    forward.setPath("Index.jsp"); // post Control에게 전달
		
		
		return forward;
	}

}
