/**
 * Created by yroslav on 8/12/16.

 */
$(function(){
    $(".btn.btn-default.btn-success#fast-backward").click(function(){
        if($("#fast-backward").hasClass("tInsideOneHour")){
            alert("fast backward one hour. Temperature inside");
        }

        if($("#fast-backward").hasClass("tInsideOneDay")){
            alert("fast backward one day. Temperature inside");
        }

        if($("#fast-backward").hasClass("tInsideOneMonth")){
            alert("fast backward one month. Temperature inside");
        }
    })

    $(".btn.btn-default.btn-success#backward").click(function(){
        if($("#backward").hasClass("tInsideOneHour")){
            alert("backward one hour. Temperature inside");
        }

        if($("#backward").hasClass("tInsideOneDay")){
            alert("backward one day. Temperature inside");
        }

        if($("#backward").hasClass("tInsideOneMonth")){
            alert("backward one month. Temperature inside");
        }
    })

    $(".btn.btn-default.btn-success#forward").click(function(){
        if($("#forward").hasClass("tInsideOneHour")){
            alert("forward one hou. Temperature insider");
        }

        if($("#forward").hasClass("tInsideOneDay")){
            alert("forward one day. Temperature inside");
        }

        if($("#forward").hasClass("tInsideOneMonth")){
            alert("forward one month. Temperature inside");
        }
    })

    $(".btn.btn-default.btn-success#fast-forward").click(function(){
        if($("#fast-forward").hasClass("tInsideOneHour")){
            alert("fast-forward one hour. Temperature inside");
        }

        if($("#fast-forward").hasClass("tInsideOneDay")){
            alert("fast-forward one day. Temperature inside");
        }

        if($("#fast-forward").hasClass("tInsideOneMonth")){
            alert("fast-forward one month. Temperature inside");
        }
    })
/*It's outside temperature*/
    $(".btn.btn-default.btn-success#fast-backward").click(function(){
        if($("#fast-backward").hasClass("tOutsideOneHour")){
            alert("fast backward one hour. Temperature outside");
        }

        if($("#fast-backward").hasClass("tOutsideOneDay")){
            alert("fast backward one day. Temperature outside");
        }

        if($("#fast-backward").hasClass("tOutsideOneMonth")){
            alert("fast backward one month. Temperature outside");
        }

    })

    $(".btn.btn-default.btn-success#backward").click(function(){
        if($("#backward").hasClass("tOutsideOneHour")){
            alert("backward one hour. Temperature outside");
        }

        if($("#backward").hasClass("tOutsideOneDay")){
            alert("backward one day. Temperature outside");
        }

        if($("#backward").hasClass("tInsideOneMonth")){
            alert("backward one month. Temperature outside");
        }
    })

    $(".btn.btn-default.btn-success#forward").click(function(){
        if($("#forward").hasClass("tOutsideOneHour")){
            alert("forward one hou. Temperature outside");
        }

        if($("#forward").hasClass("tOutsideOneDay")){
            alert("forward one day. Temperature outside");
        }

        if($("#forward").hasClass("tOutsideOneMonth")){
            alert("forward one month. Temperature outside");
        }
    })


    $(".btn.btn-default.btn-success#fast-forward").click(function(){
        if($("#fast-forward").hasClass("tOutsideOneHour")){
            alert("fast-forward one hour. Temperature outside");
        }

        if($("#fast-forward").hasClass("tOutsideOneDay")){
            alert("fast-forward one day. Temperature outside");
        }

        if($("#fast-forward").hasClass("tOutsideOneMonth")){
            alert("fast-forward one month. Temperature outside");
        }
    })

})

