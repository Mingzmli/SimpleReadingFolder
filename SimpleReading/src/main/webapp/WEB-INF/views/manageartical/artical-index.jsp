<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link href="../css/body.css" rel="stylesheet" type="text/css"
	media="all">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/article.js"></script>

</head>
<!--  <div>${articleInfo.content}</div> -->

<script type="text/javascript">

$(document).ready(function() {
	
	$("button[name='btnDelete']").on("click",function(){
		var deleteId = $(this).attr("value");
		var jsonData ={"deleteId":deleteId};	
		$.ajax({
			type : 'POST',
			url : "${pageContext.request.contextPath}/simpleslty6435simpleartical/deleteartical",
			dataType : "json",
		   // contentType : "application/json",
		    cache: false,
			contentType : "text/html",
			//data : JSON.stringify(jsonData),
			data: deleteId,
			success : function(res) {
				alert(res.status);
				window.location.reload();
			},
			error:function(res){
                alert(res);
             }
		});
		
	});

});


</script>

<body>

	<div>
		<a href="${pageContext.request.contextPath}/simpleslty6435simpleartical/addartical" src="Simple Reading">添加文章</a><br/>
		<hr/>
		<a href="${pageContext.request.contextPath}/simpleslty6435simpleartical/list" src="Simple Reading">文章列表</a>
		<br/>
			
	</div>
	<hr/>
	
    <table>
    	<tbody>
    	<c:forEach items="${articleInfos}" var="articleInfo">
    		<tr>
    			<td style="width:500px">${articleInfo.title}</td>
    			<td> <a href="${pageContext.request.contextPath}/simpleslty6435simpleartical/updateartical?id=${articleInfo.id}" src="">修改</a> </td>
    			<td><input type="hidden" name="hdArticleId" value="${articleInfo.id}" /> </td>
    			<td> <button  value="${articleInfo.id}" name="btnDelete">删除</button> </td>
    		</tr>
    	</c:forEach>
    	</tbody>
    </table>
    
</body>

</html>

