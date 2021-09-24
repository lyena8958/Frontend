package team;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.comments.CommentsDAO;
import model.comments.CommentsVO;

public class C_InsertComment_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// view에서 파라미터들을 전달해주면(c_user, c_post, cment)
	    // set된 commentVO로 댓글추가
		
		
		ActionForward forward = new ActionForward();
		
		// VO DAO 인스턴스화
	    CommentsVO commentVO = new CommentsVO();
	    CommentsDAO commentDAO = new CommentsDAO();
	    
	    
	    // DAO수행 필요데이터 SET
	    commentVO.setCment(request.getParameter("cment"));
	    commentVO.setC_user(request.getParameter("c_user"));
	    commentVO.setC_post(Integer.parseInt(request.getParameter("c_post")));
	    
	    
	    //DAO 수행
	    // 댓글 추가 완료
	    if (commentDAO.InsertDB(commentVO)) {
	    	forward.setRedirect(true); // sendRedirect
	    	forward.setPath("selectOne.pdo"); // post 컨트롤러에게 페이지 요청
	    }
	    // 반영 실패 -> 오류 수행
	    else {
	    	try {
				throw new Exception("C_InsertComment_Action 오류 발생!");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    return forward;
	}

}
