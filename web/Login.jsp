<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>list</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>

<script type="text/javascript">
	window.onload = function(){
		
		var oImg = document.getElementById("Img");
		
		oImg.onclick = function(){
			var date = new Date().getTime();
			oImg.src="${pageContext.request.contextPath}/CheckCode?"+date;
			
			
		}
		
	}


</script>
    <style type="text/css">
        .first {
            text-align:center;
        }
        .last{
            height: 80px;
            line-height: 80px;
        }
        .button{
            text-align:center;
        }
    </style>
</head>
<body>
<div class="container">

    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <h1 class="first">管理员登陆</h1>
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" name="username" placeholder="请输入用户名" id="username">
        </div>

        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" name="password" placeholder="请输入密码" id="password">
        </div>
        <div class="form-inline">
            <label for="CheckCode">验证码:</label>
            <input type="text" name="checkCode" class="form-control" placeholder="请输入验证码" id="CheckCode">
            <img src="${pageContext.request.contextPath}/CheckCode" id="Img">
        </div>
        <hr>
        <div class="button">
            <input type="submit" value="登陆" class="btn btn-primary btn-lg" >
        </div>
        <h1 class="first bg-info last">${login_msg }</h1>
    </form>

</div>
</body>
</html>