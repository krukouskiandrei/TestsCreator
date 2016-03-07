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
<div id="menu">
  <form name="menu" method="post" action="maincontroller">
    <button name="command" value="forwardtomainjsp" class="btn btn-1 btn-1d"><fmt:message key="header.button.name"/> </button>
  </form>
</div>
