<%--
  Created by IntelliJ IDEA.
  User: gorynych
  Date: 10.02.17
  Time: 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Question Quiz ${sessionScope.get("question").getId()}</title>
</head>
<body>

<h1>Quiz: ${sessionScope.get("quizName")}</h1>

<p>Question ${sessionScope.get("question").getId()+1} of ${sessionScope.get("questionNums")}</p>

<p><b>${sessionScope.get("question").getName()}</b></p>

<br>
<form action="quiz" method="post">
    <input type="hidden" name="questionId" value="${sessionScope.get("question").getId()}">


<c:forEach var="option" items="${sessionScope.get('question').getOptions()}" varStatus="theCount">

    <br>
    <input type="radio" name="answer" value=${theCount.count}><c:out value="${option}"/>
</c:forEach>
    <p><input type="submit" name="action" value="Prev">
        &nbsp;&nbsp;
    <input type="submit" name="action" value="Next">
        &nbsp;&nbsp;
    <input type="submit" name="action" value="Finish"></p>
</form>


</body>
</html>
