<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ page import="java.util.*" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<c:set var="ps" value="${param.get(\"p\")}" scope="page"/>--%>
<%--<c:if test="${param.get(\"p\") == null}">--%>
    <%--<c:set var="ps" value="main"/>--%>
<%--</c:if>--%>


<html>
  <header>
    <page:css/>
  </header>
<body>
    <page:header psel="${p}"/>

    <div class="content">
       <%--Селектор страницы с контентом --%>
        <c:choose>
            <c:when test="${p == \"main\"}">
                <page:content_main/>
            </c:when>
            <c:when test="${p == \"about\"}">
                <page:content_about/>
            </c:when>
            <c:otherwise>
                <page:content_e404/>
            </c:otherwise>
        </c:choose>
    </div>

    <tr/>
    <c:forEach var="user" items="${users}">
        <c:out value="${user.getLogin()}"/> -
        <c:out value="${user.getPassword()}"/> -
        <c:out value="${user.getAccess()}"/> <br/>
    </c:forEach>

<page:footer/>
</body>
</html>
