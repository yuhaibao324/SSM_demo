<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 对Spirng自带表单标签的库的声明 -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
<meta charset="UTF-8">
<title>jstl</title>
</head>

<body>
 
	<form action="/SpringMVC/adduser", method="POST">

		username: <input type="text" name="username" /> 
		<br>
		password: <input type ="password" name="password" />
		<br>
				  <input type="submit" value="提交" />

	</form>
	
 

 
</body>
</html>