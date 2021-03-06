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

    newsJudgeAddOrUpdate();
});
function initEvent() {
    $("#submit").bind("click", submitNewsInfo);
    $("#imageFile").bind("change", coverChange);
    $("#btn").bind("click", uploadCoverImage);
};

function uploadCoverImage() {

    var data = new FormData();
    var file = $("#imageFile").val();
    $.each($('#imageFile')[0].files, function (i, file) {
        data.append('file', file);
    });

    $.ajax({
        type: "POST",
        url: "/web/image/news/uploadImage",
        data: data,
        cache: false,
        contentType: false,
        processData: false,
        success: function (res) {
            var imageUrl = res.obj.imageUrl;
            var imageName = res.obj.name;
            $("#imageUrl").val(imageUrl);
            $("#imageName").val(imageName);
            $("#coverImage").css("display", "block");
            alert("上传成功");
        },
        error: function (data, status, e) {
            alert(e);
        }
    });

}
function coverChange(event) {
    var files = event.target.files, file;
    if (files && files.length > 0) {
        // 获取目前上传的文件
        file = files[0];// 文件大小校验的动作
        if (file.size > 1024 * 1024 * 10) {
            alert('图片大小不能超过 10MB!');
            return false;
        }
        // 获取 window 的 URL 工具
        var URL = window.URL || window.webkitURL;
        // 通过 file 生成目标 url
        var imgURL = URL.createObjectURL(file);
        //用attr将img的src属性改成获得的url
        $("#coverImage").attr("src", imgURL).css("display", "block");
        // 使用下面这句可以在内存中释放对此 url 的伺服，跑了之后那个 URL 就无效了
        // URL.revokeObjectURL(imgURL);
    }
}

//提交新产品
function submitNewsInfo() {
    var newsName = $("#newsName").val();
    var author = $("#author").val();

    var comefrom = $("#comefrom").val();
    var newsType = $("#newsType").val();

    var imageName = $("#imageName").val();

    var content = $("#editor1").html();
    if (newsName == "") {
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
    if(imageName == ""){
        alert("封面不能为空");
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

    req.imageName = imageName;
    req.newsName = newsName;
    req.author = author;
    req.newsType = newsType;
    req.comefrom = comefrom;
    req.content = encodeURIComponent(encodeURIComponent(content));

    var param = {};
    param.req = req;

    $.ajax({
        type: "POST",
        url: "/web/admin/ajax/news/addOrUpNews",
        headers: {'Content-type': 'application/json;charset=UTF-8'},
        data: JSON.stringify(req),
        success: function (res) {
            if (res.success) {
                alert(res.msg);
                var url = "http://" + window.location.host + "/web/admin/newsmanager.html";
                window.location.href = url;
            } else {
                alert(res.msg);
            }
        }
    });

};

function newsJudgeAddOrUpdate() {
    var type = $("#typeHidden").val();
    if (type == "update") {
        var newsType = $("#newsTypeHidden").val();
        var comefrom = $("#comefromHidden").val();
        $("#newsType option[value='" + newsType + "']").attr("selected", true);
        $("#comefrom option[value='" + comefrom + "']").attr("selected", true);
        $("#submit").html("更新");
    }
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
        "<a class=\"green\" href='/admin/productedit?id=#{id}'> " +
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