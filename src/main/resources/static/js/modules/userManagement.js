;layui.define(["table", "form"], function (e) {
    var t = layui.$
        , i = layui.table
        , admin = layui.admin
        , form = layui.form
        , $ = layui.$;
    i.render({
        elem: "#LAY-user-manage",
        url: layui.setter.serviceURI + "/user/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "userCode", width: 100, title: "编码", sort: !0},
            {field: "userName", title: "用户名", minWidth: 100},
            {field: "userSpell", title: "拼音简码", width: 100},
            {field: "departCode", title: "部门编码", width: 100},
            {field: "departName", title: "部门名称", width: 100},
            {field: "roleCoed", title: "角色编码", width: 100},
            {field: "roleName", title: "角色名称", width: 100},
            {field: "password", title: "密码"},
            {field: "createDate", title: "创建日期", sort: !0},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-useradmin-webuser"
            }]],
        page: !0,
        limit: 30,
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-user-manage)", function (e) {
        e.data;
        if ("del" === e.event) layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
            layer.close(i), layer.confirm("真的删除行么", function (t) {
                admin.req({
                    url: layui.setter.serviceURI + '/user/deleteById'
                    , Method: 'GET'
                    , dataType: 'json'
                    , data: {'userCode': "" + e.data.userCode + ""}
                    , done: function (res) {
                        if (res.success) {
                            e.del();
                            layer.close(t);
                            layer.msg(res.msg);
                        } else {
                            layer.msg(res.msg);
                        }
                    }
                });
            })
        }); else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑用户",
                content: "addAdminForm",
                maxmin: !0,
                area: ["500px", "450px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "LAY-user-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            type: "POST"
                            , url: layui.setter.serviceURI + "/user/modify"
                            , contentType: "application/json"
                            , dataType: "JSON"
                            , data: JSON.stringify(t.field)
                            , success: function (res) {
                                if (res.success) {
                                    i.reload("LAY-user-manage");
                                    layer.close(e); //关闭弹层
                                    layer.msg(res.msg);
                                } else {
                                    layer.msg(res.msg);
                                }
                            }
                        });
                    }), n.trigger("click")
                },
                success: function (l, i) {
                    var body = layer.getChildFrame("body",i);
                    body.find("#userCode").val(e.data.userCode);
                    body.find("#userName").val(e.data.userName);
                    body.find("#userSpell").val(e.data.userSpell);
                    // body.find("#departList").val(e.data.departCode);
                    body.find("#departList").val(e.data.departName);
                    // body.find("#roleList").val(e.data.roleCode);
                    body.find("#roleList").val(e.data.roleName);
                    body.find("#password").val(e.data.password);
                    body.find("#status").val(e.data.status);
                }
            })
        }
    }), e("userManagement", {})
});