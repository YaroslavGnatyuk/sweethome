$(function(){
    var hour = "onehour";
    var day = "oneday";
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

    $(".btn.btn-default.btn-success#fast-backward").click(function(){
        if($("#fast-backward").hasClass("tInsideOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "fastbackward", "inside");
        }

        if($("#fast-backward").hasClass("tInsideOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "fastbackward", "inside");
        }

        if($("#fast-backward").hasClass("tInsideOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "fastbackward", "inside");
        }
    })

    $(".btn.btn-default.btn-success#backward").click(function(){
        if($("#backward").hasClass("tInsideOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "backward", "inside");
        }

        if($("#backward").hasClass("tInsideOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "backward", "inside");
        }

        if($("#backward").hasClass("tInsideOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "backward", "inside");
        }
    })

    $(".btn.btn-default.btn-success#forward").click(function(){
        if($("#forward").hasClass("tInsideOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "forward", "inside");
        }

        if($("#forward").hasClass("tInsideOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "forward", "inside");
        }

        if($("#forward").hasClass("tInsideOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "forward", "inside");
        }
    })

    $(".btn.btn-default.btn-success#fast-forward").click(function(){
        if($("#fast-forward").hasClass("tInsideOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "fastforward", "inside");
        }

        if($("#fast-forward").hasClass("tInsideOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "fastforward", "inside");
        }

        if($("#fast-forward").hasClass("tInsideOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "fastforward", "inside");
        }
    })
/*It's outside temperature*/
    $(".btn.btn-default.btn-success#fast-backward").click(function(){
        if($("#fast-backward").hasClass("tOutsideOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "fastbackward", "outside");
        }

        if($("#fast-backward").hasClass("tOutsideOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "fastbackward", "outside");
        }

        if($("#fast-backward").hasClass("tOutsideOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "fastbackward", "outside");
        }

    })

    $(".btn.btn-default.btn-success#backward").click(function(){
        if($("#backward").hasClass("tOutsideOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "backward", "outside");
        }

        if($("#backward").hasClass("tOutsideOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "backward", "outside");
        }

        if($("#backward").hasClass("tOutsideOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "backward", "outside");
        }
    })

    $(".btn.btn-default.btn-success#forward").click(function(){
        if($("#forward").hasClass("tOutsideOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "forward", "outside");
        }

        if($("#forward").hasClass("tOutsideOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "forward", "outside");
        }

        if($("#forward").hasClass("tOutsideOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "forward", "outside");
        }
    })


    $(".btn.btn-default.btn-success#fast-forward").click(function(){
        if($("#fast-forward").hasClass("tOutsideOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "fastforward", "outside");
        }

        if($("#fast-forward").hasClass("tOutsideOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "fastforward", "outside");
        }

        if($("#fast-forward").hasClass("tOutsideOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "fastforward", "outside");
        }
    })

    /*It's pressure*/
    $(".btn.btn-default.btn-success#fast-backward").click(function(){
        if($("#fast-backward").hasClass("pressureOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "fastbackward", "pressure");
        }

        if($("#fast-backward").hasClass("pressureOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "fastbackward", "pressure");
        }

        if($("#fast-backward").hasClass("pressureOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "fastbackward", "pressure");
        }

    })

    $(".btn.btn-default.btn-success#backward").click(function(){
        if($("#backward").hasClass("pressureOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "backward", "pressure");
        }

        if($("#backward").hasClass("pressureOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "backward", "pressure");
        }

        if($("#backward").hasClass("pressureOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "backward", "pressure");
        }
    })

    $(".btn.btn-default.btn-success#forward").click(function(){
        if($("#forward").hasClass("pressureOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "forward", "pressure");
        }

        if($("#forward").hasClass("pressureOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "forward", "pressure");
        }

        if($("#forward").hasClass("pressureOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "forward", "pressure");
        }
    })


    $(".btn.btn-default.btn-success#fast-forward").click(function(){
        if($("#fast-forward").hasClass("pressureOneHour")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, hour, "fastforward", "pressure");
        }

        if($("#fast-forward").hasClass("pressureOneDay")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, day, "fastforward", "pressure");
        }

        if($("#fast-forward").hasClass("pressureOneMonth")){
            getDataPerSomePeriod(dates,temperatureInside1,temperatureInside2,temperatureOutside,pressure, month, "fastforward", "pressure");
        }
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

    function getDataPerSomePeriod(date, inside1, inside2, outside, pressure, period, direction, currentParameter) {
        var address = "http://178.219.93.93:8888/sweethome/" + period + "/" + direction;

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
                    var scaleForPressure = "730:780:5";

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
})

