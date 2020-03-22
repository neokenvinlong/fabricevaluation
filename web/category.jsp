<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/19/2020
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/index.css" />" rel="stylesheet">
    <title>Category Page</title>
</head>
<body>
<div id="container">

    <div id="menu">
        <ul>
            <li>
                <form action="SearchServlet" method="POST">
                    <%--<input type="text" name="txtProductName"/>--%>
                    <%--<input type="submit" value="Search"/>--%>
                    <div class="search-container">
                        <form action="/action_page.php">
                            <input type="text" placeholder="Search.." name="txtProductName">
                            <input type="submit" value="Search"/>
                        </form>
                    </div>
                </form>
            </li>
        </ul>
        <c:set var="result" value="${requestScope.CATEGORYLIST}"/>
        <c:forEach var="dto" items="${result}" varStatus="counter">
            <form action="CategoryServlet">
                <ul>
                    <li><a href="CategoryProductServlet?id=${dto.id}">${dto.name}</a></li>
                </ul>
            </form>
        </c:forEach>
    </div><!--END #menu-->

    <div id="content">
        <c:set var="categoryproduct" value="${requestScope.PRODUCTLIST}"/>
            <div class="row">
                <c:forEach var="categoryproductdto" items="${categoryproduct}">
                    <div id="box1" class="col">
                    <img src="${categoryproductdto.productImage}" alt="CSS"/>
                    <div id="productinfo">
                        <div id="producttitle">
                            <a href="ProductServlet?proId=${categoryproductdto.productId}">${categoryproductdto.productName}</a>
                        </div>
                        <div id="productprice">
                            <span>$ ${categoryproductdto.productPrice}</span>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div><!--.call-to-action-->

    </div><!--#content-->
</div><!--#container-->
</body>
<%--<script src="<c:url value="/resources/main.js" />"></script>--%>
</html>
