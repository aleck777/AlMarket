<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="users" required="true" type="java.util.Collection" %>
<%@ attribute name="ssRegisterResult" required="true" type="java.lang.String" %>
<%@ attribute name="ooActiveUser" required="true" type="market.logic.User" %>

<div class="content-header">
    Register Result!
    <hr/>
    <c:choose>
        <c:when test="${ssRegisterResult == \"RegisterBad\"}">
            Регистрация завершилась неудачно!
        </c:when>
        <c:when test="${ssRegisterResult == \"RegisterGood\"}">
            Добрый день.<br/>
            <c:out value="${ooActiveUser.getFIO()}"/>
            поздравляю Вас с регистрацией! <br/>
        </c:when>
        <c:otherwise>
            <page:content_e404/>
        </c:otherwise>
    </c:choose>
    <hr/>
    Вывод списка пользователей, удалить перед сдачей <br/>
    <c:forEach var="user" items="${users}">
        <c:out value="${user.getLogin()}"/> -
        <c:out value="${user.getPassword()}"/> -
        <c:out value="${user.getAccess()}"/> <br/>
    </c:forEach>
</div>

