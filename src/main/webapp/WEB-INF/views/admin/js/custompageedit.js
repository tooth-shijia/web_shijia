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

    getCustomPageTypeAll();
});
function initEvent() {
    $("#submit").bind("click", submitCustomPage);
};
function submitCustomPage() {
    var customPageType = $("#custom_page_type").val();
    var pageName = $("#custom_page_type option[value='" + customPageType + "']").html();
    var content = $("#editor1").html();
    if (content == "") {
        alert("内容为空");
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
    req.pageNo = customPageType;
    req.pageName = pageName;
    req.content = encodeURIComponent(encodeURIComponent(content));
    $.ajax({
        type: "POST",
        url: "/web/admin/ajax/cp/addOrUpCustomPage",
        headers: {'Content-type': 'application/json;charset=UTF-8'},
        data: JSON.stringify(req),
        success: function (res) {
            if (res.success) {
                alert(res.msg);
                var url = "http://" + window.location.host + "/web/admin/custompage.html";
                window.location.href = url;
            } else {
                alert(res.msg);
            }
        }
    });
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
            if ($("#typeHidden").val() == "update") {
                var pageNo = $("#noHidden").val();
                $("#custom_page_type option[value='" + pageNo + "']").attr("selected", true);
                $("#submit").html("更新");
            }
        } else {
            alert(res.msg);
        }
    })
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