<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Users list</h2>

<c:forEach items="${model}" var="recipe">
    <p>${recipe.recipeId} - ${recipe.recipeName}</p>
</c:forEach>
</body>
</html>
