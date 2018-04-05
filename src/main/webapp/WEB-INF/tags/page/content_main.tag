<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="users" required="true" type="java.util.Collection" %>

<div class="content-header">
    Main: Hellow World!
    <hr/>
    <c:forEach var="user" items="${users}">
        <c:out value="${user.getLogin()}"/> -
        <c:out value="${user.getPassword()}"/> -
        <c:out value="${user.getAccess()}"/> <br/>
    </c:forEach>
</div>

