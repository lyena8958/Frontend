<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
<ul id="top_Login">
<li>

<c:if test="${userData!=null}">	
		<h5 id="block">${userData.userName}(${userData.userID}) 안녕!!</h5>
		<a href="logout.do"><button type="button">로그아웃</button></a>
		<a href="main.do?user=${userData.userID}"><button type="button">내 글보기</button></a>
</c:if>

<c:if test="${userData==null}">
			<form action="login.do" method="post">
			<input type="hidden" name="mcnt" value="${mcnt}">
			<input type="text" name="userID" placeholder="아이디">
			<input type="password" name="userPW" id="block" placeholder="비밀번호">
			<input type="submit" value="로그인">
			<a onClick="signUpMove()"><button type="button">회원가입</button></a>
			</form>
</c:if>


</li>
</ul>
</div>