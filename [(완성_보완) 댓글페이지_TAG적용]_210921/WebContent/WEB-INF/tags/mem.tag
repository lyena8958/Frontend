<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="type" required="true" %>
<%@ attribute name="msgID" %>
<%@ attribute name="replyID" %>
<%@ attribute name="mnum" %>
<%@ attribute name="rnum" %>
<%@ attribute name="index" %>

<c:if test="${userData!=null}">
	<c:choose>
	
		<c:when test="${type=='msgAdd'}">
			<form action="msgInsert.do" method="post" class="form">
				<input type="hidden" name="userID" value="${userData.userID}">
				<input type="hidden" name="mcnt" value="${mcnt}"> 
				<input type="text" name="msg" placeholder="내용작성"> 
				<input type="submit" value="댓글달기">
			</form>
		</c:when>


		<c:when test="${type=='msgUD'}">
			<c:if test="${userData.userID==msgID}">
				<button type="button" onClick="msgEdit(${index})">수정</button>
				<a onClick="del()" href="msgDelete.do?mnum=${mnum}&mcnt=${mcnt}"> 
				<input type="button" value="삭제" >
				</a>
			</c:if>
				<br>
				<form action="replyAdd.do" method="post" class="form">
					<input type="hidden" name="mnum" value="${mnum}"> 
					<input type="hidden" name="userID" value="${userData.userID}"> 
					<input type="hidden" name="mcnt" value="${mcnt}"> 
					<input type="text" name="rmsg"> 
					<input type="submit" value="리플달기">
				</form>
		</c:when>


		<c:when test="${type=='replyUD'}">
			<c:if test="${userData.userID==replyID}">
				<button type="button" onClick="reEdit(${index})">수정</button>
				<a onClick="del()" href="replyDelete.do?rnum=${rnum}&mnum=${mnum}&mcnt=${mcnt}">
					<input type="button" value="삭제">
				</a>
			</c:if>
		</c:when>


	</c:choose>
</c:if>
