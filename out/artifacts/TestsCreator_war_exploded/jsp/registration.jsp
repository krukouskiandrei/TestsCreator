<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 09.12.2015
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
    <title>Registration</title>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

  <form name="Registration" method="post" action="maincontroller" class="login reg">
    <input type="hidden" name="command" value="createuser">
    <p class="title">Регистрация</p>
    <p>
      <label for="firstname">Имя:</label>
      <input type="text" name="firstname" value="" id="firstname" autocomplete="off" required>
    </p>
    <p>
      <label for="lastname">Фамилия:</label>
      <input type="text" name="lastname" value="" id="lastname" autocomplete="off" required>
    </p>
    <p>
      <label for="email">E-mail:</label>
      <input type="email" name="email" value="" id="email" autocomplete="off" required>
    </p>
    <p>
      <label for="login">Логин:</label>
      <input type="text" name="login" value="" id="login" autocomplete="off" required pattern="^[a-zA-Z]+$">
    </p>
    <p class="error_message">${errorLogin}</p>
    <p>
      <label for="password">Пороль:</label>
      <input type="password" name="password" value="" id="password" autocomplete="off" required pattern="^[a-zA-Z]+$">
    </p>
    <p class="error_message">${errorPassword}</p>
    <p>
      <button type="submit">Зарегистрироваться</button>
    </p>
  </form>

</body>
</html>
