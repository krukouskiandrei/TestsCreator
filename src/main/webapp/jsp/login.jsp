<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 08.12.2015
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="pagescontent"/>
<html>
<head>
    <meta charset="UTF-8" />
    <title><fmt:message key="login.head.title"/></title>
    <link rel="stylesheet" type="text/css" href="../css/header.css">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
  <jsp:include page="static_elements/headerIndex.jsp"></jsp:include>
  <form name="LoginForm" method="post" action="maincontroller" class="login">
    <input type="hidden" name="command" value="login"/>
    <p>
      <label for="login"><fmt:message key="login.body.login"/> </label>
      <input type="text" name="login" value="" id="login" autocomplete="off">
    </p>
    <p>
      <label for="password"><fmt:message key="login.body.password"/> </label>
      <input type="password" name="password" value="" id="password">
    </p>
    <p class="error_message">${errorLoginPassMessage}</p>
    <p class="login-submit">
      <button type="submit" class="login-button"><fmt:message key="login.body.enter"/> </button>
    </p>
  </form>
  <jsp:include page="static_elements/footer.jsp"></jsp:include>
</body>
</html>
