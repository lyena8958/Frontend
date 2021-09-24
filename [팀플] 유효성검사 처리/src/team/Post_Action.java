package team;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.comments.CommentsDAO;
import model.comments.CommentsVO;

public class Post_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		// VO DAO 인스턴스화
		CommentsVO commentVO = new CommentsVO();
		CommentsDAO commentDAO = new CommentsDAO();
		
		
		// DAO수행 데이터 SET
		commentVO.setC_post(Integer.parseInt(request.getParameter("c_post")));
		
		
		// post_ctrl -> post (단일 포스트)
	    ArrayList<CommentsVO> CommentDatas = commentDAO.SelectPost(commentVO);
	    request.setAttribute("CommentDatas", CommentDatas);
	    
	    // 페이지 전송설정
	    forward.setRedirect(false); // forward
	    forward.setPath("post.pdo"); // post Control에게 전달
		
		
		return forward;
	}

}
