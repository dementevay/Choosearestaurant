<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vote</title>
    <a href=".">На главную</a>
    <h1 align="center">Выбор ресторана для обеда:</h1>
    <h2 align="center">(голосование проходит до 11:00)</h2>
    <style>
        .active_vote {
            color: red;
        }
        .normal {
            color: green;
        }
    </style>
</head>
<body>
<form action="" method="post">
    <table border="0">
        <td>Активный пользователь:</td>
        <td class="active_vote">${authenticated_user} </td>
        <td>
            (
            <select name="user_id" autofocus required>
                <option selected value disabled>Выбрать пользователя</option>
                <option value="100000">Админ</option>
                <option value="100001">Пользователь 1</option>
                <option value="100002">Пользователь 2</option>
                <option value="100003">Пользователь 3</option>
            </select>
            <input type="submit" value="Залогинить"> )
        </td>
    </table>
</form>
<form method="post" name="dateTime">
    <td>
        <p>Сейчас: <input type="datetime-local" name="dateTime" size="16" value=${dateTime}>
            <input type="submit" value="Установить время"></p>
        <%--<p><input type="submit" name="Применить"></p>--%>
    </td>
</form>

<jsp:useBean id="user_vote" type="com.dementevay.voting.model.Vote" scope="request"/>

<table border="1" width="80%" cellpadding="8">
    <caption><h2>Голосование:</h2></caption>
    <thead>
    <tr>
        <th>id</th>
        <th width="30%">Ресторан</th>
        <th width="40%">Меню</th>
        <th width="15%">Выбрать</th>
        <th>Edit</th>
        <th>Delete</th>

    </tr>

    <c:forEach items="${restaurants_list}" var="restaurant" varStatus="status">
        <jsp:useBean id="restaurant" type="com.dementevay.voting.to.RestaurantWithMenu"/>
        <tr class="${user_vote.restaurantId == restaurant.id ? 'active_vote':'normal'}">
            <td><c:out value="${restaurant.id}"/></td>
            <td><c:out value="${restaurant.name}"/></td>
            <td>
                <c:forEach items="${restaurant.menu}" var="meal" varStatus="status">
                    <jsp:useBean id="meal" type="com.dementevay.voting.model.Meal"/>
                    <c:out value="${meal.description}"/> : <c:out value="${meal.price} р."/> <br>
                </c:forEach>
            </td>
            <td>
                <a href="vote?restaurantId=<c:out value="${restaurant.id}"/>">Выбрать</a>
            </td>
            <td>
                <a href="editRestaurant?id=<c:out value="${restaurant.id}"/>">Edit</a>
            </td>
            <td>
                <a href="delete?id=<c:out value="${restaurant.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </thead>
</table>

<p style="text-align: left">
    <a href="editRestaurant?id=0">Добавить ресторан</a>
    <br>
<jsp:useBean id="winner" type="java.lang.String" scope="request"/>
<form id="daysSelect">
    <td>
<p>Ресторан дня (известен после 11:00): <b>${winner}</b> </p>
    </td>
</form>
<hr>
<p style="text-align: center">
    Made by Dementev Andrey as test task. (10.08.2017)
</p>
</body>
</html>
