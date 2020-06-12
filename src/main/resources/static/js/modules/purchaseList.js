;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin, $ = layui.$;
    i.render({
        elem: "#commodityPurchase-manage",
        toolbar: true,
        totalRow: true,
        defaultToolbar: ['filter', 'exports', 'print'],
        url: layui.setter.serviceURI + "/commodityPurchase/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "id", title: "ID", width: 110, sort: true, unresize: true, totalRowText: "合计:"},
            {field: "commodityName", title: "商品名称", minWidth: 200},
            {field: "specName", title: "规格", width: 80},
            {field: "typeName", title: "商品类型", width: 90},
            {field: "unitName", title: "单位", width: 80},
            {field: "purchasingCost", title: "成本", width: 80, totalRow: true},
            {field: "purchasePrice", title: "单价", width: 80, totalRow: true},
            {field: "sellingPrice", title: "售价", width: 80, totalRow: true},
            {field: "purchaseNumber", title: "数量", width: 80, totalRow: true},
            {field: "supplierName", title: "供应商", width: 150},
            {field: "purchaseDate", title: "进货日期", width: 120},
            {field: "statusName", title: "状态", width: 80},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-commodityPurchase-tools"
            }]],
        height: "full-220",
        page: true,
        limit: 30,
        text: "对不起，加载出现异常！"
    }), i.on("tool(commodityPurchase-manage)", function (e) {
        e.data;
        console.log(e.data.departCode);
        var jsonDta = {'id': "" + e.data.id + ""};
        if ("del" === e.event) layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
            layer.close(i), layer.confirm("真的删除行么", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/commodityPurchase/delete'
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
        });
        else if ("edit" === e.event) {
            t(e.tr);
            console.log(e.data);
            layer.open({
                type: 2,
                title: "编辑商品进货信息",
                content: "addCommodityPurchase",
                maxmin: !0,
                area: ["500px", "600px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "commodityPurchase-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            type: "POST"
                            , url: layui.setter.serviceURI + "/commodityPurchase/modify"
                            , contentType: "application/json"
                            , dataType: "JSON"
                            , data: JSON.stringify(t.field)
                            , success: function (res) {
                                if (res.success) {
                                    i.reload("stock-manage");
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
                    body.find('#commodityList').val(e.data.commodityName);
                    body.find('#commoditySpell').val(e.data.commoditySpell);
                    body.find('#specList').val(e.data.specName);
                    body.find('#typeList').val(e.data.typeName);
                    body.find('#supplierList').val(e.data.supplierName);
                    body.find('#unitList').val(e.data.unitName);
                    body.find('#purchasingCost').val(e.data.purchasingCost);
                    body.find('#purchasePrice').val(e.data.purchasePrice);
                    body.find('#sellingPrice').val(e.data.sellingPrice);
                    body.find('#purchaseNumber').val(e.data.purchaseNumber);
                }
            })
        } else if ("toExam" === e.event) {
            layer.confirm("您确定要审核当前进货记录吗？", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/commodityPurchase/auditVoidRecord'
                    , Method: 'GET'
                    , dataType: 'json'
                    , data: {'id': "" + e.data.id + "", 'status': 1}
                    , done: function (r) {
                        if (r.success) {
                            layer.close(t);
                            layer.msg(r.msg);
                        }
                    }
                });
            });
        } else if ("toVoid" === e.event) {
            layer.confirm("您确定要作废当前进货记录吗？", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/commodityPurchase/auditVoidRecord'
                    , Method: 'GET'
                    , dataType: 'json'
                    , data: {'id': "" + e.data.id + "", 'status': 2}
                    , done: function (r) {
                        if (r.success) {
                            layer.close(t);
                            layer.msg(r.msg);
                        }
                    }
                });
            });
        }
    }), e("purchaseList", {})
});