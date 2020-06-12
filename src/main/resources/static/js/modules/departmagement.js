/** layuiAdmin.std-v1.4.0 LPPL License By https://www.layui.com/admin/ */
;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin,$=layui.$;
    i.render({
        elem: "#depart-manage",
        url: layui.setter.serviceURI + "/depart/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "departCode", title: "部门编码", width: 120, sort: !0},
            {field: "departName", title: "部门名称", minWidth: 150},
            {field: "departSpell", title: "拼音简码", width: 100},
            {field: "remarks", title: "备注", width: 200},
            {field: "status", title: "状态", width: 80},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-depart-tools"
            }]],
        page: !0,
        limit: 30,
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(depart-manage)", function (e) {
        e.data;
        console.log(e.data.departCode);
        var jsonDta = {'departCode': "" + e.data.departCode + ""};
        if ("del" === e.event) layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
            layer.close(i), layer.confirm("真的删除行么", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/depart/deleteById'
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
                // e.del(), layer.close(t)
            })
        }); else if ("edit" === e.event) {
            t(e.tr);
            console.log(e.data);
            layer.open({
                type: 2,
                title: "编辑部门",
                shadeClose: true,
                shade: 0.4,
                content: "addDepartment",
                maxmin: !0,
                area: ["500px", "450px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "depart-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            type: "POST"
                            , url: layui.setter.serviceURI + "/depart/modify"
                            , contentType: "application/json"
                            , dataType: "JSON"
                            , data: JSON.stringify(t.field)
                            , success: function (res) {
                                if (res.success) {
                                    i.reload("depart-manage");
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
                    body.find('#departCode').val(e.data.departCode);
                    body.find('#departName').val(e.data.departName);
                    body.find('#departSpell').val(e.data.departSpell);
                    body.find('#remarks').val(e.data.remarks);
                    body.find('#status').val(e.data.status);
                }
            })
        }
    }), e("departmagement", {})
});