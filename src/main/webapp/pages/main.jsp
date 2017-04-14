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
            <th class="celltd"><a class="c" href="<c:url value="/push/1"/>">${x1}.</a></th>
            <th class="celltd"><a class="c" href="<c:url value="/push/2"/>">${x2}.</a></th>
            <th class="celltd"><a class="c" href="<c:url value="/push/3"/>">${x3}.</a></th>
        </tr>
        <tr>
            <th class="celltd"><a class="c" href="<c:url value="/push/4"/>">${x4}.</a></th>
            <th class="celltd"><a class="c" href="<c:url value="/push/5"/>">${x5}.</a></th>
            <th class="celltd"><a class="c" href="<c:url value="/push/6"/>">${x6}.</a></th>
        </tr>
        <tr>
            <th class="celltd"><a class="c" href="<c:url value="/push/7"/>">${x7}.</a></th>
            <th class="celltd"><a class="c" href="<c:url value="/push/8"/>">${x8}.</a></th>
            <th class="celltd"><a class="c" href="<c:url value="/push/9"/>">${x9}.</a></th>
        </tr>
    </table>
  </body>
</html>
