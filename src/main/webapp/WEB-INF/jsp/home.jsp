<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h2>Quiz Categories</h2>
<ul>
    <c:forEach var="category" items="${categories}">
        <li>${category.name}</li>
    </c:forEach>
</ul>

<h2>Recent Quiz Results</h2>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Date Taken</th>
        <th>Link</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="quiz" items="${recentQuizzes}">
        <tr>
            <td>${quiz.name}</td>
            <td>${quiz.dateTaken}</td>
            <td><a href="${pageContext.request.contextPath}/quiz/result/${quiz.quizId}">View Result</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
