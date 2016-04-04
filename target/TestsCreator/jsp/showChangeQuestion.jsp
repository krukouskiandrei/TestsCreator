<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 17.03.2016
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
  <title><fmt:message key="showChangeQuestion.head.title"/> </title>
  <script type="text/javascript" language="JavaScript" src="../js/addInput.js"></script>
  <link rel="stylesheet" type="text/css" href="../css/create.css">
  <link rel="stylesheet" type="text/css" href="../css/header.css">
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>
<c:set var="flac" value="0" scope="page"/>
<form name="CreateQuestion" method="post" action="maincontroller">
  <input type="hidden" name="command" value="changeQuestion">
  <p class="title"><fmt:message key="showChangeQuestion.body.form.title"/></p>
  <p>
    <label><fmt:message key="create.body.form.question"/></label>
    <textarea name="value_question" cols="57" rows="3">${changeQuestion.valueQuestion}</textarea>
  </p>
  <p>
    <label><fmt:message key="create.body.form.answer"/></label>
    <c:forEach var="elem" items="${changeQuestion.answers}" varStatus="status">
      <c:if test="${elem.correctAnswer == true}">
        <input type="checkbox" name="correct" value="${flac = flac + 1}" checked/>
      </c:if>
      <c:if test="${elem.correctAnswer == false}">
        <input type="checkbox" name="correct" value="${flac = flac + 1}"/>
      </c:if>
      <c:if test="${flac < 3}">
      <input type="text" name="answer" value="${elem.valueAnswer}" autocomplete="off" required/>
      </c:if>
      <c:if test="${flac > 2}">
        <input type="text" name="answer" value="${elem.valueAnswer}" autocomplete="off"/>
      </c:if>
    </c:forEach>
    <a href="#" onclick="addA()" id="addAnswer" title="<fmt:message key="create.body.form.add.answer"/>"><img src="../css/image/add1.png" alt="<fmt:message key="create.body.form.add.answer"/>"/></a>
  </p>
  <p>
    <button type="submit" id="createQuestion"><fmt:message key="create.body.form.bcreate.question"/></button>
  </p>
</form>

<jsp:include page="static_elements/footer.jsp"></jsp:include>
</body>
</html>
