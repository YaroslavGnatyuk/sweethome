function getCloseConfig(dates, temperatureInside1, temperatureInside2, temperatureOutside, pressure, scale) {

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
            values: scale,
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
            },
            {
                values: pressure,
                lineColor: "#fff",
                lineWidth: 1,
                backgroundColor:"#b4b4b4 #7000e0"
            }
        ]
    };
}