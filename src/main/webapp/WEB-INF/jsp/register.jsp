<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>Register</h2>
<form action="${pageContext.request.contextPath}/users/register" method="post">
    <div>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
    </div>
    <div>
        <label for="firstname">First Name</label>
        <input type="text" id="firstname" name="firstname" required>
    </div>
    <div>
        <label for="lastname">Last Name</label>
        <input type="text" id="lastname" name="lastname" required>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <button type="submit">Register</button>
    </div>
</form>
</body>
</html>
