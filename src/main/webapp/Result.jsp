<%@page import="mvc.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${success}</h1>
<%List<Student> list=(List<Student>)request.getAttribute("list"); %>
<table border="1">
<tr>
<th> Id</th>
<th> Name</th>
<th> Email</th>
<th> Mobile</th>
<th> Gender</th>
<th> Date Of Birth</th>
<th> Age</th>
<th>Delete</th>
<th>Edit</th>
</tr>

<%for(Student stud:list){ %>
<tr>
<th><%=stud.getId() %></th>
<th><%=stud.getName() %></th>
<th><%=stud.getEmail() %></th>
<th><%=stud.getMobile()%></th>
<th><%=stud.getGender() %></th>
<th><%=stud.getDob() %></th>
<th><%=stud.getAge() %>
<th><a href="delete?id=<%=stud.getId() %>"><button>Delete</button></a>
<th><a href="edit?id=<%=stud.getId() %>"><button>Edit</button></a>
</tr>
<%} %>
</table>
</body>
</html>