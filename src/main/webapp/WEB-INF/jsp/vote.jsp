<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vote</title>
    <h1 align="center">Выбор ресторана для обеда:</h1>
    <h2 align="center">(голосование проходит до 11:00)</h2>
</head>
<body>

<%! private static int id_user;%>

<form name="user_id" method="post">
    <p>Пользователь: <select autofocus required >
        <option selected value="100000">Админ</option>
        <option value="100001" >Пользователь 1</option>
        <option value="100002" >Пользователь 2</option>
        <option value="100003" >Пользователь 3</option>
    </select>
        <input type="submit" value="Применить"></p>
    <p></p>
</form>

<form method="get" name="dateTime">
    <td>
        <p>Сейчас: <input type="datetime-local" name="dateTimeNow" size="16" value="2017-12-31T01:02">
            <input type="submit" value="Применить"></p>
        <%--<p><input type="submit" name="Применить"></p>--%>
    </td>
</form>

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
        <jsp:useBean id="restaurant" scope="page" type="com.dementevay.voting.to.RestaurantWithMenu"/>
        <tr <%--class="${restaurant.name ? 'exceeded':'nonexceeded'}"--%>>
            <td>${restaurant.id}</td>
            <%--<td><%=TimeUtil.formatDateTime(me.getDateTime())%></td>--%>
            <td>${restaurant.name}</td>
            <td>
                <c:forEach items="${restaurant.menu}" var="meal" varStatus="status">
                    <jsp:useBean id="meal" scope="page" type="com.dementevay.voting.model.Meal"/>
                    ${meal.description} : ${meal.price} <br>
                </c:forEach>
            </td>
            <td>
                <form method="post">
                    <button name="vote_btn" value="${restaurant.id}">Выбрать</button>
                </form>
            </td>
            <td>
                <form method="post">
                    <button name="edit_btn" value="${restaurant.id}">Edit</button>
                </form>
            </td>
            <td>
                <a href="meals/delete?id=${restaurant.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </thead>
</table>
<br>
<p style="text-align: left">
    <button id="add" formmethod="post">Добавить ресторан</button>
<br>
    <form id="mySelect">
        <td>
            <p>Сегодня вы выбрали ресторан: Панорама</p>
        </td>
    </form>
<%--<br>--%>
<form id="daysSelect">
    <td>
        <p>Ресторан дня (известен после 11:00): Ромашка   </p>
    </td>
</form>
</body>
</html>
