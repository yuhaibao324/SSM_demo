<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form:form  modelAttribute="user" action="SpringMVC/action" method="post">
username:<form:input path="username" />
		<!--  input type="text" name="username"/><br/><br/-->
password:<form:password path="password" />
		<!--  input type="password" name="password"/-->
		<input type="submit" value="GO" />
	</form:form>
 

</body>
</html>