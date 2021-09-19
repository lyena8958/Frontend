<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>

<% if(session.getAttribute("userData")!=null){
%>
		<form action="msgInsert.do" method="post">
			<input type="hidden" name="userID" value="${userData.userID}">
			<input type="hidden" name="mcnt" value="${mcnt}">
			<input type="text" name="msg" id="msg" placeholder="내용작성"> 
			<input type="submit" value="댓글달기">
		</form>
<%	
}	
%>