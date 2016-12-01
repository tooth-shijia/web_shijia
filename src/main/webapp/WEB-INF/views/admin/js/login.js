$(window).load(function () {
    $("#adminLoginBtn").click(function () {
        hideErrMsg();
        var username = $("#adminUsername").val();
        var password = $("#adminPassword").val();
        var isRememberMe = $("#isRememberMe").is(':checked');
        if (username == "") {
            showErrMsg("用户名不能为空");
            return;
        }
        if (password == "") {
            showErrMsg("密码不能为空");
            return;
        }
        var req = {};
        req.username=username;
        req.password=password;
        req.isRememberMe=isRememberMe;

        $.ajax({
            type: "POST",
            url: "ajax/loginSubmit",
            headers: {'Content-type': 'application/json;charset=UTF-8'},
            data: JSON.stringify(req),
            success: function (res) {
                switch (res.success) {
                    case true:
                        hideErrMsg();
                        var url = "http://" + window.location.host + "/admin/index.html";
                        var backUrl = requestParam("backUrl");
                        if (backUrl) {
                            url = backUrl;
                        }
                        window.location.href = url;
                        break;
                    case false:
                        showErrMsg(res.msg);
                        break;
                }
            }
        });
    });

    function showErrMsg(msg) {
        $("#showErrMsg").html(msg);
        $("#showErrMsg").show();
    };

    function hideErrMsg() {
        $("#showErrMsg").hide();
    };

    function requestParam(paras) {
        var url = location.href;
        var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
        var paraObj = {};
        for (i = 0; j = paraString[i]; i++) {
            paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
        }
        var returnValue = paraObj[paras.toLowerCase()];
        if (typeof(returnValue) == "undefined") {
            return "";
        } else {
            return returnValue;
        }
    }
});
