<%--
  Created by IntelliJ IDEA.
  User: Rico
  Date: 2020/12/7
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList,cn.rico.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Rico</title>
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
        <a href="https://whisper.ri-co.cn" class="btn btn-outline-primary topbtn">友链</a>

    </nav>

    <div class="container">

        <div class="row">
            <%
                ArrayList<Product> list=(ArrayList<Product>)application.getAttribute("list");
                for (Product product:list){
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
                        <form type="hidden" method="post" action="addToCar">
                            <tr>
                            <input type="hidden" name="itemName" value="<%=product.name%>">
                            <input type="submit" value="加入购物车" class="btn btn-outline-secondary topmargin">
                            </tr>
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
<script>

</script>