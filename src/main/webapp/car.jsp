<%@ page import="cn.rico.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.rico.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Rico
  Date: 2020/12/8
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="boot/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="mycss.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="alert alert-primary " style="margin-right: 3rem">
        购物车
    </div>
    <a href="index.jsp" class="btn btn-outline-primary topbtn">主页</a>
    <a href="car.jsp" class="btn btn-outline-primary topbtn">购物车</a>
</nav>
<%
    if (session.getAttribute("car")==null){
        response.sendRedirect("empty.jsp");
        return;
    }
    Car car=(Car)session.getAttribute("car");
    ArrayList<Goods>items= new ArrayList<>(car.getItems());
%>
<div class="container">
    <div class="row">
        <%
            for (Goods goods:items){
                Product product=goods.getProduct();
        %>
        <div class="col-4">
            <div class="card">
                <img class="card-img-top" src="<%=product.img %>">
                <div class="card-body">
                    <div class="card-title">
                        <%=product.name%>
                        <div class="price"><%=product.price%></div>
                    </div>
                    <div class="card-text"><%=product.detail%></div>
                    <div class="good-num">
                        数量：<%=goods.getNumber()%>
                    </div>
                    <form type="hidden" method="post" action="/delItem">
                        <input type="hidden" name="itemName" value="<%=product.name%>">
                        <input type="submit" value="删除商品" class="btn btn-outline-danger addbtn">
                    </form>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>

</body>
</html>
