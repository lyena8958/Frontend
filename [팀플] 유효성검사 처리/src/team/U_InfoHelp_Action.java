package team;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.comments.CommentsDAO;
import model.comments.CommentsVO;
import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class U_InfoHelp_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = new ActionForward();

		// VO DAO 인스턴스화
		UserInfoVO userInfoVO = new UserInfoVO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();


		// ID찾기 --> view 반환 -> 객체 userInfo
		if(request.getParameter("type").equals("id")) {
			// DAO수행 필요데이터 SET
			userInfoVO.setPw(request.getParameter("pw"));
			userInfoVO.setName(request.getParameter("name"));
			
			// DAO수행
			userInfoVO = userInfoDAO.FindID(userInfoVO);
		}
		// PW찾기 --> view 반환 == 객체 userInfo
		else if (request.getParameter("type").equals("pw")) {
			// DAO수행 필요데이터 SET
			userInfoVO.setId(request.getParameter("id"));
			
			// DAO수행
			userInfoVO = userInfoDAO.FindPW(userInfoVO);
		}
		
		
		// view 객체전달 --- findUser
		request.setAttribute("findUser", userInfoVO);

		
		// 페이지 전송설정
		forward.setRedirect(false); // forward
		forward.setPath("FindHelp.jsp");


		return forward;
	}

}
