<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 08.12.2015
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
  <form name="LoginForm" method="post" action="maincontroller" class="login">
    <input type="hidden" name="command" value="login"/>
    <p>
      <label for="login">Логин:</label>
      <input type="text" name="login" value="" id="login" autocomplete="off">
    </p>
    <p>
      <label for="password">Пароль:</label>
      <input type="password" name="password" value="" id="password">
    </p>
    <p class="error_message">${errorLoginPassMessage}</p>
    <p class="error_message">${wrongAction}</p>
    <p class="error_message">${nullPage}</p>
    <p class="login-submit">
      <button type="submit" class="login-button">Войти</button>
    </p>
    <p class="registration"><a href="maincontroller?command=registration">Регистрация</a></p>
  </form>


</body>
</html>
