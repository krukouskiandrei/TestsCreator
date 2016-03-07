<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 31.12.2015
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
    <title>Show Test</title>
  <script type="text/javascript" language="JavaScript" src="../js/timer.js"></script>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body onload="myTimer(${test.time})" >

<jsp:include page="static_elements/header.jsp"></jsp:include>

  <div id="timer">
    <p id="time"></p>
    <div id="endtime">
      <p>Время закончилось</p>
    </div>
  </div>

  <div id="show_test">
    <form name="ShowTest" method="post" action="maincontroller">
      <p><c:out value="${test.topic}"/></p>
      <input type="hidden" name="command" value="checktest">
      <ol>
        <c:forEach var="question" items="${test.questions}" varStatus="status">
          <li><c:out value="${question.valueQuestion}"/>
            <ol>
              <c:forEach var="answer" items="${question.answers}" varStatus="stat">
                <li><input type="checkbox" name="${status.count}" value="${stat.count}"><c:out value="${answer.valueAnswer}"/></li>
              </c:forEach>
            </ol>
          </li>
        </c:forEach>
      </ol>
      <button type="submit" class="btn btn-1 btn-1e" id="bcheck">Проверить</button>
    </form>

  </div>

</body>
</html>
