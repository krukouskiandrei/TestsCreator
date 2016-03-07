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
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>

<div id="result">
  <p><fmt:message key="testCreated.body.result"/></p>
</div>

</body>
</html>
