jQuery(window).load(function () {


    //初始化
    init();
    //初始化事件
    initEvent();

});

//初始化
function init() {

};
function initEvent() {
    getAllProduct();
};

function getAllProduct() {
    var pageType = $("#pageType").val();

    if (pageType == 1 || pageType == 2) {
        var url = "/web/shijia/product/1/list-detail";
        if (pageType == 2) {
            url = "/web/shijia/product/2/list-detail";
        }
        $.get(url, function (res) {
            if (res.success) {
                var listHtml = "";
                for (i = 0; i < res.obj.length; i++) {
                    var item = res.obj[i];
                    listHtml += createProductItemHtml(item);
                }
                $("#showListContent").html(listHtml);
            } else {
                alert(res.msg);
            }
        });
    }

    else if (pageType == 3) {
        //新闻
    }
}

function createProductItemHtml(item) {

    var html = "";
    html += "<div class='portfolio-box " + item.className + "'> " +
        "<div class='portfolio-box-container portfolio-video' data-portfolio-big='http://vimeo.com/84910153?autoplay=0'> " +
        "<img src='/muassets/img/portfolio/work2.jpg' alt='' data-at2x='/muassets/img/portfolio/work2.jpg'> " +
        "<span class='portfolio-box-icon arrow_triangle-right'>" +
        "</span> " +
        "<div class='portfolio-box-text'> " +
        "<h3>来源:" + item.comefrom + "</h3> " +
        "<p>" + item.productName + "</p> " +
        "</div> " +
        "</div>" +
        " </div>";

    return html;
}
