<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 14.03.2016
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="resources.pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
  <title><fmt:message key="statistic.head.title"/></title>
  <link rel="stylesheet" type="text/css" href="../css/statistic.css">
  <link rel="stylesheet" type="text/css" href="../css/header.css">
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>

<div id="list">
  <form name="ShowListTests" method="post" action="maincontroller">
    <p><fmt:message key="statistic.body.form.title"/></p>
    <ul>
      <c:forEach var="elem" items="${statisticUser}" varStatus="status">
        <li>
            <strong><c:out value="${elem.nameTest}"/></strong>
            <span><fmt:message key="statistic.body.form.score"/></span>
            <span class="number"><c:out value="${elem.score}"/></span>
            <span class="data"><c:out value="${elem.time}"/></span>
        </li>
      </c:forEach>
    </ul>
  </form>
</div>
<jsp:include page="static_elements/footer.jsp"></jsp:include>
</body>
</html>
