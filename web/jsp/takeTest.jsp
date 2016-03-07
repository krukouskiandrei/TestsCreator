<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 31.12.2015
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
    <title>Show List Tests</title>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>

  <div id="list">
    <form name="ShowListTests" method="post" action="maincontroller">
      <p>Выберите тест</p>
    <ul>
      <c:forEach var="elem" items="${listTests}" varStatus="status">
        <li>
          <a href="maincontroller?command=showTest&idtest=${elem.id}">
            <strong><c:out value="${elem.topic}"/></strong>
            <span><c:out value="${elem.subject}"/></span>
          </a>
        </li>
      </c:forEach>
   </ul>
    </form>
  </div>

</body>
</html>
