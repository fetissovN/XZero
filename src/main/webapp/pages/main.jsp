<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
        <title>XZero</title>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
      <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css"/> ">
      <script src="<c:url value="/resources/js/script.js"/> "></script>
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
    <div align="center">
        <input id="turn" type="button" value="Go" onclick="window.location.href='/compTurn'" />
        <label><input id="chb" type="checkbox" name="checkbox" value="value">Play with computer</label>
    </div>
    <br>
    <div align="center"><a style="text-decoration: none" href="/restart">restart</a></div>

  </body>
</html>
