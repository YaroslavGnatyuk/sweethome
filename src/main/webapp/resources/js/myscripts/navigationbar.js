$(function(){
    $("li#zerotab").mouseenter(function(){
        $("li#zerotab").addClass("navmenu")
    });
})
$(function(){
    $("li#firsttab").mouseenter(function(){
        $("li#firsttab").addClass("navmenu")
    });
})

$(function(){
    $("li#secondtab").mouseenter(function(){
        $("li#secondtab").addClass("navmenu")
    });
})

$(function(){
    $("li#thirdtab").mouseenter(function(){
        $("li#thirdtab").addClass("navmenu")
    });
})

$(function(){
    $("li#fourthtab").mouseenter(function(){
        $("li#fourthtab").addClass("navmenu")
    });
})

$(function(){
    $("li#fifthtab").mouseenter(function(){
        $("li#fifthtab").addClass("navmenu")
    });
})

$(function(){
    $("div.navbar-header#main").mouseenter(function(){
        $("div.navbar-header#main").addClass("main")
    });
})

$(function(){
    $("li").mouseout(function(){
        $("li").removeClass("navmenu");
    });

    $("div.navbar-header#main").mouseout(function(){
        $("div.navbar-header#main").removeClass("main");
    });
})