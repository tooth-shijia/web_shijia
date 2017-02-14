$(function () {
    var pageSize = 100;
    $('.M-box').pagination({
        pageCount:pageSize,
        jump:true,
        coping:true,
        homePage:'首页',
        endPage:'末页',
        count: 3,
        prevContent:'上一页',
        nextContent:'下一页',
        callback: function (index) {
            var page = index.getCurrent();
            this.pageCount = 1000000;
        }
    });
});

