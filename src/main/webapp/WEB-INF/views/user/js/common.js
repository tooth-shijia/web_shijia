/**
 * Created by Tangxinqi on 2016/6/12.
 */
(function ($) {
    $.fn.extend({
        checkon: function () {
            this.mouseenter(function () {
                $(this).find("span").last().css("color", "#F54785");
            });
            this.mouseleave(function () {
                $(this).find("span").last().css("color", "#000");
            });
            this.click(function () {
                var checked = $(this).find("input").first().attr("checked");
                if (checked == undefined || checked == null) {
                    $(this).find("span").first().addClass("glyphicon glyphicon-ok checkedStatus")
                    $(this).find("input").first().attr("checked", "checked");
                }
                else {
                    $(this).find("span").first().removeClass("glyphicon glyphicon-ok checkedStatus");
                    $(this).find("input").first().removeAttr("checked");
                }
            });
        }
    });
})(jQuery);

(function ($) {
    $.fn.extend({
        allowShowByScoll: function (boolean, fnpullup, fnpulldown) {

            if (boolean == true) {

                this[0].onmousewheel = function (e) {
                    mouseWheelEvent(e,fnpullup, fnpulldown);
                };

                this[0].onkeydown = function (e) {
                    onKeyDownEvent(e,fnpullup, fnpulldown);
                };
                if(document.addEventListener){
                    document.addEventListener("DOMMouseScroll",function (e) {
                        mouseWheelEvent(e,fnpullup, fnpulldown);
                    },false);
                }
            }
            else {
                this[0].onmousewheel = null;
                if(document.addEventListener){
                    document.removeEventListener("DOMMouseScroll",function (e) {
                        mouseWheelEvent(e,fnpullup, fnpulldown);
                    });
                }
                this[0].onkeydown = null;
            }
        }
    });
})(jQuery);

function mouseWheelEvent(e, fnpullup, fnpulldown) {
    e = e || window.event;
    e.preventDefault();
    if (e.wheelDelta) {  //判断浏览器IE，谷歌滑轮事件
        if (e.wheelDelta > 0) { //当滑轮向上滚动时
            if (fnpullup != null)fnpullup();
        }
        if (e.wheelDelta < 0) { //当滑轮向下滚动时
            if (fnpulldown != null)fnpulldown();
        }
    } else if (e.detail) {  //Firefox滑轮事件
        if (e.detail > 0) { //当滑轮向上滚动时
            if (fnpullup != null) fnpullup();
        }
        if (e.detail < 0) { //当滑轮向下滚动时
            if (fnpulldown != null) fnpulldown();
        }
    }
}

function onKeyDownEvent(e, fnpullup, fnpulldown) {

    var e = e || window.event || arguments.callee.caller.arguments[0];
    if (e && e.keyCode == 38) {
        if (fnpullup != null) fnpullup();
    }
    else if (e && e.keyCode == 40) {
        if (fnpulldown != null) fnpulldown();
    }
}