<%--
  Created by IntelliJ IDEA.
  User: bartek
  Date: 28.05.18
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bazar aplikacji</title>
</head>
<body>
<h1>Wyniki wyszukiwań</h1>
<table>
    <tr>
        <td><b>Nazwa:</b></td>
        <td><b>Opis:</b></td>
    </tr>
    <c:forEach var="app" items="${apps}">
        <tr>
            <td>${app.name}</td>
            <td>${app.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>