package team;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class U_DeleteUser_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		// VO DAO 인스턴스화
		UserInfoVO userInfoVO = new UserInfoVO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		
		// DAO수행 필요데이터 SET
		userInfoVO.setId(request.getParameter("id"));
		
		// DAO수행
		   //회원탈퇴 처리 → 유저 세션remove
		if(userInfoDAO.DeleteDB(userInfoVO)) {
			
			HttpSession session = request.getSession();
			session.removeAttribute("userInfoData");			
		}
		  // 실패시 - 오류 수행
		else {
			try {
				throw new Exception("DeleteUser_Action DB 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 페이지 전송설정
		forward.setRedirect(true); // forward
		forward.setPath("Index.jsp");


		return forward;
	}

}
