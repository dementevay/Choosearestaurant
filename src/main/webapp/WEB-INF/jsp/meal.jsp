<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <a href=".">На главную</a>
    <title>Блюдо</title>
</head>
<body>
<section>
    <jsp:useBean id="meal" type="com.dementevay.voting.model.Meal" scope="request"/>
    <form method="post" action="editMeal">
        <input type="hidden" value="${meal.id}" name="id">
        <input type="hidden" value="${meal.restaurant_id}" name="restaurant_id">
        <input type="hidden" value="${meal.dateTime}" name="dateTime">
        <input value="${meal.description}" name="description"> :
        <input type="number" value="${meal.price}" name="price">
        <button>Сохранить</button>
    </form>
</section>

</body>
</html>
