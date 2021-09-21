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
		<a href="main.do"><img id="logo" alt="로고" src="img/LOGO.png"></a>
		
		<!-- [커스텀태그] 로그인/아웃 -->
		<mytags:login_out />
		<hr>
		
		<!-- [커스텀태그] 댓글달기 -->
		<mytags:mem type="msgAdd"/>
		
		<br> <br>
		<h2>댓글 목록</h2>
		<br>

		<!-- index 별 변수-->
		<c:set var="index" value="0"/>
		
		<!-- 댓글목록 출력 -->
		<c:forEach var="msgData" items="${msgDatas}">
			<c:set var="msg" value="${msgData.msg}" />
			<a id="like" href="msgUpdate.do?&mnum=${msg.mnum}&userID=${msg.userID}&msg=${msg.msg}&replyCnt=${msg.replyCnt}&likeCnt=${msg.likeCnt+1}&mcnt=${mcnt}">♥</a>
			<span id="guest">${msg.userID} 작성    <span id="msgCnt">좋아요 ${msg.likeCnt} ─ 댓글 ${msg.replyCnt}</span></span>
			
			
			<!-- [커스텀태그] 본인 댓글 UD기능 추가 -->
			<mytags:mem type="msgUD" msgID="${msg.userID}" index="${index}"  mnum="${msg.mnum}"/>
			
			
		<div class="cmt_contents">
			<span id="message"> 
				<span id="msgData"> 
					<span id="msgContent${index}">${msg.msg}</span> 
						<span>
							<form action="msgUpdate.do" method="post" class="Update form">
								<input type="hidden" name="mnum" value="${msg.mnum}"> 
								<input type="hidden" name="userID" value="${userData.userID}">
								<input type="hidden" name="mcnt" value="${mcnt}"> 
								<input type="hidden" id="msg${index}" class="text" name="msg" value="${msg.msg}"> 
								<input type="hidden" id="msgSubmit${index}" value="수정하기">
							</form>
						</span> 
					<span id="msgInfo"> [${msg.datetime}]  </span>
				</span>
			</span>
		</div>
	
	
	
	<!-- 리플 반복문출력 -->
			<c:forEach var="replyList" items="${msgData.replyList}">
			
				<!-- 리플 회원 아이디 -->
				<span id="ReGuest">└ ${replyList.userID} 작성</span>


				<!-- [커스텀태그] 본인 리플 UD기능 추가 -->
				<mytags:mem type="replyUD" index="${index}" replyID="${replyList.userID}" mnum="${replyList.mnum}" rnum="${replyList.rnum}"/>


				<div class="cmt_contents" id="replyData">
					<span id="replyData"> 
						<span id="replyContent${index}">${replyList.rmsg}</span>
						<span>
							<form action="replyUpdate.do" method="post" class="Update form">
								<input type="hidden" name="rnum" value="${replyList.rnum}">
								<input type="hidden" name="userID" value="${userData.userID}">
								<input type="hidden" name="mcnt" value="${mcnt}">
								<input	type="hidden" id="rmsg${index}" class="text" name="rmsg" value="${replyList.rmsg}">
								<input type="hidden" id="reSubmit${index}" value="수정하기">
							</form>
						</span>
					 <span id="replyInfo"> [${replyList.datetime}]</span>
					</span>
				</div>
			<c:set var="index" value="${index+1}"/>
			</c:forEach>
			<br><br><br><br>
		</c:forEach>


		<a href="main.do?mcnt=${mcnt+1}">더보기</a> <br> <br> <br>
		<br>
		<hr class="dashHR">
		<h4>회원목록</h4>
		<ol>
			<c:forEach var="mem" items="${userDatas}">
				<li><a href="main.do?user=${mem.userID}&mcnt=${mcnt}">${mem.userName}
						님</a></li>

			</c:forEach>
		</ol>
		<br><br><br><br><br><br>
	</div>


	<!-- 광고 파트 ^^77 -->
	<div id="ad">
		<p>광고배너</p>
		<ul id="adAdd">
			<!-- ajax로 데이터 불러옴 -->
		</ul>
	</div>



</body>

</html>