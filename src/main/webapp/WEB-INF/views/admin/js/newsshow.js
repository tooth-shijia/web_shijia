$(window).load(function () {


    //初始化
    init();
    //初始化事件
    initEvent();

    changeOnNewsType();

});

//初始化
function init() {

};
function initEvent() {
    $("#newsType").bind("change", changeOnNewsType);
};
//change 操作
function changeOnNewsType() {
    var pageIndex = 1;
    var newsType = $("#newsType").val();
    getNewsShow(pageIndex);
    getTotalAndPageSize(newsType);
}
function changeOnDeleteSelect() {
    var id = $(this).parent().parent().find(".logicId label").html();
    var type = $(this).val();
    if (type == 1) {
        //删除
        delNews(id);
    } else if (type == 0) {
        //恢复
        recoverNews(id);
    }
}
function delNews(id) {
    $.get("/web/admin/ajax/news/delNewsById?id=" + id, function (res) {
        if (!res.success) {
            alert(res.msg);
        }
    })
}
function recoverNews(id) {
    $.get("/web/admin/ajax/news/recoverNewsById?id=" + id, function (res) {
        if (!res.success) {
            alert(res.msg);
        }
    })
}
function getNewsShow(pageIndex) {

    var newsType = $("#newsType").val();

    $.get("/web/admin/ajax/news/getNewsShow?pageIndex=" + pageIndex + "&newsType=" + newsType, function (res) {
        if (res.success) {
            var showListHtml = "";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                //表格item编辑
                showListHtml += createRecordeItemHtml(item);
            }
            $("#news_show_tbody").html(showListHtml);

            //绑定删除事件
            $(".delete").change(changeOnDeleteSelect);
        } else {
            alert(res.msg);
        }
    })
};


function getTotalAndPageSize(newsTypeId) {

    $.get("/web/admin/ajax/news/getTotalByTypeId?newsTypeId=" + newsTypeId, function (res) {
        if (res.success) {
            var typeName = $("#newsType").find("option:selected").html();
            var html = typeName + "- 总数：" + res.obj.total;
            $("#showTotal").html(html);
        } else {
            alert(res.msg);
        }
    })
};

function createRecordeItemHtml(item) {
    var html = "";
    html += " <tr class=\"odd\"> <td class=\"center sorting_1 logicId\"> " +
        "<label> #{id} </label> </td> <td class=\" \"> " +
        "<a href=\"#{url}\">#{name}</a> </td>" +
        "<td class=\"hidden-480 \">#{showCount}</td> " +
        "<td class=\" \">#{createTime}</td> " +
        "<td class=\" \">#{lastModifyTime}</td> ";
    if (item.isDelete == 0) {
        html += "<td class=\" \"><select class=\"delete\"><option value='0' selected=\"selected\">未删除</option><option value='1'>已删除</option> </select></td> ";
    } else {
        html += "<td class=\" \"><select class=\"delete\"><option value='0'>未删除</option><option value='1' selected=\"selected\">已删除</option> </select></td> ";
    }

    html += "<td class=\" \">#{comefrom}</td> " +
        "<td class=\" \">#{author}</td> " +
        "<td class=\" \"> " +
        "<div class=\"visible-md visible-lg hidden-sm hidden-xs action-buttons\"> " +
        "<a class=\"green\" href='/web/admin/newsedit?id=#{id}'> " +
        "<i class=\"icon-pencil bigger-130\"></i> " +
        "</a></div> " +
        "</td> </tr>";
    html = html.replace("#{id}", item.id).replace("#{id}", item.id).replace("#{id}", item.id)
        .replace("#{url}", item.newsUrl)
        .replace("#{name}", item.newsName)
        .replace("#{showCount}", item.showCount).replace("#{createTime}", item.createTime)
        .replace("#{lastModifyTime}", item.lastModifyTime)
        .replace("#{comefrom}", item.comefrom).replace("#{author}", item.author);
    return html;
}