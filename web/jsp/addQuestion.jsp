<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 18.03.2016
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="resources.pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
  <title><fmt:message key="create.head.title"/> </title>
  <script type="text/javascript" language="JavaScript" src="../js/addInput.js"></script>
  <link rel="stylesheet" type="text/css" href="../css/create.css">
  <link rel="stylesheet" type="text/css" href="../css/header.css">
</head>
<body>

<jsp:include page="static_elements/header.jsp"></jsp:include>
<c:set var="flac" value="0" scope="page"/>
<form name="CreateQuestion" method="post" action="maincontroller">
  <input type="hidden" name="command" value="addNewQuestion">
  <p class="title"><fmt:message key="create.body.form.title"/></p>
  <p>
    <label><fmt:message key="create.body.form.question"/></label>
    <textarea name="value_question" cols="57" rows="3"></textarea>
  </p>
  <p>
    <label><fmt:message key="create.body.form.answer"/></label>
    <input type="checkbox" name="correct" value="${flac = flac + 1}" checked/>
    <input type="text" name="answer" value="" autocomplete="off" required/>
    <input type="checkbox" name="correct" value="${flac = flac + 1}"/>
    <input type="text" name="answer" value="" autocomplete="off" required/>
    <input type="checkbox" name="correct" value="${flac = flac + 1}"/>
    <input type="text" name="answer" value="" autocomplete="off"/>
    <input type="checkbox" name="correct" value="${flac = flac + 1}"/>
    <input type="text" name="answer" value="" autocomplete="off"/>
    <input type="checkbox" name="correct" value="${flac = flac + 1}"/>
    <input type="text" name="answer" value="" autocomplete="off"/>
    <a href="#" onclick="addA()" id="addAnswer" title="<fmt:message key="create.body.form.add.answer"/>"><img src="../css/image/add1.png" alt="<fmt:message key="create.body.form.add.answer"/>"/></a>
  </p>
  <p>
    <button type="submit"><fmt:message key="addQuestion.body.form.button"/></button>
    <%--<button type="submit" id="createAllTest" onclick="createATest()"><fmt:message key="create.body.form.bcreate.test"/></button>--%>
  </p>
</form>

<jsp:include page="static_elements/footer.jsp"></jsp:include>
</body>
</html>
