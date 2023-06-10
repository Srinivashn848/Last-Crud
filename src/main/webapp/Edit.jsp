<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="student">
Id:<form:input path="id"/><br>
Name:<form:input path="name"/><br>
Email:<form:input path="email"/><br>
Gender:<form:radiobutton  path="gender"/><br>
<button>Update</button>
<button type="reset">Cancel</button>
</form:form>
</body>
</html>