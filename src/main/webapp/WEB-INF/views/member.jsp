<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="day7.Acorn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
border: 1px solid black;
margin: 0 auto;
width: 300px;
border-collapse: collapse;
text-align: center;
}
td{
border: 1px solid black;

}
</style>
</head>
<body>
<% Acorn acorn =  (Acorn)request.getAttribute("acorn"); %>
<form action="/day7/update" method="post">
<table>
<caption>에이콘 학생조회</caption>
	<tr>
	<td>아이디</td>
	<td><input type="Text" name="id" value="<%=acorn.getId() %>"></td>
	</tr>
	<tr>
	<td>비밀번호</td>
	<td><input type="Text" name="pw" value="<%=acorn.getPw() %>"></td>
	</tr>
	<tr>
	<td>이름</td>
	<td><input type="Text" name="name" value="<%=acorn.getName() %>"></td>
	</tr>
	<tr>
		<td colspan="2"><button>변경</button> </td>
	</tr>
</table>
</form>
</body>
</html>