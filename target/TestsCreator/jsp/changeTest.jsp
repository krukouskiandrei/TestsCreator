<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 15.03.2016
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
  <title><fmt:message key="takeTest.head.title"/></title>
  <link rel="stylesheet" type="text/css" href="../css/header.css">
  <link rel="stylesheet" type="text/css" href="../css/changeTest.css">
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>

<div id="list">
  <form name="ShowListTests" method="post" action="maincontroller">
    <p><fmt:message key="takeTest.body.form.choose"/></p>
    <ul>
      <c:forEach var="elem" items="${changeTests}" varStatus="status">
        <li>
          <a href="maincontroller?command=deleteTest&idtest=${elem.id}" title="<fmt:message key="changeTest.body.form.cross"/> " class="cross"><img src="../css/image/cross1.png"></a>
          <a href="maincontroller?command=showListQuestions&idtest=${elem.id}" class="title">
            <strong><c:out value="${elem.topic}"/></strong>
            <span><c:out value="${elem.subject}"/></span>
          </a>
        </li>
      </c:forEach>
    </ul>
    <c:if test="${empty changeTests}">
      <p>${errorchangeTestsMessage}</p>
    </c:if>

  </form>
</div>
<jsp:include page="static_elements/footer.jsp"></jsp:include>
</body>
</html>