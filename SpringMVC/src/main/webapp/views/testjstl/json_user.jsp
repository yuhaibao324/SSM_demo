<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json</title>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
	<h2>json数据交互</h2>

<h4>以json字符串的形式传递数据</h4>
	<form>
		username：<input type="text" id="username" value="hello" /><br /> 
		password：<input type="text" id="password" value="123456" /><br /> 
		<input  type="button" value="提交" id="sender">
	</form>

	<!-- 传送Json格式的字符串 -->
	<script>
		$('#sender').click(function() {
			var username = document.getElementById('username').value;
			var password = document.getElementById('password').value;
			//创建js对象
			var user = {
				"username" : username,
				"password" : password
			};

			
			//将js对象转换为json字符串的形式
			var jsonData = JSON.stringify(user);

			//jQuery的异步提交方法
			$.ajax({
				type : "post",//提交方法
				url : "/SpringMVC/jsonUser",//地址
				data : jsonData,//此时传递的为json字符串数据，与下面的属性dataType相对应
				dataType : "json",//预期的服务器响应的类型
				//要传递的数据为json格式的字符串，此时后端将要使用@RequestBody接受json字符串，
				contentType : 'application/json;charset=utf-8',
				/*
				* 	此为回调函数：result是后台响应成功传回的值
				*	返回的是json数据
				*/
				success : function(result) {
					
				}
			});
			alert("提交成功，请在Tomcat控制台查看服务端接收到的数据" );
			 
		});
	</script>
	
	
	
<br><br><br><br>
<hr>
<h4>传送json对象</h4>
 
	<script>
		$('#sender2').click(function() {
			 
			 

			//jQuery的异步提交方法
			$.ajax({
				type : "post",//提交方法
				url : "/SpringMVC/jsonUser2",//地址
				data :{
					"username" : "hello",
					"password" : "123"
				}, //此时传递的是接送对象
				dataType : "json",//预期的服务器响应的类型
				//要传递的数据为json格式的字符串，此时后端将要使用@RequestBody接受json字符串，
				//contentType : 'application/json;charset=utf-8',
				/*
				* 	此为回调函数：result是后台响应成功传回的值
				*	返回的是json数据
				*/
				success : function(result) {
					alert("提交成功，请在Tomcat控制台查看服务端接收到的数据" );
				}
			});
			 
			 
		});
	</script>
	
	<form>
		<input  type="button" value="提交" id="sender2">
	</form>
	
	
	
	
<br><br><br><br>
<hr>
<h2>根据用户id查找信息的简单功能</h2>

	<form class="form-horizontal">
		ID:<input type="text" class="form-control" id="user_id"
			placeholder="请输入用户ID">
		<button type="button" id="select" class="btn btn-default">查找</button>

	</form>
	<div class="panel-body">
		<h2 class="text-danger text-center">
			<!-- 用来显示查找结果 -->
			<span class="glyphicon" id="select-box"></span>
		</h2>
	</div>

	<script type="text/javascript">
	

		$(function() {
			$("#select").click(function() {
				$.ajax({
					url : "/SpringMVC/peopleSelect",
					type : "POST",
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					//向后端传递数据
					data : JSON.stringify({
						id : $("#user_id").val(),
					}),
					//处理后端返回的数据
					success : function(result) {//此时返回来的result为json对象
						//var message = JSON.stringify(result);//转换为json字符串
						
						//获取前端对象的值
						var accountPolicyId = result["name"] +  result["age"];
						$("#select-box").html("查询成功" + accountPolicyId);
					},
					error : function(result) {
						$("#select-box").html("查询失败");
					}
				});
			});
		});
	</script>





</body>
</html>