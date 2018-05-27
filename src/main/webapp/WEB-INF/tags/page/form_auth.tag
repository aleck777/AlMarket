<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="ooActiveUser" required="true" type="market.logic.User" %>
<%@ attribute name="psel" required="true" type="java.lang.String" %>


<%-- 
     Форма авторизации выводится если авторизация еще не прошла, 
     если пользователь авторизовался, то выводится его ФИО и кнопка выхода. 
--%>

<div class="content-form-auth">
    <c:choose>
    <c:when test="${ooActiveUser.getAuthorized()}">
        Добрый день.<br/>
        <c:out value="${ooActiveUser.getFIO()}"/>
        <br/><a href="?p=${psel}&action=logout">Выйти</a>
    </c:when>
    <c:otherwise>
        <form class="form-auth" action="post">
            <input name="p" value="${psel}" type="hidden">
            <input name="action" value="auth" type="hidden">
            Логин : <input name="login" type="text" value="" size="25"><br/>
            Пароль: <input name="password" type="text" value="" size="25"><br/>

            <input value="Авторизоваться" type="submit">
            <a href="?p=register">Регистрация</a>
        </form>
    </c:otherwise>
    </c:choose>
</div>
