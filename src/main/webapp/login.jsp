
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="partials/head.jsp"  />
</head>
<body>
    <jsp:include page="partials/navbar.jsp"  />
    <h1>Login</h1>
    <form action="login.jsp" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="Login">
    </form>
    <%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null) {
        if ("admin".equals(username) && "password".equals(password)) {
            response.sendRedirect("profile.jsp");
        } else {
            out.println("<p style='color:red'>Invalid username or password. Please try again.</p>");
        }
    }
%>
</body>
</html>

