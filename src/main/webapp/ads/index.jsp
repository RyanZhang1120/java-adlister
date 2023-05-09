<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>All Ads</title>
</head>
<body>
<h1>Ads</h1>
<c:forEach items="${ads}" var="ad">
  <p>
    Id: ${ad.id}<br>
    User Id: ${ad.id}<br>
    Title: ${ad.title}<br>
    Description: ${ad.description}<br>
  </p>
</c:forEach>
</body>
</html>
