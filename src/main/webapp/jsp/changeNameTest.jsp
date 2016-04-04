<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 18.03.2016
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="pagescontent"/>
<html>
<head>
  <meta charset="UTF-8" />
  <title><fmt:message key="createTest.head.title"/></title>
  <link rel="stylesheet" type="text/css" href="../css/createTest.css">
  <link rel="stylesheet" type="text/css" href="../css/header.css">
</head>
<body>
<jsp:include page="static_elements/header.jsp"></jsp:include>
<form name="CreateTest" method="post" action="maincontroller">
  <input type="hidden" name="command" value="changeName">
  <p class="title"><fmt:message key="createTest.body.title"/></p>
  <p>
    <label><fmt:message key="createTest.body.form.subject"/></label>
    <select size="1" name="subject" required>
      <option value="${changeTest.subject}">${changeTest.subject}</option>
      <option value="<fmt:message key="createTest.body.form.subject.s1"/>"><fmt:message key="createTest.body.form.subject.s1"/></option>
      <option value="<fmt:message key="createTest.body.form.subject.s2"/>"><fmt:message key="createTest.body.form.subject.s2"/></option>
      <option value="<fmt:message key="createTest.body.form.subject.s3"/>"><fmt:message key="createTest.body.form.subject.s3"/></option>
      <option value="<fmt:message key="createTest.body.form.subject.s4"/>"><fmt:message key="createTest.body.form.subject.s4"/></option>
      <option value="<fmt:message key="createTest.body.form.subject.s5"/>"><fmt:message key="createTest.body.form.subject.s5"/></option>
      <option value="<fmt:message key="createTest.body.form.subject.s6"/>"><fmt:message key="createTest.body.form.subject.s6"/></option>
      <option value="<fmt:message key="createTest.body.form.subject.s7"/>"><fmt:message key="createTest.body.form.subject.s7"/></option>
      <option value="<fmt:message key="createTest.body.form.subject.s8"/>"><fmt:message key="createTest.body.form.subject.s8"/></option>
    </select>
  </p>
  <p>
    <label><fmt:message key="createTest.body.form.topic"/></label>
    <input type="text" autocomplete="off" required name="topic" value="${changeTest.topic}"/>
  </p>
  <p>
    <label><fmt:message key="createTest.body.form.time"/></label>
    <input type="number" name="time" value="${changeTest.time}" min="1" max="600" step="1">
    <span><fmt:message key="createTest.body.form.time.title"/></span>
  </p>
  <p>
    <button type="submit"><fmt:message key="create.body.form.bcreate.question"/></button>
  </p>
</form>

<jsp:include page="static_elements/footer.jsp"></jsp:include>

</body>
</html>
