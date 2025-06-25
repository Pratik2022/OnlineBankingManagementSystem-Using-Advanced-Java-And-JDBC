<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdraw Amount</title>
    <link rel="stylesheet" href="SignUp.css"> <!-- Link to external CSS -->
</head>
<body>
    <h2>Withdraw Amount</h2>
    <form action="log" method="post" class="signup-form">
        <label for="accNo">Account No:</label>
        <input type="text" name="accNo" id="accNo" required/><br><br>

        <label for="amount">Amount:</label>
        <input type="text" name="amount" id="amount" required/><br><br>

        <input type="submit" name="submit" value="Withdraw"/>
        <input type="hidden" name="id" value="WD"/>
    </form>

    <div class="links">
        <a href="Home.jsp">Home</a><br><br>
        <a href="logout.jsp">Logout</a>
    </div>
</body>
</html>
