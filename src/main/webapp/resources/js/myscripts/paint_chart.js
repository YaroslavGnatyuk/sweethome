$(function(){
    var day = "oneday";
    var hour = "onehour";
    var month = "onemonth";

    var dates = [];
    var temperatureInside1 = [];
    var temperatureInside2 = [];
    var temperatureOutside = [];
    var pressure = [];

    var stockState = {
        dates: dates,
        temp1:temperatureInside1,
        temp2: temperatureInside2,
        tempOutside: temperatureOutside,
        pressure : pressure
    };

    $("#main").click(function(){
        hideButtonsDirection();
        $("#myChart").remove();
    })

    $("li#tInsideOneHour").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("tInsideOneHour");
        $(".btn.btn-default.btn-success#backward").addClass("tInsideOneHour");
        $(".btn.btn-default.btn-success#forward").addClass("tInsideOneHour");

        $(".btn.btn-default.btn-success#fast-forward").addClass("tInsideOneHour");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure,hour, "inside");
    })

    $("li#tInsideOneDay").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("tInsideOneDay");
        $(".btn.btn-default.btn-success#backward").addClass("tInsideOneDay");
        $(".btn.btn-default.btn-success#forward").addClass("tInsideOneDay");
        $(".btn.btn-default.btn-success#fast-forward").addClass("tInsideOneDay");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure,day, "inside");
    })

    $("li#tInsideOneMonth").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("tInsideOneMonth");
        $(".btn.btn-default.btn-success#backward").addClass("tInsideOneMonth");
        $(".btn.btn-default.btn-success#forward").addClass("tInsideOneMonth");
        $(".btn.btn-default.btn-success#fast-forward").addClass("tInsideOneMonth");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure,month, "inside");
    })

    $("li#tOutsideOneHour").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("tOutsideOneHour");
        $(".btn.btn-default.btn-success#backward").addClass("tOutsideOneHour");
        $(".btn.btn-default.btn-success#forward").addClass("tOutsideOneHour");
        $(".btn.btn-default.btn-success#fast-forward").addClass("tOutsideOneHour");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "outside");
    })

    $("li#tOutsideOneDay").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("tOutsideOneDay");
        $(".btn.btn-default.btn-success#backward").addClass("tOutsideOneDay");
        $(".btn.btn-default.btn-success#forward").addClass("tOutsideOneDay");
        $(".btn.btn-default.btn-success#fast-forward").addClass("tOutsideOneDay");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "outside");
    })

    $("li#tOutsideOneMonth").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("tOutsideOneMonth");
        $(".btn.btn-default.btn-success#backward").addClass("tOutsideOneMonth");
        $(".btn.btn-default.btn-success#forward").addClass("tOutsideOneMonth");
        $(".btn.btn-default.btn-success#fast-forward").addClass("tOutsideOneMonth");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "outside");
    })
    /*----------------------------------------------------------*/
    $("li#pressureOneHour").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("pressureOneHour");
        $(".btn.btn-default.btn-success#backward").addClass("pressureOneHour");
        $(".btn.btn-default.btn-success#forward").addClass("pressureOneHour");
        $(".btn.btn-default.btn-success#fast-forward").addClass("pressureOneHour");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "pressure");
    })

    $("li#pressureOneDay").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("pressureOneDay");
        $(".btn.btn-default.btn-success#backward").addClass("pressureOneDay");
        $(".btn.btn-default.btn-success#forward").addClass("pressureOneDay");
        $(".btn.btn-default.btn-success#fast-forward").addClass("pressureOneDay");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "pressure");
    })

    $("li#pressureOneMonth").click(function(){
        removeAllAddedClasses();
        showButtonsDirection();
        $(".panel.panel-default.panel-table.main_img").remove();
        addDivForChart();

        $(".btn.btn-default.btn-success#fast-backward").addClass("pressureOneMonth");
        $(".btn.btn-default.btn-success#backward").addClass("pressureOneMonth");
        $(".btn.btn-default.btn-success#forward").addClass("pressureOneMonth");
        $(".btn.btn-default.btn-success#fast-forward").addClass("pressureOneMonth");

        getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "pressure");
    })

    function clearArrays(){
        dates = [];
        temperatureInside1 = [];
        temperatureInside2 = [];
        temperatureOutside = [];
        pressure = [];
    }

    function painChart(date,temperature1,temperature2,temperatureOutside,pressure, scale) {

        zingchart.render({
            id: 'myChart',
            data: {
                graphset: [
                    getCloseConfig(date, temperature1, temperature2,temperatureOutside,pressure, scale)
                ]
            },
            height: 700,
            width: 1100,
            cache: {
                data: true,
            }
        });

        zingchart.bind('myChart', 'label_click', function (e) {
            if (stockState.current === e.labelid) {
                return;
            }
        });
    }

    function removeAllAddedClasses (){
    $(".btn.btn-default.btn-success")
        .removeClass("tOutsideOneHour")
        .removeClass("tOutsideOneDay")
        .removeClass("tOutsideOneMonth")
        .removeClass("tInsideOneHour")
        .removeClass("tInsideOneDay")
        .removeClass("tInsideOneMonth")
        .removeClass("pressureOneHour")
        .removeClass("pressureOneDay")
        .removeClass("pressureOneMonth")
    }


    function getDataPerSomePeriod(date, inside1, inside2, outside, pressure, period, currentParameter) {
        var address = "http://178.219.93.93:8888/sweethome/" + period;

        $.ajax({
            url:address,
            async:true,
            dataType:"json",
            beforeSend:function(){
                showGifLoading();
            },
            success:function(data){
                $.each(data, function (i, v) {
                    $.each(v, function (key, value) {

                        if (key == "date") {
                            date.push(value);
                        }

                        if (key == "temperatureInside1" && (currentParameter.localeCompare("inside") == 0)) {
                            inside1.push(value)
                        }

                        if (key == "temperatureInside2" && (currentParameter.localeCompare("inside") == 0)) {
                            inside2.push(value)
                        }

                        if (key == "temperatureOutside" && (currentParameter.localeCompare("outside") == 0)) {
                            outside.push(value)
                        }
                        if (key == "barPressure" && (currentParameter.localeCompare("pressure") == 0)) {
                            pressure.push(value)
                        }
                    });
                })

                stockState.dates = dates;
                stockState.temp1 = inside1;
                stockState.temp2 = inside2;
                stockState.tempOutside = outside;
                stockState.pressure = pressure;
            },
            complete:function(xhr){
                if (xhr.readyState==4){
                    var scaleForTemperature = "-30:50:5";
                    var scaleForPressure = "740:770:5";

                    hideGifLoading();

                    if(currentParameter.localeCompare("inside") == 0) {
                        painChart(stockState.dates, stockState.temp1, stockState.temp2,
                            stockState.tempOutside, stockState.pressure,scaleForTemperature);
                    }

                    if(currentParameter.localeCompare("outside") == 0) {
                        painChart(stockState.dates, stockState.temp1, stockState.temp2,
                            stockState.tempOutside, stockState.pressure,scaleForTemperature);
                    }

                    if(currentParameter.localeCompare("pressure") == 0) {
                        painChart(stockState.dates, stockState.temp1, stockState.temp2,
                            stockState.tempOutside, stockState.pressure,scaleForPressure);
                    }

                    clearArrays();
                }
            }
        });
    }

    function showGifLoading(){
        $(".loading").removeClass("hide");
    }

    function hideGifLoading(){
        $(".loading").addClass("hide");
    }

    function hideButtonsDirection(){
        $("#fast-backward").addClass("hideThisSelector");
        $("#backward").addClass("hideThisSelector");
        $("#fast-forward").addClass("hideThisSelector");
        $("#forward").addClass("hideThisSelector");
    }

    function showButtonsDirection(){
        $("#fast-backward").removeClass("hideThisSelector");
        $("#backward").removeClass("hideThisSelector");
        $("#fast-forward").removeClass("hideThisSelector");
        $("#forward").removeClass("hideThisSelector");
    }

    function addDivForChart(){
        var my_chart = $('<div/>',{
            id:'myChart'
        })

        if(!($(".table-responsive a[myChart]").length)){
            $(".table-responsive").append(my_chart);
        }
    }
});


