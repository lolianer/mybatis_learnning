<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11725
  Date: 2021/8/28
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>员工列表</title>
</head>
<body>
<table cellspacing="0" cellpadding="1" border="1 solid" style="text-align: center">
    <tr>
        <th>id</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <c:if test="${emp.gender == 0}">
                <td>女</td>
            </c:if>
            <c:if test="${emp.gender == 1}">
                <td>男</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
