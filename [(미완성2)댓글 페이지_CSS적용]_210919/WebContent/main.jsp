<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대댓글 메인페이지</title>
<style>
@import url("css/css.css");
</style>

<!-- jQuery ,ajax -->
<script src="jquery-3.6.0.min.js"></script>
<script src="script.js"></script>

</head>
<body>
	<div id="content">
		<a href="main.do" id="logo"><img alt="로고" src="img/LOGO.png"></a>
		<mytags:login_out />
		<hr>
		<mytags:mem />
		<br>
		<br>
		<h2>댓글 목록</h2>
		<br>


		<!-- 댓글목록 출력 -->
		<c:forEach var="msgData" items="${msgDatas}">
			<c:set var="msg" value="${msgData.msg}" />
			<a
				href="msgUpdate.do?&mnum=${msg.mnum}&userID=${msg.userID}&msg=${msg.msg}&replyCnt=${msg.replyCnt}&likeCnt=${msg.likeCnt+1}&mcnt=${mcnt}">♥</a>
			<span id="guest">${msg.userID} 작성</span>
			<div class="cmt_contents">
				<!-- 리플 C -->
				<!-- <form action="replyAdd.do" method="post">
					<input type="hidden" name="mnum" value="${msg.mnum}">
					<input type="hidden" name="userID" value="${userData.userID}">
					<input type="hidden" name="mcnt" value="${mcnt}">
					<input type="text" name="rmsg">
					<input type="submit" value="리플달기">
		</form>
		<br>
		-->



				<!-- [msg] 댓글내용 - 바로출력하지 않고 회원여부에 따라 출력 == UD기능을 위함 -->
				<!-- 회원 UD기능  댓글 (C는하단에) -->
				<c:if test="${userData != null}">
					<!-- 댓글 작성자 삭제/수정기능 -->
					<c:if test="${userData.userID == msg.userID}">

						<!-- <form action="msgUpdate.do" method="post">
					<input type="hidden" name="mnum" value="${msg.mnum}">
					<input type="hidden" name="userID" value="${userData.userID}">
					<input type="hidden" name="mcnt" value="${mcnt}">
					<input type="text" name="msg" value="${msg.msg}">
					<input type="submit" value="수정하기">
				</form>
				
				<!--삭제버튼 
				<a  class="c1" href="msgDelete.do?&mnum=${msg.mnum}&mcnt=${mcnt}"><input type="button" value="삭제하기"></a>
				 -->

					</c:if>


				</c:if>

				<p id="msg">${msg.msg} 
					<span id="msgInfo">
						| [${msg.datetime}]   좋아요 ${msg.likeCnt} ─ 댓글
						${msg.replyCnt}
					</span>
				</p>

			</div>
	
	<!-- 리플 반복문출력 -->
			<c:forEach var="replyList" items="${msgData.replyList}">
				<!-- 리플 회원 아이디 -->
				<span id="ReGuest">└ ${replyList.userID} 작성</span>
				
				<!-- 작성ID와  로그인한 ID가 일치한 경우 → Update, Delete 기능 제공-->
				<c:if test="${userData.userID == replyList.userID}">
					<button type="button" onClick="Update">수정</button>
					<a	href="replyDelete.do?rnum=${replyList.rnum}&mcnt=${mcnt}&mnum=${replyList.mnum}">
					<input type="button" value="삭제" onClick="del()"></a>
				</c:if>
				<div class="cmt_contents" id="reply">

					<p id="reply">
						<span class="Edit">${replyList.rmsg}</span>
						<span id="replyInfo"> [${replyList.datetime}]</span>
					</p>



				</div>
			</c:forEach>
			<br>
			<br>
		</c:forEach>


		<a href="main.do?mcnt=${mcnt+1}">더보기</a> <br>
		<br>
		<br>
		<br>
		<hr class="dashHR">
		<h4>회원목록</h4>
		<ol>
			<c:forEach var="mem" items="${userDatas}">
				<li><a href="main.do?user=${mem.userID}&mcnt=${mcnt}">${mem.userName}
						님</a></li>

			</c:forEach>
		</ol>
	</div>


	<!-- 광고 파트 ^^77 -->
	<div id="ad">
		<p>광고배너</p>
		<ul id="adAdd">
			<!-- ajax로 데이터 불러옴 -->
		</ul>
	</div>


	<script charset="UTF-8">


</script>
</body>

</html>