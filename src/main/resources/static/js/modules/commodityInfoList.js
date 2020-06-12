;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin, $ = layui.$;
    i.render({
        elem: "#commodityInfo-manage",
        url: layui.setter.serviceURI + "/commodityInfo/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "commodityCode", title: "商品编码", width: 120, sort: !0},
            {field: "commodityName", title: "商品名称", minWidth: 150},
            {field: "commoditySpell", title: "拼音简码", width: 100},
            {field: "specName", title: "规格", width: 100},
            {field: "typeName", title: "类型", width: 100},
            {field: "unitName", title: "单位", width: 80},
            {field: "supplierName", title: "供应商", width: 150},
            {field: "statusName", title: "状态", width: 80},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-commodityInfo-tools"
            }]],
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), i.on("tool(commodityInfo-manage)", function (e) {
        e.data;
        console.log(e.data.departCode);
        var jsonDta = {'specCode': "" + e.data.specCode + ""};
        if ("del" === e.event) layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
            layer.close(i), layer.confirm("真的删除行么", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/commodityInfo/delete'
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
                title: "编辑商品信息",
                content: "addCommodityInfo",
                maxmin: !0,
                area: ["500px", "500px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "commodityInfo-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            type: "POST"
                            , url: layui.setter.serviceURI + "/commodityInfo/modify"
                            , contentType: "application/json"
                            , dataType: "JSON"
                            , data: JSON.stringify(t.field)
                            , success: function (res) {
                                if (res.success) {
                                    i.reload("commodityInfo-manage");
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
                    body.find('#commodityCode').val(e.data.commodityCode);
                    body.find('#commodityName').val(e.data.commodityName);
                    body.find('#commoditySpell').val(e.data.commoditySpell);
                    body.find('#specName').val(e.data.specName);
                    body.find('#typeName').val(e.data.typeName);
                    body.find('#unitName').val(e.data.unitName);
                    body.find('#supplierName').val(e.data.supplierName);
                    body.find('#status').val(e.data.status);
                }
            })
        }
    }), e("commodityInfoList", {})
});