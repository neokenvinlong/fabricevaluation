<%@ page import="thanhnv.entities.ProductEntity" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/22/2020
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/detail.css" />" rel="stylesheet">
    <title>Product Detail</title>
</head>
<body>
<div id="container">
    <c:set var="result" value="${requestScope.PRODUCTSIZE}"/>
    <%
        ProductEntity value = (ProductEntity) request.getAttribute("PRODUCT");
    %>
    <div class="row">
        <div id="imageLarge" class="col">
            <img src="<%=value.getProductImage()%>" alt="CSS"/>
            <div id="name">aaaaaaaaaaaaaa</div>
            <div id="weather">
                <div class="row1">
                    <div id="weatheritem" class="col">
                        Spring
                    </div>
                    <div id="weatheritem" class="col">
                        Summer
                    </div>
                    <div id="weatheritem" class="col">
                        Fall
                    </div>
                    <div id="weatheritem" class="col">
                        Winter
                    </div>
                </div>
            </div>
        </div>
        <div id="info" class="col">
            <div id="product">
                <div id="productName"><%=value.getProductName()%>
                </div>
                <h1>$ <%=value.getProductPrice()%>
                </h1>
                <div class="horizontal">
                    <hr/>
                </div>
                <span>Size: </span>
                <div class="row1">
                    <c:forEach var="dto" items="${result}">
                        <div id="size" class="col">
                                ${dto}
                        </div>
                    </c:forEach>
                </div>
                <p></p>
                <p></p>
                <p></p>
                <p></p>
                <div class="horizontal">
                    <hr/>
                </div>
                <span>Product Information:</span>
                <div class="information">
                    <%=value.getProductInfo()%>
                </div>
                <p></p>
                <p></p>
                <p></p>
                <p></p>
                <div class="horizontal">
                    <hr/>
                </div>
                <span>Material:</span>
                <div class="information">
                    <%=value.getMaterial()%>
                </div>
            </div>
        </div>
    </div>
    <c:set var="result" value="${requestScope.MATERIALLIST}"/>
    <c:if test="${not empty result}">

        <div id="productinfo">
            <h2>Guide to material - fiber quality :</h2>
            <table id="customers">
                <tr>
                    <th>Fiber</th>
                    <th>Use</th>
                    <th>Appearance</th>
                    <th>Pros</th>
                    <th>Cons</th>
                    <th>Care and washing instructions</th>
                    <th>Wrinkle factor</th>
                    <th>Shrinking factor</th>
                </tr>
                <c:forEach var="dto" items="${result}">
                    <form action="ProductServlet">
                        <tr>
                            <td>${dto.fiber}</td>
                            <td>${dto.uses}</td>
                            <td>${dto.appearance}</td>
                            <td>${dto.pros}</td>
                            <td>${dto.cons}</td>
                            <td>${dto.carewash}</td>
                            <td>${dto.wrinkle}</td>
                            <td>${dto.shrink}</td>
                        </tr>
                    </form>
                </c:forEach>
            </table>

        </div>
    </c:if>
</div><!--#container-->
</body>
</html>
