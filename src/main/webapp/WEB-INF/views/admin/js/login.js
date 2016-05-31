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
        var model = {"username": username, "password": password, "isRememberMe": isRememberMe};
        var tmp = JSON.stringify(model);
        var params = {"value": tmp};
        $.post("ajax/loginSubmit", params,
            function (res) {
                switch (res.success) {
                    case true:
                        hideErrMsg();
                        var url = "http://"+window.location.host + "/admin/index.html";
                        window.location.href = url;
                        break;
                    case false:
                        showErrMsg(res.msg);
                        break;
                }
            });
    });

    function showErrMsg(msg) {
        $("#showErrMsg").html(msg);
        $("#showErrMsg").show();
    }

    function hideErrMsg() {
        $("#showErrMsg").hide();
    }
});
