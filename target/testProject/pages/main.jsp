<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
        <title>XZero</title>
      <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>--%>
      <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css"/> ">
      <%--<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/foundation.min.css"/> ">--%>
  </head>
  <body>
    <h1 class="hello" align="center">Play</h1>
    <div align="center"><h2>${xWin}${oWin}${bothLosers}</h2></div>
    <div align="center"><h6 style="color: #9e0c0f">${duplicate}</h6></div>
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
    <br>
    <%--<div align="center">${xWin}${oWin}</div>--%>
    <%--<button><a href="<c:url value="/restart"/>">Restart</a></button>--%>
    <div align="center">
        <input type="button" value="Go" onclick="window.location.href='/compTurn'"/>
    </div>

    <%--<label><input type="checkbox" name="checkbox" value="value" onclick="window.location.href='/change'">Text</label>--%>
    <br>
    <div align="center"><a style="text-decoration: none" href="/restart">restart</a></div>

  </body>
</html>
