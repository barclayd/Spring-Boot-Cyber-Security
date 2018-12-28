/**
 * Created by c1662491 on 08/12/2017.
 */

$(document).ready(function () {

    // generate bar chart
    function createBarChart(name, beforeLevel, afterLevel) {
        var ctx = document.getElementById("barChart").getContext('2d');
        var barChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: [name],
                datasets: [{
                    label: 'Mood Before',
                    data: [beforeLevel, 0],//[12, 19, 3, 17, 28, 24, 7]
                    backgroundColor: "rgba(153,255,51,1)"
                }, {
                    label: 'Mood After',
                    data: [afterLevel],
                    backgroundColor: "rgba(255,153,0,1)"
                }]
            }
        });
    }

    // list to store the json object, Key "Names" and values
    var varNames = [];
    var varValues = [];

    // variables to store the values in varValues separately
    var name;
    var beforeLevel;
    var afterLevel;

    // function that appends the returning json's "chartMap's" key and value to the variables above
    // to so they chosen individually
    function splitMap(chartMap) {

        $.each(chartMap, function(key, val) {
            varNames.push(key);
            varValues.push(val);
        });

        console.log(">>>>>>>>>>TIMES  {"+varNames+"}\n>>>>>>>>>>>>>>>>>FEELING   {"+varValues);

        // store the activity name, feelingAfter and the feelingBefore;
        name = varValues[0];
        beforeLevel = varValues[1];
        afterLevel = varValues[2];

        // print out to see if the values are correct
        console.log(">>>>>>>>>> NAME:"+name+"\n" +
                    ">>>>>>>>>> BEFORE:"+beforeLevel+"\n" +
                    ">>>>>>>>>> AFTER:"+afterLevel);

        // run the create bar chart method, using the values we just got
        createBarChart(name, beforeLevel, afterLevel);

    }

    // gets the last string in the url after the last "/"
    // which in this case is the patentId
    var url = window.location.href;
    var id = url.substr(url.lastIndexOf("/")+1);

    $.ajaxSetup({cache: false});
    $.ajax({//send the AJAX request
        type: "GET",
        // run this method that is in the Controller
        url: "/api/GET/barchart/data/"+id,
       // dataType: "json",
        cache: false,
        timeout: 600000
        //,encode: true
    })
        .done(function (data) { //what to do if the request is a success.#
            console.log("call to /api/getbarchart " + data);

            console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+data);
            // run this method (go back to top)
            splitMap(data);
        })

        .fail(function (jqXHR, textStatus, errorThrown) { //and what to do if it fails
            console.log("failed");
        });



});