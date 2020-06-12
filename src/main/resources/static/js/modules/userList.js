;layui.define(["table", "form"],
    function (t) {
        var e = layui.$, i = layui.table, n = layui.form;
        i.render({
            elem: "LAY-user-manage"
            , url:  layui.setter.serviceURI + "/user/getAll"
            , cols: [[{type: "checkbox", fixed: "left"}
                , {field: "userCode", width: 100, title: "用户编码", sort: !0}
                , {field: "userName", width: 100, title: "用户名称", sort: !0}
                , {field: "userSpell", width: 100, title: "拼音简码", sort: !0}
                , {field: "departCode", width: 100, title: "部门编码", sort: !0}
                , {field: "password", width: 100, title: "密码", sort: !0}
                , {field: "roleCoed", width: 100, title: "角色编码", sort: !0}
                , {field: "status", width: 100, title: "状态", sort: !0}
                , {title: "操作", minWidth: 150, align: "center", fixed: "right", toolbar: "#table-useradmin-webuser"}]]
            , page: !0
            , limit: 10
            , limits: [10, 15, 20, 25, 30]
            , text: "对不起，加载出现异常！"
        }), i.on("tool(table-useradmin-webuser)",
            function (t) {
                var e = t.data;
                "del" === t.event ? layer.confirm("您确定要删除当前用户信息？",
                    function (e) {
                        t.del(), layer.close(e)
                    }) : "edit" === t.event && layer.open({
                    type: 2
                    , title: "编辑用户"
                    , content: "addAdminForm"
                    , maxmin: !0
                    , area: ["550px", "550px"]
                    , btn: ["确定", "取消"]
                    , yes: function (e, i) {
                        var l = window["layui-layer-iframe" + e],
                            a = i.find("iframe").contents().find("#LAY-user-back-edit");
                        l.layui.form.on("submit(LAY-user-back-edit)",
                            function (i) {
                                var l = i.field;
                                t.update({
                                    id: l.id
                                    , userCode: l.userCode
                                    , userName: l.userName
                                    , userPwd: l.userPwd
                                    , phone: l.phone
                                    , email: l.email
                                    , status: l.status
                                }), n.render(), layer.close(e)
                            }), a.trigger("click")
                    }
                })
            }), i.render({})

    });