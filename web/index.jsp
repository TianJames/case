<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>首页</title>
</head>
<style type="text/css">
	*{
		margin :0;
		padding: 0;
	}
	a{
		width: 500px;
		height: 150px;
		margin:0 auto 5px;
		text-decoration:none;
		font-size: 50px;
		display: block;
		text-align: center;
		color: blue;

	}

</style>
<body>
	<a href="${pageContext.request.contextPath }/FindUserByPageServlet">查询所有用户信息</a>
</body>
</html>