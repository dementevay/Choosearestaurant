<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script type="text/javascript" src="resources/js/vote.js" defer></script>

<div id="jumbotron">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <h1>Выбор ресторана для обеда:</h1>
                <h4>(голосование проходит до 11:00)</h4>
            </div>
        </div>
    </div>
</div>

<div id="headerwrap">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="col-lg-8">
                    <form method="post" name="dateTime">
                        <p>Сейчас: <input type="datetime-local" name="dateTime" size="16" value=${dateTime}>
                            <sec:csrfInput/>
                            <input type="submit" value="Установить время">
                        <p style="color: #8c8c8c">Тестовые данные только для 26.07.2017</p>
                        </p>
                        <%--<p><input type="submit" name="Применить"></p>--%>
                    </form>
                </div>
                <div class="col-4">
                    <button onclick="reset()">
                        <b>Заполнить тестовыми данными
                            <br>= RESET =</b>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<%-- Эксперименты с полем для даты --%>
<%--<div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            function setDateTimeInput() {
                var input = document.getElementById('datetimepicker1');
            }

            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
    </div>
</div>

<form:form class="form-horizontal" id="filter">
    <div class="form-group">
        <label class="control-label col-sm-3" for="startDate">
            <spring:message code="meal.startDate"/>:</label>

        <div class="col-sm-3">
            <input class="form-control" name="startDate" id="startDate">
        </div>

    </div>

</form:form>

</h2>--%>
<%-- END --%>

<%-- Старый вариант таблицы - html --%>
<%--<style>
    .active_vote {
        color: red;
    }

    .normal {
        color: green;
    }
</style>


<div id="table">
    <div class="container centered">
        <div class="row centered">
            <div class="col-sm-12  col-md-12">

                <jsp:useBean id="user_vote" type="com.dementevay.voting.model.Vote" scope="request"/>

                <table class="table table-striped display">
                    <caption><h2 style="color: #0f0f0f">Голосование:</h2></caption>
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


                <p align="left"><a href="editRestaurant?id=0" class="btn btn-success btn-lg">
                    <i class="glyphicon glyphicon-plus"></i> Добавить ресторан</a></p>

                <br>


                <jsp:useBean id="winner" type="java.lang.String" scope="request"/>
                <form id="daysSelect">
                    <td>
                        <p align="left" style="font-size: 20px">
                        Ресторан дня (известен после 11:00): <b>${winner}</b></p>
                    </td>
                </form>

            </div>
        </div>
    </div>
</div>--%>
<%--  END --%>
<br><br><br>
<hr>
<%-- Пробуем tabledata --%>
<div id="table">
    <div class="container centered">
        <div class="row centered">
            <div class="col-sm-12  col-md-12">
                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>menu</th>
                        <th>vote</th>
                        <th>edit</th>
                        <th>del</th>
                    </tr>
                    </thead>
                </table>

                <p align="left"><a onclick="updateRow(0)" class="btn btn-success btn-lg">
                    <i class="glyphicon glyphicon-plus"></i> Добавить ресторан</a></p>

                <br>


                <jsp:useBean id="winner" type="java.lang.String" scope="request"/>
                <form id="daysSelect">
                    <td>
                        <p align="left" style="font-size: 20px">
                            Ресторан дня (известен после 11:00): <b>${winner}</b></p>
                    </td>
                </form>

            </div>
        </div>
    </div>
</div>
<%-- END --%>

<%-- Modal window - для редактирования записи --%>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"><spring:message code="restaurants.edit"/></h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="id" name="id">
                    <%--1 Ресторан: Берёзка--%>
                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3"><spring:message
                                code="meal.description"/></label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="<spring:message code="meal.description"/>">
                        </div>
                    </div>
                </form:form>
                <form:form class="form-horizontal" id="detailsFormBody">
                    <%--2--%>
                    <div id="divbody">
                        <hr>
                    </div>
                    <%-- <div class="col-xs-1">
                         <button class="btn btn-primary" type="button" onclick="save()">
                             <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                         </button>
                     </div>--%>
                    <div class="col centered">
                        <button class="btn btn-primary" id="addmealButton" type="button" onclick="addMeal()">
                            <span class="glyphicon glyphicon-plus"> Добавить блюдо</span>
                        </button>
                    </div>
                    <br>
                    <%--<div class="form-group">
                        <label for="menu" class="control-label col-xs-3"><spring:message code="meal.meal_cost"/></label>

                        <button class="btn btn-primary" type="button" onclick="save()">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>

                        <div>
                            <div class="col-xs-5">
                                <input type="text" class="form-control" id="menu" name="menu" placeholder="блюдо">
                            </div>
                            <div class="col-xs-4">
                                <input type="number" class="form-control" id="price" name="price" placeholder="цена">
                            </div>
                        </div>
                    </div>--%>
                    <%--<div align="right" class="form-group">
                        <label for="menu_name" class="control-label col-xs-3"></label>

                        <div class="col-xs-5">
                            <input type="text" class="form-control" id="menu_name" name="name" placeholder="блюдо">
                        </div>
                        <div class="col-xs-4">
                            <input type="number" class="form-control" id="menu_cost" name="cost" placeholder="цена">
                        </div>
                    </div>--%>
                    <%--3--%>
                    <div class="panel-footer centered" style="background-color: white">
                        <br>
                        <div class="col-xs-offset-9">
                            <button class="btn btn-primary" type="button" onclick="save()">
                                <span class="glyphicon glyphicon-ok"> Сохранить</span>
                            </button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
<%--  END --%>


<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
