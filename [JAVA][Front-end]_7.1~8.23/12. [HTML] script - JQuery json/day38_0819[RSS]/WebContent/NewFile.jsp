<!--language="java" == 자바 코드를 넣을 수 있다. (페이지에 들어가는 언어는 자바 외에는 사용불가하다.) -->
<!-- 3번라인에 빨간줄이 뜨면 -> 다이나믹 프로젝트 파일 -> Propertied - java bulid path -> 라이브러리 -> add 라이브러리 -> Server Runtime -> Apply -> Finish -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!-- 6~17번 라인은 HTML 양식과 같다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간을 출력하는 화면</title>
</head>
<body>

	<h1>현재시간 :<%=new Date() %></h1>

</body>
</html>