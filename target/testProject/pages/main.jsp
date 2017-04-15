<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
        <title>XZero</title>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
      <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css"/> ">
      <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.min.css"/> ">--%>
  </head>
  <body>
    <h1 class="hello" align="center">Play</h1>
    <table align="center" border="1">
        <tr>
            <c:forEach items="${list}" var="entity">
                <c:if test="${entity.key eq '3'}">
                    </tr>
                    <tr>

                </c:if>
                <c:if test="${entity.key eq '6'}">
                    </tr>
                    <tr>
                </c:if>
                <th class="celltd"><a class="c" href="<c:url value="/push/${entity.key}"/>">${entity.value}</a></th>
                <c:if test="${entity.key eq '8'}">
                    </tr>
                </c:if>
            </c:forEach>
    </table>
    <%--<button><a href="<c:url value="/restart"/>">Restart</a></button>--%>
    <div align="center"><a href="/restart">restart</a></div>
  </body>
</html>
