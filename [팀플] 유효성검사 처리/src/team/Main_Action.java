package team;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.comments.CommentsDAO;
import model.comments.CommentsVO;

public class Main_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		// VO DAO 인스턴스화
		CommentsVO commentVO = new CommentsVO();
		CommentsDAO commentDAO = new CommentsDAO();
		
		// 전체 댓글 목록 전송
	    ArrayList<CommentsVO> CommentDatas = commentDAO.SelectAll();
	    request.setAttribute("CommentDatas", CommentDatas);
	    
	    // 페이지 전송설정
	    forward.setRedirect(false); // forward
	    forward.setPath("main.pdo"); // post Control에게 전달
		
		
		return forward;
	}

}
