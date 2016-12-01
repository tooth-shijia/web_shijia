$(window).load(function () {

    function showErrorAlert(reason, detail) {
        var msg = '';
        if (reason === 'unsupported-file-type') {
            msg = "Unsupported format " + detail;
        }
        else {
            console.log("error uploading file", reason, detail);
        }
        $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
    }

    $('#editor1').ace_wysiwyg({
        toolbar: [
            'font',
            null,
            'fontSize',
            null,
            {name: 'bold', className: 'btn-info'},
            {name: 'italic', className: 'btn-info'},
            {name: 'strikethrough', className: 'btn-info'},
            {name: 'underline', className: 'btn-info'},
            null,
            {name: 'insertunorderedlist', className: 'btn-success'},
            {name: 'insertorderedlist', className: 'btn-success'},
            {name: 'outdent', className: 'btn-purple'},
            {name: 'indent', className: 'btn-purple'},
            null,
            {name: 'justifyleft', className: 'btn-primary'},
            {name: 'justifycenter', className: 'btn-primary'},
            {name: 'justifyright', className: 'btn-primary'},
            {name: 'justifyfull', className: 'btn-inverse'},
            null,
            {name: 'createLink', className: 'btn-pink'},
            {name: 'unlink', className: 'btn-pink'},
            null,
            {name: 'insertImage', className: 'btn-success'},
            null,
            'foreColor',
            null,
            {name: 'undo', className: 'btn-grey'},
            {name: 'redo', className: 'btn-grey'}
        ],
        'wysiwyg': {
            fileUploadError: showErrorAlert
        }
    }).prev().addClass('wysiwyg-style2');

    //初始化
    init();
    //初始化事件
    initEvent();
    //获取产品类型列表
    //getProductTypeAll();
    //如果是更新 修改下拉框
    judgeAddOrUpdate();
});
function initEvent() {
    $("#submit").bind("click", submitNewProduct);
    $("#siteId").bind("change", getProductTypeAll);
};

//提交新产品
function submitNewProduct() {
    var productName = $("#productName").val();
    var productId = $("#productId").val();
    var author = $("#author").val();
    var productTypeId = $("#product_type_list").val();
    var productTypeName = $("#product_type_list").find("option:selected").html();

    var comefrom = $("#comefrom").val();
    var siteId = $("#siteId").val();

    var content = $("#editor1").html();
    if (productName == "") {
        alert("产品名不能为空");
        return false;
    }
    if (author == "") {
        alert("作者不能为空");
        return false;
    }
    if (content == "") {
        alert("内容为空");
        return false;
    }
    if (productId == "") {
        alert("产品id不能为空");
        return false;
    }
    var req = {};

    var type = $("#typeHidden").val();
    var id = $("#idHidden").val();
    if (type == "update") {
        req.id = id;
        req.reqType = 2;
    } else {
        req.id = -1;
        req.reqType = 1;
    }

    req.siteId = siteId;
    req.productName = productName;
    req.productId = productId;
    req.author = author;
    req.productTypeId = productTypeId;
    req.productTypeName = productTypeName;
    req.comefrom = comefrom;
    req.content = encodeURIComponent(encodeURIComponent(content));

    var param = {};
    param.req = req;

    $.ajax({
        type: "POST",
        url: "/admin/ajax/product/addOrUpProduct",
        headers: {'Content-type': 'application/json;charset=UTF-8'},
        data: JSON.stringify(req),
        success: function (res) {
            if (res.success) {
                alert(res.msg);
                var url = "http://" + window.location.host + "/admin/productshow.html";
                window.location.href = url;
            } else {
                alert(res.msg);
            }
        }
    });

};
function getProductTypeAll() {
    var siteId = $("#siteId").val();
    $.get("/admin/ajax/product/getAllProductType?parentId=-1&siteId=" + siteId, function (res) {
        if (res.success) {
            var typelistHtml = "";
            for (i = 0; i < res.obj.length; i++) {
                var item = res.obj[i];
                typelistHtml += "<option value='" + item.typeId + "'>" + item.typeName + "</option>";
            }
            $("#product_type_list").html(typelistHtml);
            if ($("#typeHidden").val() == "update") {
                var productTypeId = $("#productTypeIdHidden").val();
                $("#product_type_list option[value='" + productTypeId + "']").attr("selected", true);
            }
        } else {
            alert(res.msg);
        }
    })
};
function judgeAddOrUpdate() {

    var type = $("#typeHidden").val();
    if (type == "update") {
        var siteId = $("#siteIdHidden").val();
        var comefrom = $("#comefromHidden").val();
        $("#siteId option[value='" + siteId + "']").attr("selected", true);
        $("#comefrom option[value='" + comefrom + "']").attr("selected", true);
        $("#submit").html("更新");
        //setTimeout('getProductTypeAll()',1000);
    }
    getProductTypeAll();


};
//初始化
function init() {
    if (typeof jQuery.ui !== 'undefined' && /applewebkit/.test(navigator.userAgent.toLowerCase())) {

        var lastResizableImg = null;

        function destroyResizable() {
            if (lastResizableImg == null) return;
            lastResizableImg.resizable("destroy");
            lastResizableImg.removeData('resizable');
            lastResizableImg = null;
        }

        var enableImageResize = function () {
            $('.wysiwyg-editor')
                .on('mousedown', function (e) {
                    var target = $(e.target);
                    if (e.target instanceof HTMLImageElement) {
                        if (!target.data('resizable')) {
                            target.resizable({
                                aspectRatio: e.target.width / e.target.height,
                            });
                            target.data('resizable', true);

                            if (lastResizableImg != null) {//disable previous resizable image
                                lastResizableImg.resizable("destroy");
                                lastResizableImg.removeData('resizable');
                            }
                            lastResizableImg = target;
                        }
                    }
                })
                .on('click', function (e) {
                    if (lastResizableImg != null && !(e.target instanceof HTMLImageElement)) {
                        destroyResizable();
                    }
                })
                .on('keydown', function () {
                    destroyResizable();
                });
        }
        enableImageResize();
    }
}