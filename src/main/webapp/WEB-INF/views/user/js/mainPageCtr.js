/**
 * Created by Tangxinqi on 2016/12/2.
 */
$(document).ready(function () {

    $(".mp_menu").children().each(function () {
        $(this).mouseover(function () {
            $(this).children("ul").show();
            $(this).siblings("li").children("ul").hide();
        });
    });
    $(".mp_sub_menu").each(function () {
        $(this).mouseleave(function(){
            $(this).hide();
        });
    });
    $(".mp_menu").mouseleave(function(){
        $(".mp_sub_menu").each(function () {
            $(this).hide();
        });
    });
});