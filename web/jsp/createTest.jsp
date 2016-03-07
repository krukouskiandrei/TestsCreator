<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 31.12.2015
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<html>
<head>
  <meta charset="UTF-8" />
    <title>Create Test</title>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="static_elements/header.jsp"></jsp:include>
<div class="create_test">
  <h1>Создайте тест</h1>
  <form name="CreateTest" method="post" action="maincontroller">
    <input type="hidden" name="command" value="create">
    <p><input type="text" name="topic" value="" placeholder="Тема теста" autocomplete="off" required></p>
    <p><input type="text" name="subject" value="" placeholder="Предмет" autocomplete="off" required></p>
    <p><input type="text" name="time" value="" pattern="[0-9]{1,3}" placeholder="Время на выполнение теста" autocomplete="off" required></p>
    <button type="submit" class="btn btn-1 btn-1e">Создать тест</button>
  </form>

</div>

</body>
</html>
