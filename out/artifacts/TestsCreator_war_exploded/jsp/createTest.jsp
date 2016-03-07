<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 31.12.2015
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="resources.pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
    <title><fmt:message key="createTest.head.title"/></title>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="static_elements/header.jsp"></jsp:include>
<div class="create_test">
  <h1><fmt:message key="createTest.body.title"/></h1>
  <form name="CreateTest" method="post" action="maincontroller">
    <input type="hidden" name="command" value="create">
    <p><input type="text" name="topic" value="" placeholder="<fmt:message key="createTest.body.form.topic"/>" autocomplete="off" required></p>
    <p><input type="text" name="subject" value="" placeholder="<fmt:message key="createTest.body.form.subject"/>" autocomplete="off" required></p>
    <p><input type="text" name="time" value="" pattern="[0-9]{1,3}" placeholder="<fmt:message key="createTest.body.form.time"/>" autocomplete="off" required></p>
    <button type="submit" class="btn btn-1 btn-1e"><fmt:message key="createTest.body.form.button.createtest"/></button>
  </form>

</div>

</body>
</html>
