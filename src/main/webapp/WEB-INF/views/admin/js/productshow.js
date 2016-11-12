$(window).load(function () {


    //初始化
    init();
    //初始化事件
    initEvent();
    //获取产品类型列表
    getProductTypeAll();


});

//初始化
function init() {

};
function initEvent() {
    $("#product_type_list").bind("change", changeOnProductType);
};
//change 操作
function changeOnProductType() {
    var pageIndex = 1;
    getProductShow(pageIndex);
}

function getProductShow(pageIndex) {

    var productType = $("#product_type_list").val();

    $.get("/admin/ajax/getProductShow?pageIndex=" + pageIndex + "&productType=" + productType, function (res) {
        if (res.success) {
            var showListHtml = "";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                //表格item编辑
                showListHtml += createRecordeItemHtml(item);

            }
            $("#product_show_tbody").html(showListHtml);
        } else {
            alert(res.msg);
        }
    })
};

function getProductTypeAll() {
    $.get("/admin/ajax/getAllProductType", function (res) {
        if (res.success) {
            var typelistHtml = "";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                typelistHtml += "<option value='" + item.typeId + "'>" + item.typeName + "</option>";
            }
            $("#product_type_list").html(typelistHtml);
            //加载完，展示第一页数据
            getProductShow(1);
        } else {
            alert(res.msg);
        }
    })
};

function createRecordeItemHtml(item) {
    var html = "";
    html += " <tr class=\"odd\"> <td class=\"center sorting_1\"> " +
        "<label> #{id} </label> </td> <td class=\" \"> " +
        "<a href=\"#{url}\">#{name}</a> </td> <td class=\" \">#{productId}</td> " +
        "<td class=\"hidden-480 \">#{showCount}</td> " +
        "<td class=\" \">#{createTime}</td> " +
        "<td class=\" \">#{lastModifyTime}</td> " +
        "<td class=\" \">#{isDelete}</td> " +
        "<td class=\" \">#{comefrom}</td> " +
        "<td class=\" \">#{author}</td> " +
        "<td class=\" \"> " +
        "<div class=\"visible-md visible-lg hidden-sm hidden-xs action-buttons\"> " +
        "<a class=\"green\" href=\"#\"> " +
        "<i class=\"icon-pencil bigger-130\"></i> " +
        "</a> <a class=\"red\" href=\"#\"> " +
        "<i class=\"icon-trash bigger-130\"></i> " +
        "</a> </div> " +
        "<div class=\"visible-xs visible-sm hidden-md hidden-lg\"> " +
        "<div class=\"inline position-relative\"> " +
        "<button class=\"btn btn-minier btn-yellow dropdown-toggle\" data-toggle=\"dropdown\"> " +
        "<i class=\"icon-caret-down icon-only bigger-120\"></i> </button> " +
        "<ul class=\"dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close\"> " +
        "<li> <a href=\"#\" class=\"tooltip-success\" data-rel=\"tooltip\" title=\"\" data-original-title=\"Edit\">" +
        " <span class=\"green\"> <i class=\"icon-edit bigger-120\"></i> </span> </a> " +
        "</li> <li> " +
        "<a href=\"#\" class=\"tooltip-error\" data-rel=\"tooltip\" title=\"\" data-original-title=\"Delete\"> " +
        "<span class=\"red\"> <i class=\"icon-trash bigger-120\"></i> </span> </a> </li> </ul> </div> </div> </td> </tr>";
    html = html.replace("#{id}", item.id).replace("#{url}", item.productUrl)
        .replace("#{name}", item.productName).replace("#{productId}", item.productId)
        .replace("#{showCount}", item.showCount).replace("#{createTime}", item.createTime)
        .replace("#{lastModifyTime}", item.lastModifyTime).replace("#{isDelete}", item.isDelete)
        .replace("#{comefrom}", item.comefrom).replace("#{author}", item.author);
    return html;
}