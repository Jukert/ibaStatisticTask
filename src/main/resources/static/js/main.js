$(function () {
    $("#datepicker").datepicker();
    $("#datepicker").datepicker("option", "dateFormat", "yy-mm-dd");
});
$(document).ready(function () {
    let pathName = window.location.pathname;
    let loadTable = function (columns, header, page) {
        $(".table-header>h1").text(ucFirst(page));
        $("#table_id>thead").html(header);
        let t = $('#table_id').DataTable({
            destroy: true,
            "ajax": {
                url: "/api/" + page,
                type: "GET",
                dataSrc: "",
                "order": [[1, 'asc']]
            },
            "columns": columns
        });
        t.on('order.dt search.dt', function () {
            t.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
                cell.innerHTML = i + 1;
            });
        }).draw();
    };

    function ucFirst(str) {
        if (!str) return str;
        return str[0].toUpperCase() + str.slice(1);
    }

    let loadCharts = function () {
        let ctx = document.getElementById("round").getContext('2d');
        let bar = document.getElementById("line").getContext('2d');
        $.ajax({
            url: "/api/pies",
            type: "GET",
            success: function (data) {
                let chartPie = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: ["Fill Memory", "Free Memory"],
                        datasets: [{
                            label: 'Memory',
                            data: [data.fill, data.free],
                            backgroundColor: [
                                'rgb(255, 99, 132)',
                                'rgba(54, 162, 235, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)',
                                'rgba(54, 162, 235, 1)'
                            ],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        }
                    }
                });
            }
        });
        $.ajax({
            url: "/api/bars",
            type: "GET",
            success: function (data) {
                let methodName = Array();
                let time = Array();
                data.forEach(o => {
                    methodName.push(o.methodName);
                    time.push(o.endTime - o.startTime);
                });
                let charLines = new Chart(bar, {
                    type: 'line',
                    data: {
                        labels: methodName,
                        datasets: [{
                            label: 'Statistic run-time method',
                            data: time,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)'
                            ],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        }
                    }
                });
            }
        });
    };
    let page = pathName.split("/");
    if ($("#table_id").length) {
        let column = columnsMap.get(page[2]);
        let header = headersMap.get(page[2]);
        if (column != undefined && header != undefined)
            loadTable(column, header, page[2]);
    }
    if (page[1] == "charts")
        loadCharts()
    ///file/{id}
    $(document).on("click", ".file-name", function (event) {
        event.preventDefault();
        let column = columnsMap.get("fileById");
        let header = headersMap.get("fileById");
        if (column != undefined && header != undefined) {
            loadTable(column, header, "files/" + $(this).attr("data-id"));
        }
    });
});