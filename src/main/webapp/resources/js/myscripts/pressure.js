$(function(){
    var datesH = [];
    var pressureH = [];

    var datesD = [];
    var pressureD = [];

    var stockStatePerDay = {
        dates: datesD,
        pressure:pressureD
    };

    var stockStatePerHour = {
        dates: datesH,
        pressure:pressureH
    };

    getDataPerOneDay();
    getDataPerOneHour();

    $("li#pressureOneHour").click(function(){

        $("h3.panel-title").text("Barometrical pressure");

        zingchart.render({
            id: 'myChart',
            data: {
                graphset:[
                    getCloseConfig(stockStatePerHour.dates, stockStatePerHour.pressure),
                ]
            },
            height: 700,
            width: 1100,
            cache:{
                data:true,
            }
        });

        zingchart.bind('myChart', 'label_click', function(e){
            if(stockState.current === e.labelid){
                return;
            }
        });

        clearArrays();
    })

    $("li#pressureOneDay").click(function(){

        $("h3.panel-title").text("Barometrical pressure");

        zingchart.render({
            id: 'myChart',
            data: {
                graphset:[
                    getCloseConfig(stockStatePerDay.dates, stockStatePerDay.pressure),
                ]
            },
            height: 700,
            width: 1100,
            cache:{
                data:true,
            }
        });

        zingchart.bind('myChart', 'label_click', function(e){
            if(stockState.current === e.labelid){
                return;
            }
        });

        clearArrays();
    })

    function getCloseConfig(dates, pressure) {

        return {
            type: 'area',
            backgroundColor: "#333",
            height: 700,
            x: 0,
            y: 0,
            crosshairX:{
                shared: true,
                plotLabel:{
                    backgroundColor: "#bbb",
                    fontColor: "#222",
                    text: "Temperature : %v",
                    fontFamily: "Open Sans",
                    y:0,
                },
                scaleLabel:{
                    fontColor: "#222",
                    fontFamily: "Open Sans",
                    backgroundColor: "#bbb",
                }
            },
            title: {
                text: "SweetHome",
                fontColor: "#fefcff",
                fontFamily: 'Open Sans',
                fontSize: 30,
                align: 'left',
                offsetX: 10
            },
            zoom: {
                shared: true
            },
            plotarea: {
                margin: "60 50 40 50"
            },
            plot: {
                marker:{
                    visible: false
                }
            },
            tooltip:{
                text: "Close : %v",
                backgroundColor: "#BBB",
                borderColor:"transparent"
            },
            scaleY: {
                guide: {
                    visible: true,
                    lineStyle: 'solid',
                    lineColor: "#444"
                },
                values: "740:770:5",
                item: {
                    fontColor: "#ddd",
                    fontFamily: "Open Sans"
                }
            },
            scaleX: {
                guide: {
                    visible: true,
                    lineStyle: 'solid',
                    lineColor: "#444"
                },
                values: dates,
                transform: {
                    type: 'date',
                    all: '%d-%m-%y %H:%i:%s'
                },
                zooming:{
                    shared: true
                },
                item: {
                    fontColor: "#ddd",
                    fontFamily: "Open Sans"
                }
            },
            series : [
                {
                    values: pressure,
                    lineColor: "#fff",
                    lineWidth: 1,
                    backgroundColor:"#b4b4b4 #7000e0"
                }
            ]
        };
    }

    function getDataPerOneHour() {
        $.getJSON("http://178.219.93.93:8888/sweethome/onehour", function (data) {
            $.each(data, function (i, v) {
                $.each(v, function (key, value) {

                    if (key == "date") {
                        datesH.push(value);
                    }
                    if (key == "barPressure") {
                        pressureH.push(value)
                    }
                });
            });
        });
    }

    function getDataPerOneDay() {
        $.getJSON("http://178.219.93.93:8888/sweethome/oneday", function (data) {
            $.each(data, function (i, v) {
                $.each(v, function (key, value) {
                    if (key == "date") {
                        datesD.push(value);
                    }
                    if (key == "barPressure") {
                        pressureD.push(value)
                    }
                });
            });
        });
    }

    function clearArrays(){
        datesD = [];
        datesH = [];
    }
});