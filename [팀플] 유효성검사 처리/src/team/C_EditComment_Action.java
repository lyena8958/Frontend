package team;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.comments.CommentsDAO;
import model.comments.CommentsVO;

public class C_EditComment_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		// VO DAO �ν��Ͻ�ȭ
	    CommentsVO commentVO = new CommentsVO();
	    CommentsDAO commentDAO = new CommentsDAO();
	    
	    
	    // DAO���� �ʿ䵥���� SET
	    commentVO.setCment(request.getParameter("cment"));
	    commentVO.setCnum(Integer.parseInt(request.getParameter("cnum")));
	    
	    
	    //DAO ����
	    // ��� ���� �Ϸ�
	    if (commentDAO.UpdateDB(commentVO)) {
	    	forward.setRedirect(true); // sendRedirect
	    	forward.setPath("selectOne.pdo"); // post ��Ʈ�ѷ����� ������ ��û(ShowList(���� �Խù�)�������� �̵��ϱ� ����)
	    }
	    // �ݿ� ���� -> ���� ����
	    else {
	    	try {
				throw new Exception("C_EditComment_Action ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    return forward;
	}

}
