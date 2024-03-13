<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="day7.Acorn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/day7/css/list.css" type="text/css" rel="stylesheet">
</head>
<body>
<form action="/day7/delete" method="post">
<table>
<tr>
<td>아이디</td>
<td>비번</td>
<td>이름</td>
</tr>
<%
ArrayList<Acorn> list = (ArrayList<Acorn>)request.getAttribute("list");

for(Acorn a : list){
%>
<tr>
<td><%=a.getId() %></td>
<td><%=a.getName() %></td>
<td><%=a.getPw() %></td>
<td> <button name="id" value="<%=a.getId() %>">삭제</button> </td>
</tr>
<%
}
%>
</table>
</form>
</body>
</html>