<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 02.01.2016
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
    <title>Create Question</title>
  <script type="text/javascript" language="JavaScript" src="../js/addInput.js"></script>
  <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>

<div id="create_question">
  <form name="CreateQuestion" method="post" action="maincontroller">
    <span>Введите вопрос:</span>
    <textarea name="value_question" cols="57" rows="3"></textarea>
    <span>Введите ответ:</span>
    <input type="text" name="correct_answer" autocomplete="off" required>
    <button onclick="addCAnswer()" id="addCorrectAnswer">Добавить ответ</button>
    <span>Введите варианты ответа:</span>
    <input type="text" name="answer" value="" autocomplete="off" required>
    <input type="button" value="Вариант ответа" id="addAnswer" onclick="addA()">
    <br>
    <button type="submit" id="createQuestion" onclick="createQ()">Создать вопрос</button>
    <button type="submit" id="createAllTest" onclick="createATest()">Создать тест</button>
  </form>
</div>

</body>
</html>