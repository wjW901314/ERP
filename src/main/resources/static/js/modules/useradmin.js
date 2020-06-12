/** layuiAdmin.std-v1.4.0 LPPL License By https://www.layui.com/admin/ */
;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table,$=layui.$;
    layui.form;
    i.render({
        elem: "#LAY-user-manage",
        url: layui.setter.serviceURI + "/basis/user/getAll",
        cols: [[{type: "checkbox", fixed: "left"}
            , {field: "id", width: 100, title: "ID", sort: !0}
            , {field: "userName", title: "用户名", minWidth: 100}
            , {field: "userPwd", title: "密码", minWidth: 100}
            , {field: "phone", title: "手机"}
            , {field: "email", title: "邮箱"}
            , {field: "role", width: 80, title: "角色"}
            , {field: "status", title: "状态", width: 60}
            , {title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-useradmin-webuser"}]],
        page: !0,
        limit: 30,
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-user-manage)", function (e) {
        e.data;
        if ("del" === e.event)
            layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
                layer.close(i),
                    layer.confirm("真的删除行么", function (t) {
                        e.del(), layer.close(t);
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
                success: function(layero, index){
                    var body=layer.getChildFrame('body',index);//少了这个是不能从父页面向子页面传值的
                    //获取子页面的元素，进行数据渲染
                    var aa = "123123";
                    body.contents().find("#id").val(aa);
                    console.log(aa+"-----" + e.data.field);
                },
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "LAY-user-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        i.reload("LAY-user-manage"), layer.close(e);
                    }), n.trigger("click")
                },
                success: function (e, t) {
                }
            })
        }
    }), i.render({
        elem: "#LAY-user-back-manage",
        url: layui.setter.serviceURI + "/basis/userRole/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "id", width: 80, title: "ID", sort: !0},
            {field: "loginName", title: "登录名"},
            {field: "telPhone", title: "手机"},
            {field: "email", title: "邮箱"},
            {field: "role", title: "角色"},
            {field: "joinTime", title: "加入时间", sort: !0},
            {field: "status", title: "审核状态", templet: "#buttonTpl", minWidth: 80, align: "center"},
            {title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-useradmin-admin"}]],
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-user-back-manage)", function (e) {
        e.data;
        var jsonData = {"id": e.data.id};
        console.log(jsonData);
        if ("del" === e.event)
            layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
                layer.close(i), layer.confirm("确定删除此管理员？", function (t) {
                    console.log(e);
                    $.ajax({
                        type: 'GET',
                        url: layui.setter.serviceURI + '/basis/userRole/delete',
                        data: jsonData,
                        dataType: 'json',
                        success: function (res) {
                            if (res.success) {
                                layer.msg(res.msg, {icon: 6});
                                e.del();
                            } else {
                                layer.msg(res.msg, {icon: 5});
                            }
                        }
                    });
                    e.del();
                    layer.close(t);
                })
            });
        else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: false,
                content: "addCommodity",
                area: ["420px", "420px"],
                shadeClose: false,
                btn: ["确定", "取消"],
                success: function(layero, index){
                    var body=layer.getChildFrame('body',index);//少了这个是不能从父页面向子页面传值的
                    //获取子页面的元素，进行数据渲染
                    console.log('success' + e.data);
                    body.contents().find("#loginName").val(e.data.loginName);
                },
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "LAY-user-back-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        layer.alert('编辑行：<br>'+ JSON.stringify(t.field))
                        e.update({
                            id: t.field[0].id
                            , loginName: t.field[0].loginName
                            , telPhone: t.field[0].telPhone
                            , email: t.field[0].email
                            , role: t.field[0].role
                            , joinTime: t.field[0].joinTime
                            , status: t.field[0].status
                        });
                        i.reload("LAY-user-front-submit"), layer.close(e)
                    }), n.trigger("click")
                },
                success: function (e, t) {
                }
            })
        }
    })
        , i.render({
        elem: "#LAY-user-back-role",
        url: layui.setter.serviceURI + "json/useradmin/role.js",
        cols: [[{type: "checkbox", fixed: "left"}, {field: "id", width: 80, title: "ID", sort: !0}, {
            field: "rolename",
            title: "角色名"
        }, {field: "limits", title: "拥有权限"}, {field: "descr", title: "具体描述"}, {
            title: "操作",
            width: 150,
            align: "center",
            fixed: "right",
            toolbar: "#table-useradmin-admin"
        }]],
        text: "对不起，加载出现异常！"
    }), i.on("tool(LAY-user-back-role)", function (e) {
        e.data;
        if ("del" === e.event) layer.confirm("确定删除此角色？", function (t) {
            e.del(), layer.close(t)
        }); else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑角色",
                content: "../../../views/user/administrators/roleform.html",
                area: ["500px", "480px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e],
                        r = t.find("iframe").contents().find("#LAY-user-role-submit");
                    l.layui.form.on("submit(LAY-user-role-submit)", function (t) {
                        t.field;
                        i.reload("LAY-user-back-role"), layer.close(e)
                    }), r.trigger("click")
                },
                success: function (e, t) {
                }
            })
        }
    }), e("useradmin", {})
});