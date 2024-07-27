<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>Please sign in</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div>
        <label for="username">Email</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <button type="submit">Sign in</button>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/users/register">Register</a>
    </div>
</form>
</body>
</html>
