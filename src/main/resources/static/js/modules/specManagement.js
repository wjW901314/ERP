;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin, $ = layui.$;
    i.render({
        elem: "#spec-manage",
        url: layui.setter.serviceURI + "/spec/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "specCode", title: "规格编码", width: 120, sort: !0},
            {field: "specName", title: "规格名称", minWidth: 150},
            {field: "specSpell", title: "拼音简码", width: 100},
            {field: "status", title: "状态", width: 80},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-spec-tools"
            }]],
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(spec-manage)", function (e) {
        e.data;
        console.log(e.data.departCode);
        var jsonDta = {'specCode': "" + e.data.specCode + ""};
        if ("del" === e.event) layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
            layer.close(i), layer.confirm("真的删除行么", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/spec/delete'
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
        }); else if ("edit" === e.event) {
            t(e.tr);
            console.log(e.data);
            layer.open({
                type: 2,
                title: "编辑商品规格",
                content: "addSpec",
                maxmin: !0,
                area: ["500px", "450px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "spec-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            type: "POST"
                            , url: layui.setter.serviceURI + "/spec/modify"
                            , contentType: "application/json"
                            , dataType: "JSON"
                            , data: JSON.stringify(t.field)
                            , success: function (res) {
                                if (res.success) {
                                    i.reload("spec-manage");
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
                    body.find('#specCode').val(e.data.specCode);
                    body.find('#specName').val(e.data.specName);
                    body.find('#specSpell').val(e.data.specSpell);
                    body.find('#status').val(e.data.status);
                }
            })
        }
    }), e("specManagement", {})
});