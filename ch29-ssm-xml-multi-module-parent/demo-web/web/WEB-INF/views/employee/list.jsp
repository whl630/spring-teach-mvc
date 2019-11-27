<%--
  User: cj
  Date: 2019/11/21
  Time: 09:05
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.js"></script>
    <link href="/static/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<table class="table">
    <tr>
        <th>id</th>
        <th>username</th>
        <th>salary</th>
        <th>hiredate</th>

    </tr>
    <c:forEach items="${list.list}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.username}</td>
            <td>${emp.salary}</td>
            <td>${emp.hiredate}</td>
        </tr>
    </c:forEach>


</table>

<ul class="pagination">
    <li><a href="/emp/list?pageNum=1"> 首页</a></li>
    <li><a href="/emp/list?pageNum=${list.prePage}"> 上一页</a></li>
    <c:forEach items="${list.navigatepageNums}" var="p">
        <li><a href="/emp/list?pageNum=${p}"> ${p}</a></li>
    </c:forEach>
    <li><a href="/emp/list?pageNum=${list.nextPage}"> 下一页</a></li>
    <li><a href="/emp/list?pageNum=${list.pages}"> 尾页</a></li>

</ul>


</body>
</html>
