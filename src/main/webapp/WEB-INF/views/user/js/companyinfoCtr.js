/**
 * Created by Tangxinqi on 2016/11/8.
 */
var local_index = 0;
var isScolling = false;

function scrollup() {
//            var body_height = $("body").height();
    if ($(".common_wrap").is(":animated") || isScolling) return;
    if (local_index > 0) {
        isScolling = true;
        if (local_index == 6){
            $(".scoll_bar").show();
            $(".common_wrap").addClass("put-section-5");
            $(".common_wrap").css({"transform":"","-webkit-transform":""});
        }
        $(".scoll_bar li:eq(" + local_index + ")").removeClass("active");
        $(".scoll_bar li:eq(" + (local_index - 1) + ")").addClass("active");
        $(".common_wrap").removeClass("put-section-" + local_index);
        $(".common_wrap").addClass("put-section-" + (local_index - 1));
        setTimeout(function () {
            isScolling = false;
        }, 1000);
        local_index--;
    }

}
function scrolldown() {
//            var body_height = $("body").height();
    if ($(".common_wrap").is(":animated") || isScolling) return;
    if (local_index < 6) {
        if(local_index<5){
            isScolling = true;
            $(".scoll_bar li:eq(" + local_index + ")").removeClass("active");
            $(".scoll_bar li:eq(" + (local_index + 1) + ")").addClass("active");
            $(".common_wrap").removeClass("put-section-" + local_index);
            $(".common_wrap").addClass("put-section-" + (local_index + 1));
            setTimeout(function () {
                isScolling = false;
            }, 1000);
        }
        local_index++;
    }
    if (local_index == 6) {
        $(".scoll_bar").hide();
        var height = $(".footer").height() + $("body").height() * 5;
        $(".common_wrap").css({"transform":"translateY(-"+height+"px)","-webkit-transform":"translateY(-"+height+"px)"});
    }
}

(function () {
    $(window).allowShowByScoll(true, scrollup, scrolldown);
    $(".scoll_bar li").each(function () {
        $(this).find("a").each(function () {
            $(this).click(function () {
                var index = $(this).attr("data-index");
                $(".scoll_bar li:eq(" + local_index + ")").removeClass("active");
                $(".scoll_bar li:eq(" + index + ")").addClass("active");
                $(".common_wrap").removeClass("put-section-" + local_index);
                $(".common_wrap").addClass("put-section-" + index);
                local_index = Number(index);
            });
        });
    });

})();