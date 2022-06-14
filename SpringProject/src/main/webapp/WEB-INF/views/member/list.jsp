<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp4/list.jsp</title>
</head>
<body>
<%
//session "id" 가져오기
String id=(String)session.getAttribute("id");
// 세션값이 없으면 => loginForm.jsp이동
if(id==null){
	response.sendRedirect("loginForm.jsp");
}else{
	if(!(id.equals("admin"))){
		response.sendRedirect("main.jsp");
	}
}


%>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>가입날짜</td></tr>
<%
//while(rs.next()){
	%>
	<tr><td><%//rs.getString("id") %></td><td><%//rs.getString("pass") %></td>
	    <td><%//rs.getString("name") %></td><td><%//rs.getTimestamp("date") %></td></tr>
	<%
//}
%>
</table>
</body>
</html>