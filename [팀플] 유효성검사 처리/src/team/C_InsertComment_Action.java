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
		// view���� �Ķ���͵��� �������ָ�(c_user, c_post, cment)
	    // set�� commentVO�� ����߰�
		
		
		ActionForward forward = new ActionForward();
		
		// VO DAO �ν��Ͻ�ȭ
	    CommentsVO commentVO = new CommentsVO();
	    CommentsDAO commentDAO = new CommentsDAO();
	    
	    
	    // DAO���� �ʿ䵥���� SET
	    commentVO.setCment(request.getParameter("cment"));
	    commentVO.setC_user(request.getParameter("c_user"));
	    commentVO.setC_post(Integer.parseInt(request.getParameter("c_post")));
	    
	    
	    //DAO ����
	    // ��� �߰� �Ϸ�
	    if (commentDAO.InsertDB(commentVO)) {
	    	forward.setRedirect(true); // sendRedirect
	    	forward.setPath("selectOne.pdo"); // post ��Ʈ�ѷ����� ������ ��û
	    }
	    // �ݿ� ���� -> ���� ����
	    else {
	    	try {
				throw new Exception("C_InsertComment_Action ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    return forward;
	}

}
