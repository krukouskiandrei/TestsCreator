<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 09.12.2015
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="resources.pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
    <title><fmt:message key="registration.head.title"/></title>
  <link rel="stylesheet" type="text/css" href="../css/registration.css">
  <script type="text/javascript" src="../js/checkpassword.js"></script>
</head>
<body>

  <form name="Registration" method="post" action="maincontroller" class="registration">
    <input type="hidden" name="command" value="createuser">
    <p class="title"><fmt:message key="registration.body.form.title"/></p>
    <p>
      <label for="firstname"><span><fmt:message key="registration.body.form.star"/></span></span><fmt:message key="registration.body.form.firstname"/></label>
      <input type="text" name="firstname" value="" id="firstname" autocomplete="off" required>
    </p>
    <p>
      <label for="lastname"><span><fmt:message key="registration.body.form.star"/></span><fmt:message key="registration.body.form.lastname"/></label>
      <input type="text" name="lastname" value="" id="lastname" autocomplete="off" required>
    </p>
    <p>
      <label for="email"><span><fmt:message key="registration.body.form.star"/></span><fmt:message key="registration.body.form.email"/> </label>
      <input type="email" name="email" value="" id="email" autocomplete="off" required>
    </p>
    <p>
      <label for="login"><span><fmt:message key="registration.body.form.star"/></span><fmt:message key="registration.body.form.login"/></label>
      <input type="text" name="login" value="" id="login" autocomplete="off" required pattern="^[a-zA-Z]+$">
    </p>
    <p class="error_message">${errorLogin}</p>
    <p>
      <label for="password"><span><fmt:message key="registration.body.form.star"/></span><fmt:message key="registration.body.form.password"/></label>
      <input type="password" name="password" value="" id="password" autocomplete="off" required pattern="^[a-zA-Z]+$" onchange="checkPasswords()">
    </p>
    <p class="error_message">${errorPassword}</p>
    <p>
      <label for="password1"><span><fmt:message key="registration.body.form.star"/></span><fmt:message key="registration.body.form.password1"/></label>
      <input type="password" name="password1" value="" id="password1" autocomplete="off" required pattern="^[a-zA-Z]+$" onchange="checkPasswords()">
    </p>
    <p>
      <label for="valid"><span><fmt:message key="registration.body.form.star"/></span><fmt:message key="registration.body.form.valid"/></label>
      <script type="text/javascript">valid();</script>
      <input type="text" id="valid" autocomplete="off" required onchange="check()">
    </p>
    <p>
      <button type="submit"><fmt:message key="registration.body.form.button.reg"/></button>
    </p>
  </form>

</body>
</html>
