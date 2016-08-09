<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/mystyle.css"/>">

        <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>

        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/navigationbar.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/pressure.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/myscripts/temInside.js"/>"></script>

        <script type="text/javascript" src= "<c:url value="/resources/js/zingchart_branded_version_2.4.1/zingchart.min.js"/>"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>

    <div id="bg">
        <img src="<c:url value="/resources/img/background.jpg"/>">
    </div>

    <body>
    <div class="container" style="margin-top: 50px;">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header" id = "main">
                <a class="navbar-brand" href="#">Main</a>
            </div>

            <div>
                <ul class="nav navbar-nav">
                    <li id="zerotab" class= "dropdown">
                        <a href="#" class="navbar-brand">
                            Real time
                        </a>
                    </li>

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
                            <li><a href="#">Set period...</a></li>
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

                    <li id="fourthtab"class="dropdown">
                        <a href="#" class="dropdown-toggle navbar-brand" data-toggle="dropdown">
                            All together
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">All data per one hour</a></li>
                            <li class="divider"></li>
                            <li><a href="#">All data per one day</a></li>
                            <li class="divider"></li>
                            <li><a href="#">All data per one month</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Set period...</a></li>
                        </ul>
                    </li>

                    <li id="fifthtab"class="dropdown">
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
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="col col-xs-1">
                                    <a class="btn btn-default btn-success text-left"><em class="fa fa-fast-backward"></em></a>
                                </div>

                                <div class="col col-xs-1">
                                    <a class="btn btn-default btn-success text-left"><em class="fa fa-backward"></em></a>
                                </div>

                                <div class="col col-xs-1">
                                    <a class="btn btn-default btn-success text-left"><em class="fa fa-forward"></em></a>
                                </div>

                                <div class="col col-xs-1">
                                    <a class="btn btn-default btn-success text-left"><em class="fa fa-fast-forward"></em></a>
                                </div>
                            </div>

                            <div align = "centr">
                                <h3 class="panel-title"></h3>
                            </div>

                        </div>
                    </div>
                    <div class="panel-body">

                        <div class="table-responsive">
                            <div id='myChart'>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </div>
    </body>
</html>