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
    <link href="<c:url value="/resources/main.css" />" rel="stylesheet">
    <title>Category Page</title>
</head>
<body>
<%--<c:set var="result" value="${requestScope.CATEGORYLIST}"/>
<c:if test="${not empty result}">
    <table>
        <thead>
        <tr>
            <th>Category No</th>
            <th>Category Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${result}" varStatus="counter">
            <form action="CategoryServlet">
            <tr>
                <td>
                        ${counter.count}
                </td>
                <td>
                        ${dto.id}
                </td>
                <td>
                        ${dto.name}
                </td>
            </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${empty result}">
    <h2>No record is matched !!!</h2>
</c:if>--%>
<c:set var="result" value="${requestScope.CATEGORYLIST}"/>
<div id="sidebar">
    <c:forEach var="dto" items="${result}" varStatus="counter">
        <form action="CategoryServlet">
        <ul>
            <li>${dto.name}</li>
        </ul>
        </form>
    </c:forEach>
</div>
</body>
<%--<script src="<c:url value="/resources/main.js" />"></script>--%>
</html>
