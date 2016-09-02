<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap-datetimepicker.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mystyle/mystyle.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.min.css"/>">

        <script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-3.1.0.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap/bootstrap.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap/moment.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap/bootstrap-datetimepicker.min.js"/>"></script>

        <script type="text/javascript" src= "<c:url value="/resources/js/zingchart_branded_version_2.4.1/zingchart.min.js"/>"></script>

        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/navigation_bar.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/paint_chart.v1.001.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/config_chart.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/set_period.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/buttons.v1.011.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/lastRecord.v1.001.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-ui.min.js"/>"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <body>
        <div class="container" style="margin-top: 50px;">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header active" id = "main">
                    <a class="navbar-brand" href="/sweethome/">Main</a>
                </div>

                <div>
                    <ul class="nav navbar-nav">
                        <li id="firsttab" class= "dropdown">
                            <a href="#" class="dropdown-toggle navbar-brand" data-toggle="dropdown">
                                Temperatures inside
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li id = "tInsideOneHour"><a href="#">Temperature per one hour</a></li>
                                <li class="divider"></li>
                                <li id = "tInsideOneDay"><a href="#">Temperature per one day</a></li>
                                <li class="divider"></li>
                                <li id = "tInsideOneMonth"><a href="#">Temperature per one month</a></li>
                                <li class="divider"></li>
                                <li id = "tInsideSetPeriod"><a href="#">Set period...</a></li>
                            </ul>
                        </li>

                        <li id="secondtab" class= "dropdown">
                            <a href="#" class="dropdown-toggle navbar-brand" data-toggle="dropdown">
                                Temperature outside
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li id = "tOutsideOneHour"><a href="#">Temperature per one hour</a></li>
                                <li class="divider"></li>
                                <li id = "tOutsideOneDay"><a href="#">Temperature per one day</a></li>
                                <li class="divider"></li>
                                <li id = "tOutsideOneMonth"><a href="#">Temperature per one month</a></li>
                                <li class="divider"></li>
                                <li id = "tOutsideSetPeriod"><a href="#">Set period...</a></li>
                            </ul>

                        </li>

                        <li id="thirdtab" class= "dropdown">
                            <a href="#" class="dropdown-toggle navbar-brand" data-toggle="dropdown">
                                Barometric pressure
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li id="pressureOneHour"><a href="#">Pressure per one hour</a></li>
                                <li class="divider"></li>
                                <li id="pressureOneDay"><a href="#">Pressure per one day</a></li>
                                <li class="divider"></li>
                                <li id="pressureOneMonth"><a href="#">Pressure per one month</a></li>
                                <li class="divider"></li>
                                <li id="pressureSetPeriod"><a href="#">Set period...</a></li>
                            </ul>

                        </li>

                        <li id="fifthtab" class="dropdown">
                            <a href="#" class="dropdown-toggle navbar-brand" data-toggle="dropdown">
                                Interesting facts
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Max and min temperature inside</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Max and min temperature outside</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Max and min pressure</a></li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </nav>

            <div class="row">
                <div class="col-md-12 ">
                    <div class="panel panel-default panel-table">
                        <div class="panel-heading ">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="col col-xs-1">
                                        <a class="btn btn-default btn-success hideThisSelector" id="fast-backward"><em class="fa fa-fast-backward"></em></a>
                                    </div>

                                    <div class="col col-xs-1">
                                        <a class="btn btn-default btn-success hideThisSelector" id="backward"><em class="fa fa-backward"></em></a>
                                    </div>

                                    <div class="col col-xs-1">
                                        <a class="btn btn-default btn-success hideThisSelector" id="forward"><em class="fa fa-forward"></em></a>
                                    </div>

                                    <div class="col col-xs-1">
                                        <a class="btn btn-default btn-success hideThisSelector" id="fast-forward"><em class="fa fa-fast-forward"></em></a>
                                    </div>
                                </div>

                                <div class="col-md-3">

                                </div>

                                <div class="col-md-3 text-right">
                                    <img src="<c:url value="/resources/img/loading.gif"/>"  class = "loading hide">
                                </div>

                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div class="panel panel-default panel-table main_img">
                                    <div class = "block">
                                        <div class = "field" title="This is a time of last record.">
                                            <img src="<c:url value="/resources/img/icon/clock.png"/>" class="icon">
                                            <b id="date" class = "value"></b>
                                        </div>

                                        <div class = "field" title="This is temperature in the street.">
                                            <img src="<c:url value="/resources/img/icon/temperature.png"/>" class="icon">
                                            <b id="temperature_inside_1" class = "value"></b>
                                        </div>

                                        <div class = "field" title="This is temperature in the kitchen.">
                                            <img src="<c:url value="/resources/img/icon/temperature.png"/>" class="icon">
                                            <b id="temperature_inside_2" class = "value"></b>
                                        </div>

                                        <div class = "field" title="This is temperature in the hall.">
                                            <img src="<c:url value="/resources/img/icon/temperature.png"/>" class="icon">
                                            <b id="temperature_outside" class = "value"></b>
                                        </div>

                                        <div class = "field" title="This is atmospheric pressure.">
                                            <img src="<c:url value="/resources/img/icon/pressure.png"/>" class="icon">
                                            <b  id="pressure" class = "value"></b>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>