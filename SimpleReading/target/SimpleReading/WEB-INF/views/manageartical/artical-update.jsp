<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	


<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>KindEditor JSP</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
<link rel="stylesheet" href="../kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="../kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="../kindeditor/plugins/code/prettify.js"></script>
<script>
	KindEditor
			.ready(function(K) {
				var editor1 = K
						.create(
								'textarea[name="content"]',
								{
									cssPath : '../kindeditor/plugins/code/prettify.css',
									uploadJson : '${pageContext.request.contextPath}/simpleslty6435simpleartical/uploadJson?id='+$("#id").val(),
									data:{"id":$("#id").val()},
									fileManagerJson : '../kindeditor/jsp/file_manager_json.jsp',
									allowFileManager : true,
									afterCreate : function() {
										var self = this;
										K.ctrl(document, 13, function() {
											self.sync();
											document.forms['addform'].submit();
										});
										K.ctrl(self.edit.doc, 13, function() {
											self.sync();
											document.forms['addform'].submit();
										});
									}
								});
				prettyPrint();
			});
</script>
</head>
<body>
	<h1>Update Artical</h1>
	<form name="addform" method="POST" action="${pageContext.request.contextPath}/simpleslty6435simpleartical/updateartical">
		
		<table>
		
		  <tr>
				<td></td>
				<td><input type="hidden" id="id" name="id" value="${articleInfo.id}"/></td>
			</tr>
			
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" value="${articleInfo.title}"></td>
			</tr>
			<tr>
				<td></td>
				<td><textarea name="content" cols="100" rows="8"
						style="width: 700px; height: 200px; visibility: hidden;">${articleInfo.content}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="button" value="提交内容" />
					(提交快捷键:Ctrl + Enter)</td>
			</tr>
		</table>



	</form>
</body>
</html>
