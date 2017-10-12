var ajaxRestaurantUrl = "ajax/restaurants/";
var ajaxMealUrl = "ajax/meals/";
var votingUrl = "ajax/votes/";
var idRestaurantMyVote = votingUrl + "getIdRestaurantMyVote/";
var deleteRestaurantUrl = "delete/";
var deleteMealUrl = "delete/";
var form;
var formBody;
var list;
var myRestaurant;
var table_params;
var datatableApi;
var datatableBody;
var restaurant;



$(document).ready(function () {
    $.ajax({
        url: idRestaurantMyVote,
        type: "POST",
        success: function (data){
            myRestaurant = data;
        }
    })

    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": ajaxRestaurantUrl,
            "dataSrc": ""
        },
        "columns": [
            {"data": "id"},
            {"data": "name"},
            {"render": listmenu},
            {
                "render": renderVoteBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderEditBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ],
        "createdRow": function (row, data, dataIndex) {
            $(row).addClass(data.id === myRestaurant ? 'active_vote' : 'normal');
        }
    });
});

function save() {

    formBody = $('#detailsFormBody');
    form = $('#detailsForm');
    restaurantId = $('#detailsForm').serializeArray()[0].value;

    //сохраняем ресторан (id, name)
    $.ajax({
        url: ajaxRestaurantUrl,
        type: "POST",
        data: form.serialize(),
        success: function () {
            if (restaurantId == 0) {
                updateTable();
            }
            //$('#editRow').modal('hide');
            // updateTable();
            // successNoty('common.saved');
        }
    });

    //сохраняем массив еды

    var menu = formBody.serializeArray();
    var list = [];
    var meal;
    for (i = 0; i < menu.length; i += 5) {
        list.push(meal = {
            id: menu[i].value,
            restaurantId: menu[i + 1].value,
            description: menu[i + 2].value,
            price: menu[i + 3].value,
            date: menu[i + 4].value
        });
    }

    $.ajax({
        url: ajaxMealUrl + "saveMeals",
        type: "POST",
        data: JSON.stringify(list),
        //dataType: "json",
        contentType: "application/json",
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
        }
    });




}

function renderVoteBtn(data, type, row) {
    if (type === 'display') {
        return '<a  onclick="votesss('+ row.id +')">' +
            '<span class="glyphicon glyphicon-check" aria-hidden="true"></span></a>';
    }
}

function renderEditBtn(data, type, row) {
    if (type === 'display') {
        return '<a onclick="updateRow(' + row.id + ');">' +
            '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>';
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === 'display') {
        return '<a onclick="deleteRow(' + row.id + ');">' +
            '<span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></a>';
    }
}
var isNew
function updateRow(restaurantId) {
    // alert если нет прав

    $.get(ajaxRestaurantUrl + restaurantId, function (data) {
        isNew = (restaurantId === 0);
        $("input[name='id']").val(restaurantId);
        $("input[name='name']").val(isNew ? "" : data.name);
        $('#divbody').empty();

        for (i = 0; i < data.menu.length; i++) {
            $('#divbody').append("<div class=\"form-group\">\n" +
                "<div class='col-xs-2'></div><label for=\"menu\" class=\"control-label col-xs-1\" style='align-self: center'><spring:message code=\"meal.meal_cost\"/>" +
                "<a class=\"btn btn-danger btn-xs\"><span class=\"glyphicon glyphicon-remove\" onclick='deleteMeal("+ data.menu[i].id +")'></span> </a>" +
                "</label>\n" +
                "\n" +
                "                        <div>\n" +
                "                            <div class=\"col-xs-5\">\n" +
                "                                <input type=\"hidden\" class=\"form-control\" id=\"id\" name=\"id\" placeholder=\"блюдо\" value=\"" + data.menu[i].id + "\">\n" +
                "                                <input type=\"hidden\" class=\"form-control\" id=\"restaurantId\" name=\"restaurantId\" placeholder=\"блюдо\" value=\"" + data.menu[i].restaurantId + "\">\n" +
                "                                <input type=\"text\" class=\"form-control\" id=\"descriprion\" name=\"descriprion\" placeholder=\"блюдо\" value=\"" + data.menu[i].description + "\">\n" +
                "                            </div>\n" +
                "                            <div class=\"col-xs-4\">\n" +
                "                                <input type=\"number\" class=\"form-control\" id=\"price\" name=\"price\" placeholder=\"цена\" value=\"" + data.menu[i].price + "\">\n" +
                "                                <input type=\"hidden\" class=\"form-control\" id=\"date\" name=\"date\" placeholder=\"блюдо\" value=\"" + data.menu[i].date + "\">\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>");

        }

        $('#editRow').modal();

        isNew ? document.getElementById("addmealButton").disabled = true :
            document.getElementById("addmealButton").disabled = false;

    });


    /*var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });*/
}
var restaurantId;
function addMeal() {
    restaurantId = $('#detailsForm').serializeArray()[0].value;
    $('#divbody').append("<div class=\"form-group\">\n" +
        "                        <label for=\"menu\" class=\"control-label col-xs-3\"><spring:message code=\"meal.meal_cost\"/></label>\n" +
        "\n" +
        "                        <div>\n" +
        "                            <div class=\"col-xs-5\">\n" +
        "                                <input type=\"hidden\" class=\"form-control\" id=\"id\" name=\"id\" placeholder=\"блюдо\" value=\"0\">\n" +
        "                                <input type=\"hidden\" class=\"form-control\" id=\"restaurantId\" name=\"restaurantId\" value=\"" + restaurantId + "\">\n" +
        "                                <input type=\"text\" class=\"form-control\" id=\"descriprion\" name=\"descriprion\" placeholder=\"блюдо\" >\n" +
        "                            </div>\n" +
        "                            <div class=\"col-xs-4\">\n" +
        "                                <input type=\"number\" class=\"form-control\" id=\"price\" name=\"price\" placeholder=\"цена\" value=\"0\">\n" +
        "                                <input type=\"hidden\" class=\"form-control\" id=\"date\" name=\"date\" placeholder=\"блюдо\" value=\"1970-01-01\">\n" +
        "                            </div>\n" +
        "                        </div>\n" +
        "                    </div>");
}

function deleteRow(id) {
    $.ajax({
        url: deleteRestaurantUrl + id,
        type: 'POST',
        success: function () {
            updateTable();
        }
    });
}

function deleteMeal(id) {
    $.ajax({
        url: ajaxMealUrl + deleteMealUrl + id,
        type: 'POST',
        success: function () {
            updateTable();
            restaurantId = $('#detailsForm').serializeArray()[0].value;
            updateRow(restaurantId);
        }
    });
}

function votesss(id) {
    $.ajax({
        type: "POST",
        url: votingUrl + id,
        dataType: "text",
        success: function (data) {
            if (data !== ""){
                updateTable();
                myRestaurant = id;
            }
            // $(row).addClass('active_vote');
            //successNoty('common.saved');
        }
    });
}

function listmenu(data, type, row) {
    var array = [];
    for (var i = 0; i < row.menu.length; i++) {
        array.push(row.menu[i].description);
        array.push(" : ");
        array.push(row.menu[i].price);
        array.push('<br>');
    }
    return array.join("");
}

function updateTable() {
    $.ajax({
        cache: false,
        type: 'GET',
        url: ajaxRestaurantUrl,
        success: updateTableByData
    });
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function closeNoty() {
    /*if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }*/
}

function successNoty(key) {
    /*closeNoty();
    noty({
        text: key,
        type: 'success',
        layout: 'bottomRight',
        timeout: 1500
    });*/
}

function reset() {
    $.ajax({
        type: "POST",
        url: ajaxRestaurantUrl + "reset",
        success: function () {
            updateTable();
        }
    })
}
