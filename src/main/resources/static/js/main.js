$( function() {
    $( "#datepicker" ).datepicker();
    $( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
} );

$(document).ready( function () {

    let pathCondition = false;
    let headerTableFiles = "<tr>\n" +
        "            <th scope=\"col\">№</th>\n" +
        "            <th scope=\"col\">Name</th>\n" +
        "            <th scope=\"col\">Size</th>\n" +
        "            <th scope=\"col\">Date destroying</th>\n" +
        "            <th scope=\"col\">Date load</th>\n" +
        "        </tr>";
    let headerTableClasses = "";


    if ($("#table_id").length)
        pathCondition = true;

    let filesTable = function () {
        $("#table_id>thead").html(headerTableFiles);
        $('#table_id').DataTable({
            "ajax": {
                url: "/tables/files",
                type: "GET",
                dataSrc: ""
            },
            "columns": [
                { "data": "id" },
                { "data": "name" },
                { "data": "weight" },
                {
                    "data": "saveTime",
                    "render": function(data) {
                        return moment.unix(data).format("DD/MM/YYYY HH:mm")
                    }
                },
                {
                    "data": "nowDate",
                    "render": function(data) {
                        return moment.unix(data).format("DD/MM/YYYY HH:mm")
                    }
                }
            ]
        });
    };

    if (pathCondition)
        filesTable();
    pathCondition = false;



    $(document).on("click", ".pg-file", function (event) {
        event.preventDefault();
        filesTable();
    });

    $(document).on("click",".pg-classes", function (event) {
        event.preventDefault();
        $('#table_id').DataTable({
            "ajax": {
                url: "/tables/classes",
                type: "GET",
                dataSrc: ""
            }
        });
    })
});
