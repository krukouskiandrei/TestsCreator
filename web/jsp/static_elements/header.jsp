<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Krukouski Andrei
  Date: 10.01.2016
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="resources.pagescontent"/>
<%--<div id="menu">
  <form name="menu" method="post" action="maincontroller">
    <button name="command" value="forwardtomainjsp" class="btn btn-1 btn-1d"><fmt:message key="header.button.name"/> </button>
  </form>
</div>--%>
<header>
  <div class="logo">
    <a href="maincontroller?command=forwardtomainjsp"><img src="../../css/image/logo.jpg"></a>
  </div>
  <ul>
    <li><a href="maincontroller?command=choose&lang=en"><img src="../../css/image/england_flag.png"></a></li>
    <li><a href="maincontroller?command=choose&lang=ru"><img src="../../css/image/russia_flag.png"></a></li>
  </ul>
  <div class="clearfix"></div>
  <form class="logout" name="menu" method="post" action="maincontroller">
    <button name="command" value="logout"><fmt:message key="header.logout"/></button>
  </form>
</header>

