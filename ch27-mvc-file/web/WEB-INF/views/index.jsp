<%--
  User: cj
  Date: 2019/11/20
  Time: 11:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post"
      enctype="multipart/form-data" action="/upload">

    <input type="file" name="myfile"/>
    <input type="submit" value="提交"/>

</form>
<a href="/download?filename=联通.jpg"> 下载(文件名有中文)</a>
<a href="/download?filename=son.jpg"> 下载</a>

<img src="/download?filename=son.jpg"/>
</body>
</html>
