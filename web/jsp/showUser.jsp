<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 15.03.2016
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="resources.pagescontent"/>
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
    <p><fmt:message key="showUser.body.form.title"/></p>
    <ul>
      <c:forEach var="elem" items="${listUsers}" varStatus="status">
        <li>
          <a href="maincontroller?command=deleteTest&idtest=${elem.id}" class="cross"><img src="../css/image/cross1.png"></a>
          <a href="maincontroller?command=showTest&idtest=${elem.id}" class="title">
            <strong><c:out value="${elem.lastname}"/> <c:out value="${elem.firstname}"/></strong>
            <span><c:out value="${elem.email}"/></span>
          </a>
        </li>
      </c:forEach>
    </ul>
    <c:if test="${empty listUsers}">
      <p>${errorshowUsersMessage}</p>
    </c:if>

  </form>
</div>
<jsp:include page="static_elements/footer.jsp"></jsp:include>
</body>
</html>