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
            <th class="celltd"><a href="<c:url value="/push/1"/>">push</a></th>
            <th class="celltd">2</th>
            <th class="celltd">3</th>
        </tr>
        <tr>
            <th class="celltd">4</th>
            <th class="celltd">5</th>
            <th class="celltd">6</th>
        </tr>
        <tr>
            <th class="celltd">7</th>
            <th class="celltd">8</th>
            <th class="celltd">9</th>
        </tr>
    </table>
  </body>
</html>
