<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 09.12.2015
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Main Error</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
  <p>Request from ${pageContext.errorData.requestURI} is failed</p>
  <p>Servlet name or type: ${pageContext.errorData.servletName}</p>
  <p>Status code: ${pageContext.errorData.statusCode}</p>
  <p>Exception: ${pageContext.errorData.throwable}</p>
</body>
</html>
