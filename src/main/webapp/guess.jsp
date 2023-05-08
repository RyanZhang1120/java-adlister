<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Guessing Game</title>
</head>
<body>
<form action="/result" method="post">
  <label for="guess">Guess a number between 1 and 3:</label>
  <input type="number" id="guess" name="guess" min="1" max="3" required>
  <input type="submit" value="Submit">
</form>
</body>
</html>
