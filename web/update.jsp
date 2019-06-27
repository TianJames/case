<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>update</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-1.12.4.js"></script>
	<script src="js/bootstrap.min.js"></script>
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
	<div class="first">
		<h1>修改联系人</h1>
	</div>
	<div class="container">
		<form action="${pageContext.request.contextPath }/UpdateUserServlet" method="post">
		<input type="hidden" name="id" value="${user.id }">
			<div class="form-group">
				<label>姓名</label>
				<input type="text" name="name" value="${user.name}" class="form-control" readonly="readonly" placeholder="请输入姓名">
			</div>
			<label>性别</label>
			 <div class="radio">
      			<c:if test="${user.gender == '男' }">
      			<label><input type="radio" name="gender"  value="男" checked>男		</label>	  
				    	  
			    	<label><input type="radio" name="gender"  value="女"> 女	</label>	
			    </c:if>		
			    <c:if test="${user.gender == '女' }">	  
				  <label><input type="radio" name="gender"  value="男" >男		</label>	  
				    	  
			    	<label><input type="radio" name="gender"  value="女" checked> 女	</label>	
			    </c:if>			  
			</div>
			<div class="form-group">
				<label>年龄</label>
				<input type="text" name="age" value="${user.age}" class="form-control" placeholder="请输入年龄">
			</div>
			<div>
			  	 <label>籍贯</label>
					  <select class="form-control" name="address">
					  <c:if test="${user.address == '山西' }">
						  <option selected="selected" value="山西">山西</option>
						  <option value="河南">河南</option>
						  <option value="山东">山东</option>
					  </c:if>
					  <c:if test="${user.address == '河南' }">
						  <option  value="山西">山西</option>
						  <option value="河南" selected="selected">河南</option>
						  <option value="山东">山东</option>
					  </c:if>
					  <c:if test="${user.address == '山东' }">
						  <option  value="山西">山西</option>
						  <option value="河南">河南</option>
						  <option value="山东" selected="selected">山东</option>
					  </c:if>
					  </select>
   			</div>
			<div class="form-group">
				<label>QQ</label>
				<input type="text" name="qq" value="${user.qq}" class="form-control" placeholder="请输入QQ号码">
			</div>
			<div class="form-group">
				<label>email</label>
				<input type="text" name="email" value="${user.email}" class="form-control" placeholder="请输入邮箱地址">
			</div>
			<div class="button">
				<a href="${pageContext.request.contextPath }/UpdateUserServlet"><button type="submit" class="btn btn-primary" >提交</button></a>
				<a><button type="reset" class="btn btn-default" >重置</button></a>
				<a href="${pageContext.request.contextPath }/FindUserByPageServlet"><button type="button" class="btn btn-default" >返回</button></a>
			</div>
		</form>
	</div>
</body>
</html>