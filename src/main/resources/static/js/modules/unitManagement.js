/** layuiAdmin.std-v1.4.0 LPPL License By https://www.layui.com/admin/ */
;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin,$=layui.$;
    i.render({
        elem: "#unit-manage",
        url: layui.setter.serviceURI + "/MeteringCompany/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "unitCode", title: "单位编码", width: 120, sort: !0},
            {field: "unitName", title: "单位名称", minWidth: 150},
            {field: "unitSpell", title: "拼音简码", width: 100},
            {field: "status", title: "状态", width: 80},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-unit-tools"
            }]],
        page: !0,
        limit: 30,
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(unit-manage)", function (e) {
        e.data;
        console.log(e.data.departCode);
        var jsonDta = {'unitCode': "" + e.data.unitCode + ""};
        if ("del" === e.event) layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
            layer.close(i), layer.confirm("真的删除行么", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/MeteringCompany/delete'
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
                content: "addUnit",
                maxmin: !0,
                area: ["500px", "450px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "unit-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            type: "POST"
                            , url: layui.setter.serviceURI + "/MeteringCompany/modify"
                            , contentType: "application/json"
                            , dataType: "JSON"
                            , data: JSON.stringify(t.field)
                            , success: function (res) {
                                if (res.success) {
                                    i.reload("unit-manage");
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
                    body.find('#unitCode').val(e.data.unitCode);
                    body.find('#unitName').val(e.data.unitName);
                    body.find('#unitSpell').val(e.data.unitSpell);
                    body.find('#status').val(e.data.status);
                }
            })
        }
    }), e("unitManagement", {})
});