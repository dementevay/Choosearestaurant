var ajaxUrl = "/ajax/";
var table;
var table_params;

(function ($, undefined) {
    $(function () {
        table = $('#datatable');
        table_params = {
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "menu1"},
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
            "order": [ [0, "desc"] ]
            /*,
            "createdRow": function (row, data, dataIndex) {
                $(row).addClass(data.id === 0 ? 'active_vote' : 'normal');
            }*/
        }
    });
    $('#datatable').DataTable(table_params);
})(jQuery);

function save() {
}

function renderEditBtn() {
}

function renderDeleteBtn() {
}

function renderVoteBtn() {
}


