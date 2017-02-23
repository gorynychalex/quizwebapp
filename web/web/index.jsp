<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Quiz System</title>
  </head>
  <body>

  <h1>Система тестирования:</h1>

  <form action="quiz">

      <p>Имя пользователя: </p>

      <select name="userId">

      <c:forEach var="user" items="${sessionScope.get('users')}" varStatus="theCount">
          <c:choose>
          <c:when test="${theCount.count ge 2}">
              <option value="${theCount.count-1}"><c:out value="${user}"/></option>
          </c:when>
          <c:otherwise>
              <option selected value="${theCount.count-1}"><c:out value="${user}"/></option>
          </c:otherwise>
          </c:choose>
      </c:forEach>
      </select>

      <br>

      <p>Выбрать тест:</p>

      <c:forEach var="option" items="${sessionScope.get('quizNames')}" varStatus="theCount">
      <br>
          <c:choose>
          <c:when test="${theCount.count ge 2}">
              <input type="radio" name="quizId" value=${theCount.count-1}><c:out value="${option}"/>
          </c:when>
          <c:otherwise>
              <input type="radio" checked name="quizId" value=${theCount.count-1}><c:out value="${option}"/>
          </c:otherwise>
          </c:choose>
      </c:forEach>
      <br>

      <button type="submit" name="action" value="startQuiz">Пройти тест</button>

  </form>

  </body>
</html>