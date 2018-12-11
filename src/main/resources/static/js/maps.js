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
    )
    .set(
        "statistic",
        "<tr>\n" +
        "            <th scope=\"col\">№</th>\n" +
        "            <th scope=\"col\">Class name</th>\n" +
        "            <th scope=\"col\">Method name</th>\n" +
        "            <th scope=\"col\">Max run-time</th>\n" +
        "            <th scope=\"col\">Min run-time</th>\n" +
        "            <th scope=\"col\">Average run-time</th>\n" +
        "            <th scope=\"col\">Count</th>\n" +
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
    )
    .set(
        "statistic",
        [
            { "data": "0" },
            { "data": "0" },
            { "data": "1" },
            { "data": "2" },
            { "data": "3" },
            {"data": "4"},
            {"data": "5"}
        ]
    );
