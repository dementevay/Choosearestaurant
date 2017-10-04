<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <a href=".">На главную</a>
    <title>Edit/Create restaurant</title>
</head>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script type="text/javascript" src="resources/js/vote.js" defer></script>

<section>
    <jsp:useBean id="restaurant" type="com.dementevay.voting.to.RestaurantWithMenu" scope="request"/>
    <hr>
    <form method="post" action="saveRestaurant?${_csrf.parameterName}=${_csrf.token}">
        <input type="hidden" name="id" value="<c:out value="${restaurant.id}"/>">
        <dl>
            <dt>Ресторан</dt>
            <dd>
                <input value="<c:out value="${restaurant.name}"/>" name="name">
                <button>Применить</button>
            </dd>
        </dl>
    </form>

    <dl>
        <dt>Меню</dt>
        <dd>
<%--<sec:authorize access="isAuthenticated()">--%>
            <c:forEach items="${restaurant.menu}" var="meal" varStatus="status">
                <jsp:useBean id="meal" type="com.dementevay.voting.model.Meal"/>
                <form method="post" action="editMeal?${_csrf.parameterName}=${_csrf.token}">
                    <input type="hidden" value="<c:out value="${meal.id}"/>" name="id">
                    <input type="hidden" value="<c:out value="${meal.restaurantId}"/>" name="restaurantId">
                    <input type="hidden" value="<c:out value="${meal.date}"/>" name="dateTime">
                    <input value="<c:out value="${meal.description}"/>" name="description"> :
                    <input type="number" value="<c:out value="${meal.price}"/>" name="price">
                    <button>Применить</button>
                    <a href="delete_meal?id=<c:out value="${meal.id}"/>&restaurantId=<c:out value="${meal.restaurantId}"/>">Удалить</a>
                </form>
            </c:forEach>
<%--</sec:authorize>--%>
        </dd>
    </dl>
    <a href="newMeal?restaurantId=<c:out value="${restaurant.id}"/>">Добавить блюдо</a>

</section>


</body>
</html>
