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
    $("#custom_page_type").bind("change", changeOnCustomPageType);
};

function changeOnCustomPageType() {
    getCustomPageShow();
};

function getCustomPageShow() {

    var pageNo = $("#custom_page_type").val();

    $.get("/web/admin/ajax/cp/getCustomPageShow?pageNo=" + pageNo, function (res) {
        if (res.success) {
            var showListHtml = "";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                //表格item编辑
                showListHtml += createCPRecordeItemHtml(item);
            }
            $("#cp_show_tbody").html(showListHtml);

            //绑定删除事件
            //$(".delete").change(changeOnDeleteSelect);
        } else {
            alert(res.msg);
        }
    })
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

            //初始化更新数据
            changeOnCustomPageType();
        } else {
            alert(res.msg);
        }
    })
};
function createCPRecordeItemHtml(item) {
    var html = "";
    html += " <tr class=\"odd\"> <td class=\"center sorting_1 logicId\"> " +
        "<label> #{id} </label> </td> <td class=\" \"> " +
        "<a href=\"#{url}\">#{name}</a> </td>" +
        "<td class=\" \">#{pageNo}</td> " +
        "<td class=\" \">#{status}</td> " +
        "<td class=\" \">#{createTime}</td> " +
        "<td class=\" \">#{lastModifyTime}</td> ";

    html +=
        "<td>"+
        "<div class=\"visible-md visible-lg hidden-sm hidden-xs action-buttons\"> " +
        "<a class=\"green\" href='/web/admin/custompageedit?id=#{id}'> " +
        "<i class=\"icon-pencil bigger-130\"></i> " +
        "</a></div> " +
        "</td> </tr>";
    html = html.replace("#{id}", item.id).replace("#{id}", item.id).replace("#{id}", item.id)
        .replace("#{url}", item.pageUrl)
        .replace("#{pageNo}", item.pageNo)
        .replace("#{name}", item.pageName)
        .replace("#{status}", item.status)
        .replace("#{createTime}", item.createTime)
        .replace("#{lastModifyTime}", item.lastModifyTime);
    return html;
}


