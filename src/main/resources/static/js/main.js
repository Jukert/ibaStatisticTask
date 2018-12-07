$( function() {
    $( "#datepicker" ).datepicker();
    $( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
} );

$(document).ready( function () {
    let pathName = window.location.pathname;

    let headersMap = new Map();
    let columnsMap = new Map();
    headersMap
        .set(
            "files",
            "<tr>\n" +
            "            <th scope=\"col\">№</th>\n" +
            "            <th scope=\"col\">Name</th>\n" +
            "            <th scope=\"col\">Size</th>\n" +
            "            <th scope=\"col\">Date destroying</th>\n" +
            "            <th scope=\"col\">Date load</th>\n" +
            "        </tr>"
        )
        .set(
            "classes",
            "<tr>\n" +
            "            <th scope=\"col\">№</th>\n" +
            "            <th scope=\"col\">Class name</th>\n" +
            "            <th scope=\"col\">Method name</th>\n" +
            "            <th scope=\"col\">User</th>\n" +
            "            <th scope=\"col\">Method run-time (Minute:Second) </th>\n" +
            "        </tr>"
        )
        .set(
            "fileById",
            "<tr>\n" +
            "            <th scope=\"col\">№</th>\n" +
            "            <th scope=\"col\">Class name</th>\n" +
            "            <th scope=\"col\">Method name</th>\n" +
            "            <th scope=\"col\">User</th>\n" +
            "            <th scope=\"col\">Method run-time (Minute:Second) </th>\n" +
            "        </tr>"
        );
    columnsMap
        .set(
            "files",
            [
                { "data": "id" },
                { "data": function (row) {
                        return "<a href='' class='file-name' data-id='"+row.id+"' >"+row.name+"</a>";
                    }

                },
                { "data": "weight" },
                {
                    "data": "saveTime",
                    "render": function(data) {
                        return moment.unix(data).format("DD/MM/YYYY HH:mm")
                    }
                },
                {
                    "data": "dateLoad",
                    "render": function(data) {
                        return moment.unix(data).format("DD/MM/YYYY HH:mm")
                    }
                }
            ]
        )
        .set(
            "classes",
            [
                { "data": "id" },
                { "data": function (row) {
                        return row.className;
                    }
                },
                { "data": "methodName" },
                { "data": "user" },
                {
                    "data": function (row) {
                        return moment.unix(row.endTime-row.startTime).format("mm:ss")
                    }
                }
            ]
        )
        .set(
            "fileById",
            [
                { "data": "id" },
                { "data": "className" },
                { "data": "methodName" },
                { "data": "user" },
                {
                    "data": function (row) {
                        return moment.unix(row.endTime-row.startTime).format("mm:ss")
                    }
                }
            ]
        );

    let loadTable = function (columns,header, page) {
        $("#table_id>thead").html(header);
        $('#table_id').DataTable({
            destroy:true,
            "ajax": {
                url: "/tables/api/"+page,
                type: "GET",
                dataSrc: ""
            },
            "columns": columns
        });
    };


    if ($("#table_id").length){
        let page = pathName.split("/")[2];
        let column = columnsMap.get(page);
        let header = headersMap.get(page);
        if (column != undefined && header != undefined)
            loadTable(column,header,page);
        else {
            //main tables
        }
    }

    ///file/{id}
    $(document).on("click",".file-name", function (event) {
        event.preventDefault();
        let column = columnsMap.get("fileById");
        let header = headersMap.get("fileById");
        if (column != undefined && header != undefined)
            loadTable(column,header,"files/"+$(this).attr("data-id"));
        else {
            //error
        }
    })

});
