<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 16.03.2016
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="resources.pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
  <title><fmt:message key="showListQuestions.head.title"/></title>
  <script type="text/javascript" language="JavaScript" src="../js/addInput.js"></script>
  <link rel="stylesheet" type="text/css" href="../css/header.css">
  <link rel="stylesheet" type="text/css" href="../css/changeTest.css">
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>

<div id="list">
  <form name="ShowListTests" method="post" action="maincontroller">
    <p><fmt:message key="showListQuestions.body.form.title"/></p>
    <p><a href="maincontroller?command=changeNameTest" title="<fmt:message key="showListQuestions.body.form.name"/>" class="name">
        ${changeTest.topic} - ${changeTest.subject} - ${changeTest.time} <fmt:message key="showListQuestions.body.form.name.time"/>
      </a>
    </p>
    <ul>
      <c:forEach var="elem" items="${changeTest.questions}" varStatus="status">
        <li>
          <a href="maincontroller?command=deleteQuestion&idquestion=${elem.id}" title="<fmt:message key="showListQuestions.body.form.cross"/> " class="cross"><img src="../css/image/cross1.png"></a>
          <a href="maincontroller?command=showChangeQuestion&idquestion=${elem.id}" class="title">
            <strong><c:out value="${elem.valueQuestion}"/></strong>
          </a>
        </li>
      </c:forEach>
    </ul>
    <c:if test="${empty changeTest.questions}">
      <p>${errorShowChangeQuestionsMessage}</p>
    </c:if>
    <p>
      <button type="submit" id="saveTest" onclick="sTest()"><fmt:message key="showListQuestions.body.form.button"/></button>
      <button type="submit" id="addQuestion" onclick="aQuestion()"><fmt:message key="showListQuestion.body.form.button.addquestion"/></button>
    </p>
  </form>
</div>
<jsp:include page="static_elements/footer.jsp"></jsp:include>
</body>
</html>