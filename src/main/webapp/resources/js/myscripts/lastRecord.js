$(function (){
    getLastRecord();
    setInterval(getLastRecord, 30000);

    $(document).tooltip({
        position:{
            my:"left+15 center",
            at:"right center"
        }
    });
});

function getLastRecord() {
    $.getJSON("http://178.219.93.93:8888/sweethome/lastrecord", function (data) {
        $.each(data, function (key, value) {
            if (key == "date") {
                var date = new Date(value);
                $("#date").text(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
            }

            if (key == "temperatureOutside") {
                $("#temperature_inside_1").text(value);
            }

            if (key == "temperatureInside1") {
                $("#temperature_inside_2").text(value);
            }

            if (key == "temperatureInside2") {
                $("#temperature_outside").text(value);
            }

            if (key == "barPressure") {
                $("#pressure").text(value);
            }
        });
    });
}