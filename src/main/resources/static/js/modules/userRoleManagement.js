;layui.define(['table', 'form'], function (e) {
    var $ = layui.$
        , table = layui.table
        , form = layui.form
        , admin = layui.admin;
    table.render({
        elem: "user-role-manage"
        , url: layui.setter.serviceURI + "/user/role/getAll"
        , cols: [[{type: "checked", fixed: "left"},
            {field: "roleCode", title: "角色编码", width: 120, sort: !0},
            {filed: "roleName", title: "角色名称", width: 120},
            {filed: "roleSpell", title: "拼音简码", width: 100},
            {filed: "status", title: "状态", width: 80},
            {title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-user_role-tools"}
        ]]
        , page: !0
        , limit: 30
        , height: "full-220"
        , text: "对不起，加载出现异常！"
    }), table.on("tool(user-role-manage", function (e) {
        e.data;
        console.log(e.data);
        if ("del" === e.event) {
            layer.confirm("您确定要删除当前选中行吗？", function (index) {
                $.ajax({
                    type: "GET"
                    , url: layui.setter.serviceURI + "/user/role/delete"
                    , data: {"roleCode": "" + e.data.roleCode + ""}
                    , dataType: "JSON"
                    , contentType: "application/json"
                    , success: function (res) {
                        if (res.success) {
                            layer.msg(res.msg);
                            table.del();
                            layer.close(index);
                        }
                    }
                })
            })
        } else if ("edit" === e.event) {
            $(e.tr);
            layer.open({
                type: 2
                , title: "编辑用户角色"
                , shadeClose: true
                , shade: 0.4
                , content: "user/addRoleForm"
                , maxmin: !0
                , area: ["550px", "550px"]
                , btn: ["确定", "取消"]
                , yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e]
                        , r = "user-role-front-submit"
                        , n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            url: layui.setter.serviceURI + "/user/role/modify"
                            , contentType: ""
                            , type: "POST"
                            , data: JSON.stringify(t.field)
                            , dataType: "JSON"
                            , success: function (res) {
                                if (res.success) {
                                    layer.msg(res.msg);
                                    layer.close(e);
                                    table.reload("user-role-manage");
                                }
                            }
                        });
                    }), n.trigger("click")
                }
                , success: function (l, i) {
                    var body = layer.getChildFrame('body', i);
                    body.find("#roleCode").val(e.data.roleCode);
                    body.find("#roleName").val(e.data.roleName);
                    body.find("#roleSpell").val(e.data.roleSpell);
                    body.find("#status").val(e.data.status);
                }
            })
        }
    }), e("userRoleManagement", {})
});