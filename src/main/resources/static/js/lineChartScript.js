/**
 * Created by c1662491 on 08/12/2017.
 */

$(document).ready(function () {



 //////////////LINE CHART////////////////////////////////////////////////////
    var times = [];
    var feelingLevel = [];
    var colour1 = "#e55977";

    console.log("it is defined")

    function splitMap(chartMap) {

        $.each(chartMap, function(key, val) {
            times.push(key);
            feelingLevel.push(val);
        });
    }

    function createLineChart(times, feelingLevel) {
        var ctx = document.getElementById("lineChart").getContext('2d');
        var lineChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: times,// X axis the times they were added
                datasets: [{
                    label: '# Mood',
                    data: feelingLevel, // Y axis feeling Level
                    fill: true,
                    lineTension: 0,
                    borderColor: colour1, //[
//                    'rgba(255, 99, 132, 0.2)',
//                    'rgba(54, 162, 235, 0.2)',
//                    'rgba(255, 206, 86, 0.2)',
//                    'rgba(75, 192, 192, 0.2)',
//                    'rgba(153, 102, 255, 0.2)',
//                    'rgba(255, 159, 64, 0.2)'
                },
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
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
        })};


    console.log(times);
    console.log(feelingLevel);


    createLineChart(times, feelingLevel);
    $(document).ready(function () {
        $("#target").click(function () {
            colour1 = "#000000";
            createLineChart(times, feelingLevel);
        });
    });
    console.log("times "+times+"\nFeelingLevel "+feelingLevel);

    var url = window.location.href;
    var id = url.substr(url.lastIndexOf("/")+1);

    $.ajaxSetup({cache: false});
    $.ajax({//send the AJAX request
        type: "GET",
        url: "/api/logged/moodTime/patient/"+id,
        // dataType: "json"
        cache: false,
        timeout: 600000
        //,encode: true
    })
        .done(function (data) { //what to do if the request is a success.#
            console.log("call to /api/num " + data);

            console.log(">>>>>> "+data);
            splitMap(data);
            createLineChart(times, feelingLevel);
        })

        .fail(function (jqXHR, textStatus, errorThrown) { //and what to do if it fails
            console.log("failed");
        });


///////////////////////////////////////////////////////////////////////////////////////


});