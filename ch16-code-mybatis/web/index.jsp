<%--
  User: cj
  Date: 2019/11/6
  Time: 14:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

 <ul>

     <c:forEach items="${list}" var="emp">
         <li>${emp.username}</li>
     </c:forEach>

 </ul>
</body>
</html>
