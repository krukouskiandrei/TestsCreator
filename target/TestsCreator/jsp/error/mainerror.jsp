<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 09.12.2015
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="ru" scope="session"/>
<fmt:setBundle basename="pagescontent"/>
<html>
<head>
    <meta charset="UTF-8" />
    <title><fmt:message key="mainerror.head.title"/> </title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <link rel="stylesheet" type="text/css" href="../../css/header.css">
</head>
<body>
<jsp:include page="../static_elements/headerIndex.jsp"></jsp:include>
<div class="error">
<p><fmt:message key="mainerror.body.request.part.one"/> {pageContext.errorData.requestURI} <fmt:message key="mainerror.body.request.part.two"/> </p>
  <p><fmt:message key="mainerror.body.servlet"/> {pageContext.errorData.servletName}</p>
  <p><fmt:message key="mainerror.body.status"/> {pageContext.errorData.statusCode}</p>
  <p><fmt:message key="mainerror.body.exception"/> ${pageContext.errorData.throwable}</p>
</div>
<jsp:include page="../static_elements/footer.jsp"></jsp:include>
</body>
</html>
