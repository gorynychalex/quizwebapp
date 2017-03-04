<%--
  Created by IntelliJ IDEA.
  User: gorynych
  Date: 25.02.17
  Time: 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Результат теста</title>
</head>
<body>

<h> РЕЗУЛЬТАТ ТЕСТА: </h>

<p>
    <c:forEach var="option" items="${sessionScope.get('result')}" varStatus="theCount">
        <br>
        Вопрос №<c:out value="${theCount.count}"/>
        &nbsp;&nbsp;
        <c:out value="${option}"/>
    </c:forEach>
</p>
<form action="start">
<button type="button" formaction="start" name="action" value="start">Пройти заново</button>
</form>
</body>
</html>