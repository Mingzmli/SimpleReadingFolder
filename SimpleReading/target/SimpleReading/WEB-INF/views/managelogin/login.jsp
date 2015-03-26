<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link href="../css/body.css" rel="stylesheet" type="text/css"
	media="all">
<script type="text/javascript">
	function _hyz() {
		/*
		1. 获取<img>元素
		2. 给它的src指向为/tools/VerifyCodeServlet
		 */
		var img = document.getElementById("imgVerifyCode");
		// 需要给出一个参数，这个参数每次都不同，这样才能干掉浏览器缓存！
		img.src = "${pageContext.request.contextPath}/VerifyCodeServlet?a="
				+ new Date().getTime();
	}
</script>
</head>
<body>
	<div>

		<form action="${pageContext.request.contextPath}/simplelsy3618simplelogin/login"
			method="post">
			<table>
				<tbody>
					<tr>
						<td>username:</td>
						<td><input type="text" name="username">${userInfo.username}</td>
					</tr>
					<tr>
						<td>password:</td>
						<td><input type="text" name="password">${userInfo.password}</td>
					</tr>
					<tr>
						<td>verifycode:</td>
						<td><input type="text" name="verifyCode" /><br /> <img
							src="${pageContext.request.contextPath}/VerifyCodeServlet"
							id="imgVerifyCode" /> <a href="javascript:_hyz()">换一张</a></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="submit" name="submit"></td>
					</tr>
			</table>
			</tbody>
		</form>

	</div>
</body>

</html>