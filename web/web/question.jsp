
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Question Quiz ${sessionScope.get("questionId")}</title>
</head>
<body>

<h1>Тест: ${sessionScope.get("quizName")}</h1>

<p>Вопрос № ${sessionScope.get("question").getId()+1} из ${sessionScope.get("questionNums")}</p>

<p><b>${sessionScope.get("question").getText()}</b></p>

<br>
<form action="quiz" method="post">

<c:forEach var="option" items="${sessionScope.get('question').getOptions()}" varStatus="theCount">
    <br>
    <input type="radio" name="option" value=${theCount.count-1}><c:out value="${option.getText()}"/>
</c:forEach>

    <p>
    <c:if test="${not empty sessionScope.get('prevId')}">
        <button type="submit" formaction="quiz?userId=${param.get('userId')}&quizId=${param.get('quizId')}&questionId=${sessionScope.get("prevId")}" name="action" value="prevQuestionButton">Предыдущий</button>
        &nbsp;&nbsp;
    </c:if>

    <c:if test="${not empty sessionScope.get('nextId')}">
        <button type="submit" formaction="quiz?userId=${param.get('userId')}&quizId=${param.get('quizId')}&questionId=${sessionScope.get('nextId')}" name="action" value="nextQuestionButton">Следующий</button>
        &nbsp;&nbsp;
    </c:if>

        <button type="submit" name="action" value="finishQuiz">Закончить тест</button></p>

</form>


</body>
</html>
