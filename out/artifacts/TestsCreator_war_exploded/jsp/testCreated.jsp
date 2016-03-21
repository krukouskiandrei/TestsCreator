<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 02.01.2016
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="resources.pagescontent"/>
<html>
<head>
    <meta charset="UTF-8" />
    <title><fmt:message key="testCreated.head.title"/></title>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" type="text/css" href="../css/header.css">
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>

<div id="result">
  <form method="post" action="maincontroller">
      <input type="hidden" name="command" value="forwardtomainjsp">
    <p><fmt:message key="testCreated.body.result"/></p>
    <p>
      <button type="submit" id="next"><fmt:message key="addQuestion.body.form.button"/></button>
    </p>
  </form>
</div>
<jsp:include page="static_elements/footer.jsp"></jsp:include>
</body>
</html>
