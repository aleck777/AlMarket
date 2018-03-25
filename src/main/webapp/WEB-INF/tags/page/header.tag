<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="title2" required="true" type="java.lang.String" %>


<div class="header">
    <h1> ${title2} </h1>
    <div>
        <c:if test="${title2.equals(\"main\")}" var="result" scope="page">
            <b><a href="?p=main">Главная</a></b>
        </c:if>
        <c:if test="${!title2.equals(\"main\")}" var="result" scope="page">
            <a href="?p=main">Главная</a>
        </c:if>
        <a href="?p=list">Товары</a>
        <a href="?p=basket">Корзина</a>
    </div>
</div>
<hr/>
