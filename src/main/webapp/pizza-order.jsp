<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pizza Order</title>
</head>
<body>
    <h1>Pizza Order</h1>
    <from action="PizzaOrderServlet" method="post">
        <label for="crust">Crust:</label>
        <select id="crust" name="crust">
            <option value="thin">Thin</option>
            <option value="regular">Regular</option>
            <option value="thick">Thick</option>
        </select>
        <br>
        <label for="sauce">Crust:</label>
        <select id="sauce" name="crust">
            <option value="marinara">Marinara</option>
            <option value="alfredo">Alfredo</option>
            <option value="bbq">BBQ</option>
        </select>
        <br>
        <label for="size">Size:</label>
        <select id="size" name="size">
            <option value="small">Small</option>
            <option value="medium">Medium</option>
            <option value="large">Large</option>
        </select>
        <br>
        <label>Toppings:</label>
        <br>
        <input type="checkbox" id="pepperoni" name="toppings" value="pepperoni">
        <label for="pepperoni">Pepperoni</label>
        <br>
        <input type="checkbox" id="mushrooms" name="toppings" value="mushrooms">
        <label for="mushrooms">Mushrooms</label>
        <br>
        <input type="checkbox" id="onions" name="toppings" value="onions">
        <label for="onions">Onions</label>
        <br>
        <label for="address">Delivery Address:</label>
        <input type="text" id="address" name="address">
        <br>
        <input type="submit" value="Submit">
    </from>
</body>
</html>
