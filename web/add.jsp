<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>add</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
		.first{
			
			text-align:center;
		}
		.button{
			text-align:center;

		}

	</style>
</head>
<body>
<form class="container" action="${pageContext.request.contextPath}/UserAddServlet" method="post">
	<div>
		<h1 class="first">
			添加联系人页面
		</h1>
		
	</div>
  <div class="form-group">
    <label>姓名</label>
    <input type="text" class="form-control" name="name" placeholder="请输入姓名">
  </div>
  <label >性别</label>
   <div class="radio">
      
	  <label>
	    <input type="radio"  name="gender" value="男" checked>
	    男
	  </label>
	  <label>
	    <input type="radio"  name="gender" value="女">
	   女
	  </label>
</div>
  <div class="form-group">
    <label >年龄</label>
    <input type="text" class="form-control" name="age" placeholder="请输入年龄">
  </div>
  <div>
  	 <label>籍贯</label>
		  <select class="form-control" name="address">
			  <option>山西</option>
			  <option>河南</option>
			  <option>山东</option>
		  </select>
   </div>
  <div class="form-group">
    <label>QQ</label>
    <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码">
  </div>
  <div class="form-group">
    <label>email</label>
    <input type="email" class="form-control" name="email" placeholder="请输入邮箱地址">
  </div>
  <div class="button">

    <button type="submit" class="btn btn-primary" >提交</button>
     <button type="reset" class="btn btn-default">重置</button>
      <a href="${pageContext.request.contextPath}/FindUserByPageServlet"><button type="button" class="btn btn-default">返回</button> </a>

  </div>
</form>

<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</body>
</html>