<%--
  Created by IntelliJ IDEA.
  User: Rico
  Date: 2020/12/11
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车为空</title>
    <link rel="stylesheet" type="text/css" href="boot/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="mycss.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="alert alert-primary " style="margin-right: 3rem">
        商城主页
    </div>
    <a href="index.jsp" class="btn btn-outline-primary topbtn">主页</a>
    <a href="car.jsp" class="btn btn-outline-primary topbtn">购物车</a>
</nav>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-10 offset-1">
            <h2>购物车为空，请添加商品哦~</h2>
        </div>
        <div class="col-8 offset-2">
            <a href="index.jsp" class="btn btn-block btn-primary">返回商城</a>
        </div>
    </div>
</div>

</body>
</html>
