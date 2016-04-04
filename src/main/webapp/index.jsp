<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 07.12.2015
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
  <title><fmt:message key="index.head.title"/></title>
  <link rel="stylesheet" type="text/css" href="css/header.css">
  <link rel="stylesheet" type="text/css" href="css/firstpage.css">
</head>
<body>

<jsp:include page="jsp/static_elements/headerIndex.jsp"></jsp:include>

<form>
  <p>
    <a href="maincontroller?command=passfreetest"><fmt:message key="index.body.pass.test"/></a>
  </p>
  <p>
    <a href="maincontroller?command=enter"><fmt:message key="index.body.enter"/></a>
  </p>
  <p>
    <a href="maincontroller?command=registration"><fmt:message key="index.body.registration"/></a>
  </p>
  <%--<p class="error_message">${wrongAction}</p>
  <p class="error_message">${nullPage}</p>--%>
</form>
<jsp:include page="jsp/static_elements/footer.jsp"></jsp:include>
</body>
</html>
