$(window).load(function () {


    //初始化
    init();
    //初始化事件
    initEvent();
    //获取产品类型列表
    getCustomPageTypeAll();


});

//初始化
function init() {

};
function initEvent() {

};

function getCustomPageTypeAll() {
    $.get("/web/admin/ajax/cp/getCustomPageType", function (res) {
        if (res.success) {
            var typelistHtml = "";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                typelistHtml += "<option value='" + item.pageNo + "'>" + item.pageName + "</option>";
            }
            $("#custom_page_type").html(typelistHtml);
        } else {
            alert(res.msg);
        }
    })
};


