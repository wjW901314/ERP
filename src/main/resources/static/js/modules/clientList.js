;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin, $ = layui.$;
    i.render({
        elem: "#client-manage",
        url: layui.setter.serviceURI + "/client/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "code", title: "编码", width: 80, sort: !0},
            {field: "name", title: "名称", minWidth: 200},
            {field: "spell", title: "拼音简码", width: 100},
            {field: "person", title: "联系人", width: 100},
            {field: "phone", title: "联系方式", width: 100},
            {field: "email", title: "电子邮件", width: 120},
            {field: "remarks", title: "备注", width: 200},
            {field: "status", title: "状态", width: 80},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-client-tools"
            }]],
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(client-manage)", function (e) {
            e.data;
            var jsonDta = {'code': "" + e.data.code + ""};
            if ("del" === e.event) {
                layer.confirm("您确定要删除当前行吗？", function (t) {
                    //执行 Ajax 后重载
                    admin.req({
                        url: layui.setter.serviceURI + '/client/delete'
                        , Method: 'GET'
                        , dataType: 'json'
                        , data: jsonDta
                        , done: function (r) {
                            if (r.success) {
                                e.del();
                                layer.close(t);
                                layer.msg(r.msg);
                            }
                        }
                    });
                })
            } else if ("edit" === e.event) {
                t(e.tr);
                console.log(e.data);
                layer.open({
                    type: 2,
                    title: "编辑客户信息",
                    content: "addClientInfo",
                    maxmin: !0,
                    area: ["500px", "450px"],
                    btn: ["确定", "取消"],
                    yes: function (e, t) {
                        var l = window["layui-layer-iframe" + e], r = "client-front-submit",
                            n = t.find("iframe").contents().find("#" + r);
                        l.layui.form.on("submit(" + r + ")", function (t) {
                            t.field;
                            $.ajax({
                                type: "POST"
                                , url: layui.setter.serviceURI + "/client/modify"
                                , contentType: "application/json"
                                , dataType: "JSON"
                                , data: JSON.stringify(t.field)
                                , success: function (res) {
                                    if (res.success) {
                                        i.reload("supplier-manage");
                                        layer.close(e); //关闭弹层
                                        layer.msg(res.msg);
                                    } else {
                                        layer.msg(res.msg);
                                    }
                                }
                            });
                        }), n.trigger("click")
                    },
                    success: function (layero, index) {
                        var body = layer.getChildFrame('body', index);
                        body.find('#code').val(e.data.code);
                        body.find('#name').val(e.data.name);
                        body.find('#spell').val(e.data.spell);
                        body.find('#person').val(e.data.person);
                        body.find('#phone').val(e.data.phone);
                        body.find('#email').val(e.data.email);
                        body.find('#remarks').val(e.data.remarks);
                        body.find('#status').val(e.data.status);
                    }
                })
            }
        }
    ), e("clientList", {})
});