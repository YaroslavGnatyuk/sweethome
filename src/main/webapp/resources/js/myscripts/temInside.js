$(function(){
    var datesD = [];
    var temperatureInside1D = [];
    var temperatureInside2D = [];
    var temperatureOutsideD = [];
    var pressureD = [];

    var datesH = [];
    var temperatureInside1H = [];
    var temperatureInside2H = [];
    var temperatureOutsideH = [];

    var stockStateOneDay = {
        current: '2Y',
        dates: datesD,
        temp1:temperatureInside1D,
        temp2: temperatureInside2D,
        tempoutside: temperatureOutsideD,
    };

    var stockStateOneHour = {
        dates: datesH,
        temp1:temperatureInside1H,
        temp2: temperatureInside2H,
        tempoutside: temperatureOutsideH,
    };

    getDataPerOneDay();
    getDataPerOneHour();

    $("li#tInsideOneDay").click(function(){
        $("h3.panel-title").text("Temperature inside");
        zingchart.render({
            id: 'myChart',
            data: {
                graphset:[
                    getCloseConfig(stockStateOneDay.dates, stockStateOneDay.temp1,stockStateOneDay.temp2),
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

    $("li#tInsideOneHour").click(function(){
        zingchart.render({
            id: 'myChart',
            data: {
                graphset:[
                    getCloseConfig(stockStateOneHour.dates, stockStateOneHour.temp1,stockStateOneHour.temp2),
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

    $("li#tOutsideOneHour").click(function(){
        zingchart.render({
            id: 'myChart',
            data: {
                graphset:[
                    getCloseConfig(stockStateOneHour.dates, stockStateOneHour.tempoutside),
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

    $("li#tOutsideOneDay").click(function(){
        zingchart.render({
            id: 'myChart',
            data: {
                graphset:[
                    getCloseConfig(stockStateOneDay.dates, stockStateOneDay.tempoutside),
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

    function getCloseConfig(dates, temperatureInside1, temperatureInside2, temperatureOutside) {

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
                values: "-30:50:5",
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
                    values: temperatureInside1,
                    lineColor: "#fff",
                    lineWidth: 1,
                    backgroundColor:"#b4b4b4 #7000e0"
                },
                {
                    values: temperatureInside2,
                    lineColor: "#fff",
                    lineWidth: 1,
                    backgroundColor:"#b4b4b4 #7000e0"
                },
                {
                    values: temperatureOutside,
                    lineColor: "#fff",
                    lineWidth: 1,
                    backgroundColor:"#b4b4b4 #7000e0"
                }
            ]
        };
    }

    function getDataPerOneDay() {
        $.getJSON("http://178.219.93.93:8888/sweethome/oneday", function (data) {
            $.each(data, function (i, v) {
                $.each(v, function (key, value) {

                    if (key == "date") {
                        datesD.push(value);
                    }

                    if (key == "temperatureInside1") {
                        temperatureInside1D.push(value)
                    }

                    if (key == "temperatureInside2") {
                        temperatureInside2D.push(value)
                    }

                    if (key == "temperatureOutside") {
                        temperatureOutsideD.push(value)
                    }
                });
            });
        });
    }

    function getDataPerOneHour() {
        $.getJSON("http://178.219.93.93:8888/sweethome/onehour", function (data) {
            $.each(data, function (i, v) {
                $.each(v, function (key, value) {

                    if (key == "date") {
                        datesH.push(value);
                    }

                    if (key == "temperatureInside1") {
                        temperatureInside1H.push(value)
                    }

                    if (key == "temperatureInside2") {
                        temperatureInside2H.push(value)
                    }

                    if (key == "temperatureOutside") {
                        temperatureOutsideH.push(value)
                    }
                });
            });
        });
    }

    function clearArrays(){
        datesD = [];
        temperatureInside1D = [];
        temperatureInside2D = [];
        temperatureOutsideD = [];

        datesH = [];
        temperatureInside1H = [];
        temperatureInside2H = [];
        temperatureOutsideH = [];
    }
});

