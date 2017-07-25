<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vote</title>
    <h1 align="center">Выбор ресторана для обеда:</h1>
    <h2 align="center">(голосование проходит до 11:00)</h2>
</head>
<body>
<form id="user-name-label" method="post">
    <p><select>
        <option selected value disabled>Выберите пользователя</option>
        <option value="Админ">Админ</option>
        <option value="Пользователь 1">Пользователь 1</option>
        <option value="Пользователь 2">Пользователь 2</option>
        <option value="Пользователь 3">Пользователь 3</option>
    </select></p>
    <%--<p><input type="submit" value="Отправить"></p>--%>
</form>

<form method="post" id="dateTimeForm">
    <td>
        <p>Сейчас: <input type="datetime-local" name="dateTimeNow" size="20" value="2017-12-31T01:02"></p>
        <%--<p><input type="submit" name="Обновить"></p>--%>
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

    <c:forEach items="${meals_list}" var="me" varStatus="status">
        <%--<jsp:useBean id="me" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
        <tr class="${me.exceed ? 'exceeded':'nonexceeded'}">
            <td>${me.id}</td>
            <td><%=TimeUtil.formatDateTime(me.getDateTime())%></td>
            <td>${me.description}</td>
            <td>${me.calories}</td>
            <td>${me.exceed}</td>
            <td>
                <form method="post">
                    <button name="edit_btn" value="${me.id}">Edit</button>
                </form>
            </td>
            <td>
                <form method="post">
                    <button name="delete_btn" value="${me.id}">Delete</button>
                </form>
            </td>
        </tr>--%>
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
