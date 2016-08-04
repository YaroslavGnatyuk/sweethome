$(function(){
    var dates = [];
    var volumes = [];
    var closes = [];
    var temperatureOutside = [];
    var barPressure = [];
    
    $.getJSON("http://178.219.93.93:8888/sweethome/temp", function(data){
        console.log("i'm here")
        $.each(data, function(i,v){
           $.each(v, function(key,value){
               if(key=="date"){
                   dates.push(value);
               }
               if(key=="temperatureOutsid"){
                   temperatureOutside.push(value)
               }
               
               if(key=="temperatureInside1"){
                   volumes.push(value)
               }
               
               if(key=="temperatureInside2"){
                   closes.push(value)
               }
               
               if(key=="barPressure"){
                   barPressure.push(value)
               }
           }); 
        });
        
        var stockState = {
        current: '2Y',
        dates: dates,
        closes: closes,
        volumes: volumes
        };

        function getCloseConfig(dates, values, current) {
        return {
        type: 'area',
        backgroundColor: "#333",
        height: 420,
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
        fontColor: "#fff",
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
                values: values,
                lineColor: "#fff",
                lineWidth: 1,
                backgroundColor:"#909090 #313131"
            }
        ],
        labels: [
          {
            x: 490,
            y: 10,
            id: '1W',
            fontColor: (current === '1W') ? "#FFF" : "#777",
            fontSize: "16",
            fontFamily: "Open Sans",
            cursor: "hand",
            text: "1W"
          },
          {
            x: 530,
            y: 10,
            id: '1M',
            fontColor: (current === '1M') ? "#FFF" : "#777",
            fontSize: "16",
            fontFamily: "Open Sans",
            cursor: "hand",
            text: "1M"
          },
          {
            x: 570,
            y: 10,
            id: '6M',
            fontColor: (current === '6M') ? "#FFF" : "#777",
            fontSize: "16",
            fontFamily: "Open Sans",
            cursor: "hand",
            text: "6M"
          },
          {
            x: 610,
            y: 10,
            id: '1Y',
            fontColor: (current === '1Y') ? "#FFF" : "#777",
            fontSize: "16",
            fontFamily: "Open Sans",
            cursor: "hand",
            text: "1Y"
          },
          {
            x: 650,
            y: 10,
            id: '2Y',
            fontColor: (current === '2Y') ? "#FFF" : "#777",
            fontSize: "16",
            fontFamily: "Open Sans",
            cursor: "hand",
            text: "2Y"
          }
        ]
        };
        }

        function getVolumeConfig(dates, values) {
        return {
        type: 'bar',
        height: 80,
        x: 0, 
        y: 400,
        backgroundColor: "#333",
        plotarea: {
        margin: "20 50 20 50"
        },
        source: {
        text: "nasdaq.com",
        fontColor:"#ddd",
        fontFamily: "Open Sans"
        },
        tooltip:{
        visible: false,
        text: "Volume: %v",
        fontFamily: "Open Sans",
        borderColor:"transparent"
        },
        zoom: {
        shared: true
        },
        crosshairX:{
        shared: true,
        scaleLabel:{
          visible: false
        },
        plotLabel:{
          fontFamily: "Open Sans",
          backgroundColor:"#BBB",
          text: "Volume: %v",
          y:0
        }
        },
        scaleX: {
        visible: false,
        zooming: true
        },
        scaleY: {
        visible: false
        },
        series : [
            {
                values: values,
                text: "Volume",
                backgroundColor: "#bbb"
            }
        ]
        };
        }

        zingchart.render({
        id: 'myChart',
        data: {
        graphset:[
          getCloseConfig(stockState.dates, stockState.closes, '2Y'),
//          getVolumeConfig(stockState.dates, stockState.volumes)
        ]
        },
        height: 700, 
        width: 1100
        });


        zingchart.bind('myChart', 'label_click', function(e){
        if(stockState.current === e.labelid){
        return;
        }

        var windowClose = [];
        var windowVolume = [];
        var windowDates = [];
        var cut = 0;
        switch(e.labelid) {
        case '1W': 
          cut = 5;
        break;
        case '1M':
          cut = 20;
        break;
        case '6M': 
          cut = 130;
        break;
        case '1Y': 
          cut = 260;
        break;
        default: 
          cut = stockState.dates.length;
        break;
        }
        windowClose = stockState.closes.slice(stockState.closes.length-cut);
        windowDates = stockState.dates.slice(stockState.dates.length-cut);
//        windowVolume = stockState.volumes.slice(stockState.volumes.length-cut);

        zingchart.exec('myChart', 'setdata', {

        data: {
          graphset:[
            getCloseConfig(windowDates, windowClose, e.labelid),
            getVolumeConfig(windowDates, windowVolume)
          ]
        }
        });

        stockState.current = e.labelid;

        });
        
    });
})
