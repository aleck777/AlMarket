<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ page import="java.util.*" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%@ taglib tagdir="/WEB-INF/tags/page" prefix="page" %>

<%--<c:set var="ps" value="${param.get(\"p\")}" scope="page"/>--%>
<%--<c:if test="${param.get(\"p\") == null}">--%>
    <%--<c:set var="ps" value="main"/>--%>
<%--</c:if>--%>


<html>
  <header>
    <page:css/>
  </header>
<body>
page = ${p} <br/>
<page:header psel="${p}"/>

<h2>Hello World!</h2>

<page:footer/>


</body>
</html>
