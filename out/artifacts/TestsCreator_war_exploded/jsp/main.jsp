<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 09.12.2015
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
    <title>Main</title>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
  <label class="user_name">${user.lastname} ${user.firstname}</label>
  <form name="SelectForm" method="post" action="maincontroller" class="select_form">
  <button name="command" value="createTest" class="btn btn-1 btn-1f">Создать тест</button>
  <button name="command" value="takeTest" class="btn btn-1 btn-1f">Пройти тест</button>
    </form>
  </body>
</html>
