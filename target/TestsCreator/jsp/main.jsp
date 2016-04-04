<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 09.12.2015
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
    <title><fmt:message key="main.head.title"/></title>
  <link rel="stylesheet" type="text/css" href="../css/mainPage.css">
  <link rel="stylesheet" type="text/css" href="../css/header.css">
</head>
<body>
  <jsp:include page="static_elements/header.jsp"></jsp:include>
  <form name="SelectForm" method="post" action="maincontroller" class="select_form">
    <button name="command" value="createTest" class="btn btn-1 btn-1f"><fmt:message key="main.body.button.create"/></button>
    <button name="command" value="takeTest" class="btn btn-1 btn-1f"><fmt:message key="main.body.button.pass"/></button>
    <button name="command" value="changeTest"><fmt:message key="main.body.button.change"/></button>
    <button name="command" value="statisticUser"><fmt:message key="main.body.button.statistics"/></button>
  </form>
  <jsp:include page="static_elements/footer.jsp"></jsp:include>
  </body>
</html>
