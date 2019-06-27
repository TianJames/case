<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>list</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        .container{
            text-align: center;

        }
        .text{
            font-size: 50px;
            color: blue;
        }

        .table{

            border:1px;
            margin: 0 auto;
        }
        .first{
            background: pink;
            height: 30px;

        }
        .left{
            float: left;
        }
        .right{
            float: right;
        }



    </style>
    <script type="text/javascript">

            function deleteUser(id) {
                if (confirm("您确定要删除吗？")){
                    location.href="${pageContext.request.contextPath}/DelUserServlet?id="+id;
                }

            }

            window.onload = function(){
                document.getElementById("selected").onclick=function(){
                    if (confirm("您确定要删除所选条目吗？")){
                        var s = document.getElementsByName("uid");
                        var flag=false;
                        for (var i = 0; i <s.length ; i++) {
                            if ( s[i].checked ){
                                flag=true;
                                break;
                            }
                        }
                        if (flag){
                            document.getElementById("form").submit();
                        }

                    }

                }
                document.getElementById("firstCb").onclick=function(){
                    var s = document.getElementsByName("uid");
                    for (var i = 0; i <s.length ; i++) {
                        s[i].checked = this.checked;
                    }

                }
            }



    </script>
</head>
<body>
<div class="container">
    <div class="text">
        <h1>用户信息列表</h1>
    </div>
    <div>
        <form class="form-inline left">
            <div class="form-group">
                <label>姓名</label>
                <input type="text" class="form-control"  placeholder="请输入姓名">
            </div>
            <div class="form-group">
                <label >籍贯</label>
                <input type="email" class="form-control"  placeholder="请输入籍贯">
            </div>
            <div class="form-group">
                <label >邮箱</label>
                <input type="email" class="form-control"  placeholder="请输入邮箱地址">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div class="right">
        <a href="${pageContext.request.contextPath }/add.jsp"><button type="button" class="btn btn-primary">添加联系人</button></a>

        <a href="javascript:void(0); " id="selected"><button type="button" class="btn btn-primary">删除选中</button></a>
    </div>

    <form action="${pageContext.request.contextPath}/delSelectedServlet" method="post" id="form">
        <table class="table" border="1" align="center" cellspacing="0" cellpadding="0">
            <tr  class="tr first">
                <td>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="firstCb"  >
                        </label>
                    </div>
                </td>
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>年龄</td>
                <td>籍贯</td>
                <td>QQ</td>
                <td>邮箱</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${pb.list}" var="user" varStatus="c">

            <tr  class="tr">
                <td>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="${user.id}" name="uid">
                        </label>
                    </div>
                </td>
                <td>${c.count }</td>
                <td>${user.name }</td>
                <td>${user.gender }</td>
                <td>${user.age }</td>
                <td>${user.address }</td>
                <td>${user.qq }</td>
                <td>${user.email }</td>
                <td><a href="${pageContext.request.contextPath }/findUserServlet?id=${user.id}"><button type="button" class="btn btn-default">修改</button></a>
                    <a href="javascript:deleteUser(${user.id})"><button type="button" class="btn btn-default">删除</button></a></td>
            </tr>
            </c:forEach>
    </form>
    </table>
    <nav class="container">
        <ul class="pagination">
            <c:if test="${pb.currentPage==1}">
                <li class="disabled">
            </c:if>
            <c:if test="${pb.currentPage!=1}">
                <li>
                </c:if>

                <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage-1}&rows=5" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <c:if test="${pb.currentPage==i}">
                    <li class="active"><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                </c:if>
                <c:if test="${pb.currentPage!=i}">
                    <li><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${pb.currentPage == pb.totalPage}">
                <li class="disabled">
            </c:if>
            <c:if test="${pb.currentPage != pb.totalPage}">
                <li>
            </c:if>

                <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage+1}&rows=5" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 20px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
            </span>
        </ul>
    </nav>
</div>

</body>
</html>