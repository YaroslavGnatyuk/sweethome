$(function() {
//Данные
	var TableTitle = ["№", "Дата", "Температура снаружи", "Температура внутри 1", "Температура внутри 2", "Атм. давление"];
	//Создадим структуру
	var mytable = $('<table/>',{
						class:'table table-striped table-bordered table-list table-hover'
					}).append(
						$('<thead/>'),
						$('<tfoot/>'),
						$('<tbody/>')
					);
	//Нополняем табличку
	//Заголовок

	var TitleCell = $('<tr/>');
	$.each(TableTitle,function( myIndex, myData ) {
		TitleCell
		.append(
			$('<th/>',{
				text:myData
			})
		);
	});
	$("thead",mytable).append(TitleCell);
	//Данные
    $.getJSON("http://178.219.93.93:8888/sweethome/temp",function(data){
        $.each(data,function(i,v) {
            var DataCell = $('<tr/>');
            $.each(v,function(i,value) {
                DataCell.append(
                    $('<td/>',{
                        text:value
                    })
                );
            });
            $("tbody",mytable).append(DataCell);
        });    
    });
	
	$("#container").append(mytable);
});