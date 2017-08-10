<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <a href=".">На главную</a>
    <title>Edit/Create restaurant</title>
</head>
<body>

<section>
    <jsp:useBean id="restaurant" type="com.dementevay.voting.to.RestaurantWithMenu" scope="request"/>
    <hr>
    <form method="post" action="saveRestaurant">
        <input type="hidden" name="id" value="${restaurant.id}">
        <dl>
            <dt>Ресторан</dt>
            <dd>
                <input value="${restaurant.name}" name="name">
                <button>Применить</button>
            </dd>
        </dl>
    </form>

    <dl>
        <dt>Меню</dt>
        <dd>
            <c:forEach items="${restaurant.menu}" var="meal" varStatus="status">
                <jsp:useBean id="meal" type="com.dementevay.voting.model.Meal"/>
                <form method="post" action="editMeal">
                    <input type="hidden" value="${meal.id}" name="id">
                    <input type="hidden" value="${meal.restaurant_id}" name="restaurant_id">
                    <input type="hidden" value="${meal.dateTime}" name="dateTime">
                    <input value="${meal.description}" name="description"> :
                    <input type="number" value="${meal.price}" name="price">
                    <button>Применить</button>
                    <a href="delete_meal?id=${meal.id}&restaurant_id=${meal.restaurant_id}">Удалить</a>
                </form>
            </c:forEach>
        </dd>
    </dl>
    <a href="newMeal?restaurant_id=${restaurant.id}">Добавить блюдо</a>

</section>


</body>
</html>
