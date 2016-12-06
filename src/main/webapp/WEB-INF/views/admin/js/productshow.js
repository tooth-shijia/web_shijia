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
    $("#siteId").bind("change", getProductTypeAll);
};
//change 操作
function changeOnProductType() {
    var pageIndex = 1;
    var productTypeId = $("#product_type_list").val();
    getProductShow(pageIndex);
    getTotalAndPageSize(productTypeId);
}
function changeOnDeleteSelect() {
    var id = $(this).parent().parent().find(".logicId label").html();
    var type = $(this).val();
    if (type == 1) {
        //删除
        delProduct(id);
    } else if (type == 0) {
        //恢复
        recoverProduct(id);
    }
}
function delProduct(id) {
    $.get("/web/admin/ajax/product/delProductById?id="+id, function (res) {
        if (!res.success) {
            alert(res.msg);
        }
    })
}
function recoverProduct(id) {
    $.get("/web/admin/ajax/product/recoverProductById?id="+id, function (res) {
        if (!res.success) {
            alert(res.msg);
        }
    })
}
function getProductShow(pageIndex) {

    var productType = $("#product_type_list").val();

    $.get("/web/admin/ajax/product/getProductShow?pageIndex=" + pageIndex + "&productType=" + productType, function (res) {
        if (res.success) {
            var showListHtml = "";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                //表格item编辑
                showListHtml += createRecordeItemHtml(item);

            }
            $("#product_show_tbody").html(showListHtml);

            //绑定删除事件
            $(".delete").change(changeOnDeleteSelect);
        } else {
            alert(res.msg);
        }
    })
};

function getProductTypeAll() {
    var siteId = $("#siteId").val();
    $.get("/web/admin/ajax/product/getAllProductType?parentId=-1&siteId=" + siteId, function (res) {
        if (res.success) {
            var typelistHtml = "";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                typelistHtml += "<option value='" + item.typeId + "'>" + item.typeName + "</option>";
            }
            $("#product_type_list").html(typelistHtml);
            //加载完，展示第一页数据
            changeOnProductType();
        } else {
            alert(res.msg);
        }
    })
};

function getTotalAndPageSize(productTypeId) {

    $.get("/web/admin/ajax/product/getTotalByTypeId?productTypeId=" + productTypeId, function (res) {
        if (res.success) {
            var siteName = $("#siteId").find("option:selected").html();
            var typeName = $("#product_type_list").find("option:selected").html();
            var html = siteName + "-" + typeName + "- 总数：" + res.obj.total;
            $("#showTotal").html(html);
        } else {
            alert(res.msg);
        }
    })
};
function deleteProductShow(id) {
    $.get("/web/admin/ajax/product/delProductById?id=" + id, function (res) {
        if (res.success) {
            alert(res.msg);
        } else {
            alert(res.msg);
        }
    })
};
function createRecordeItemHtml(item) {
    var html = "";
    html += " <tr class=\"odd\"> <td class=\"center sorting_1 logicId\"> " +
        "<label> #{id} </label> </td> <td class=\" \"> " +
        "<a href=\"#{url}\">#{name}</a> </td> <td class=\" \">#{productId}</td> " +
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
        "<a class=\"green\" href='/web/admin/productedit?id=#{id}'> " +
        "<i class=\"icon-pencil bigger-130\"></i> " +
        "</a></div> " +
        "</td> </tr>";
    html = html.replace("#{id}", item.id).replace("#{id}", item.id).replace("#{id}", item.id)
        .replace("#{url}", item.productUrl)
        .replace("#{name}", item.productName).replace("#{productId}", item.productId)
        .replace("#{showCount}", item.showCount).replace("#{createTime}", item.createTime)
        .replace("#{lastModifyTime}", item.lastModifyTime)
        .replace("#{comefrom}", item.comefrom).replace("#{author}", item.author);
    return html;
}