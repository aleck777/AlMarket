<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="market.logic.User" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>и
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
     <%-- Тест селектора страницы --%>
    <%--<c:out value="${p}"/>     <br/>--%>
    <div>
        <page:form_auth psel="${p}" ooActiveUser="${oActiveUser}"/>
        <page:logo/>
    </div>

    <page:header psel="${p}"/>
    <hr/>

    <div class="content">
       <%--Селектор страницы с контентом --%>
        <c:choose>
            <c:when test="${p == \"main\"}">
                <page:content_main users="${users}"/>
            </c:when>
            <c:when test="${p == \"about\"}">
                <page:content_about/>
            </c:when>
            <c:when test="${p == \"register\"}">
                <page:content_register/>
            </c:when>
            <c:otherwise>
                <page:content_e404/>
            </c:otherwise>
        </c:choose>
    </div>


<page:footer/>
</body>
</html>
