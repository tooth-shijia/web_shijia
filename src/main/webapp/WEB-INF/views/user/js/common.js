/**
 * Created by Tangxinqi on 2016/6/12.
 */
(function (){
    $("#checkBox").mouseenter(function(){
        $(this).find("span").last().css("color","#F54785");
    });
    $("#checkBox").mouseleave(function(){
        $(this).find("span").last().css("color","#000");
    });

    $("#checkBox").click(function(){
        var checked  = $(this).find("input").first().attr("checked");
        if(checked==undefined||checked==null){
            $(this).find("span").first().addClass("glyphicon glyphicon-ok checkedStatus")
            $(this).find("input").first().attr("checked","checked");
        }
        else{
            $(this).find("span").first().removeClass("glyphicon glyphicon-ok checkedStatus");
            $(this).find("input").first().removeAttr("checked");
        }

    });
})();