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

    /**
     * 默认 世佳产品内容
     * @type {string}
     */
    var url = "/web/shijia/product/1/list-detail";

    if (pageType == 2) {
        url = "/web/shijia/product/2/list-detail";
    } else if (pageType == 3) {
        //新闻
        url = "/web/shijia/news/list-detail";
    }
    $.get(url, function (res) {
        if (res.success) {
            var listHtml = "";
            listHtml += "<div class='col-sm-12 portfolio-masonry'>";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                listHtml += createProductItemHtml(item);
            }
            listHtml += "</div>";
            $("#showListContent").html(listHtml);
            i
            /**
             * 初始化摆放各个标题
             */
            $('.portfolio-masonry').masonry({
                columnWidth: '.portfolio-box',
                itemSelector: '.portfolio-box',
                transitionDuration: '0.5s'
            });
        } else {
            alert(res.msg);
        }
    });
}

function createProductItemHtml(item) {

    var html = "";
    html += "<div class='portfolio-box " + item.className + "'> " +
        "<div class='portfolio-box-container'> " +
        "<a href='" + item.url + "'><img src='/muassets/img/portfolio/work1.jpg' alt='' data-at2x='/muassets/img/portfolio/work1.jpg'></a> " +
        "<div class='portfolio-box-text'> " +
        "<h3>" + item.name + "</h3> " +
        "<p>来源:" + item.comefrom + "</p> " +
        "</div> " +
        "</div>" +
        " </div>";

    return html;
}
