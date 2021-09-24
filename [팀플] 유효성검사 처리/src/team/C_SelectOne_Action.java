package team;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.comments.CommentsDAO;
import model.comments.CommentsVO;
import model.post.PostVO;

public class C_SelectOne_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// view���� 3���� ������ ��� ����
        // �� ���� post  �� ���ƿ� ��  �� 1�� ��۸��  ---- ��, ��� post��Ʈ�� ���Լ� ����

		ActionForward forward = new ActionForward();

		// �� singlePost
		request.setAttribute("singlePost", request.getAttribute("singlePost"));

		// �� like
	      request.setAttribute("likeInfo", request.getAttribute("likeInfo"));

	      
	    // �� postOne_comments
	    // post ��Ʈ�ѿ��� ���� �Խù� ������ �޾ƿ���,
	    // DAO�� ���� �ش� �Խù��� ��� ����� AL�� �޾ƿ�  
	      
		  // VO DAO �ν��Ͻ�ȭ
	    CommentsVO commentVO = new CommentsVO();
	    CommentsDAO commentDAO = new CommentsDAO();
	    
	      // DAO���� �ʿ䵥���� SET
	    commentVO.setC_post(((PostVO)request.getAttribute("singlePost")).getPnum());

		  // DAO����
	    ArrayList<CommentsVO> postOne_comments = commentDAO.SelectPost(commentVO);
	      
	      // �� request ����
	    request.setAttribute("postOne_comments", postOne_comments);
		
	    
		// ������ ���ۼ���
		forward.setRedirect(false); // forward
		forward.setPath("ShowPost.jsp");


		return forward;
	}
	
}
