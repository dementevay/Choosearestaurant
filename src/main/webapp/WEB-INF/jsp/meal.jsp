<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <a href=".">На главную</a>
    <title>Блюдо</title>
</head>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script type="text/javascript" src="resources/js/vote.js" defer></script>
<div id="jumbotron">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <section>
                    <jsp:useBean id="meal" type="com.dementevay.voting.model.Meal" scope="request"/>
                    <form method="post" action="editMeal?${_csrf.parameterName}=${_csrf.token}">
                        <input type="hidden" value="<c:out value="${meal.id}"/>" name="id">
                        <input type="hidden" value="<c:out value="${meal.restaurantId}"/>" name="restaurantId">
                        <input type="hidden" value="<c:out value="${meal.date}"/>" name="dateTime">
                        <input type="text" value="<c:out value="${meal.description}"/>" name="description"> :
                        <input type="number" value="<c:out value="${meal.price}"/>" name="price">
                        <button>Сохранить</button>
                    </form>
                </section>
            </div>
        </div>
    </div>
</div>


</body>
</html>
