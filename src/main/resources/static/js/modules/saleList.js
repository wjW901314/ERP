;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin, $ = layui.$;
    i.render({
        elem: "#commoditySale-manage",
        toolbar: true,
        totalRow: true,
        defaultToolbar: ['filter', 'exports', 'print'],
        url: layui.setter.serviceURI + "/sale/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "id", title: "ID", width: 110, sort: true, unresize: true, totalRowText: "合计:"},
            {field: "commodityName", title: "商品名称", minWidth: 200},
            {field: "specName", title: "规格", width: 80},
            {field: "typeName", title: "商品类型", width: 90},
            {field: "unitName", title: "单位", width: 80},
            {field: "salePrice", title: "售价", width: 80, totalRow: true},
            {field: "saleNumber", title: "数量", width: 80, totalRow: true},
            {field: "supplierName", title: "供应商", width: 150},
            {field: "clientName", title: "客户", width: 150},
            {field: "saleDate", title: "销售日期", width: 120},
            {field: "statusName", title: "状态", width: 80},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-commoditySale-tools"
            }]],
        height: "full-220",
        page: true,
        limit: 30,
        text: "对不起，加载出现异常！"
    }), i.on("tool(commoditySale-manage)", function (e) {
        e.data;
        console.log(e.data.departCode);
        var jsonDta = {'id': "" + e.data.id + ""};
        if ("del" === e.event){
            layer.confirm("真的删除行么", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/sale/delete'
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
        }
        else if ("edit" === e.event) {
            t(e.tr);
            layer.open({
                type: 2,
                title: "编辑商品销售",
                content: "addCommoditySale",
                maxmin: !0,
                area: ["500px", "600px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "commoditySale-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            type: "POST"
                            , url: layui.setter.serviceURI + "/sale/modify"
                            , contentType: "application/json"
                            , dataType: "JSON"
                            , data: JSON.stringify(t.field)
                            , success: function (res) {
                                if (res.success) {
                                    i.reload("commoditySale-manage");
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
                    var iframe = window["layui-layer-iframe" + index];
                    iframe.child(e.data);

                    // var body = layer.getChildFrame('body', index);
                    // body.find('#commodityList').val(e.data.commodityName);
                    // body.find('#commoditySpell').val(e.data.commoditySpell);
                    // body.find('#salePrice').val(e.data.salePrice);
                    // body.find('#saleNumber').val(e.data.saleNumber);
                    // body.find('#clientList').val(e.data.clientName);

                }
            })
        } else if ("toExam" === e.event) {
            layer.confirm("您确定要审核当前进货记录吗？", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/sale/auditVoidRecord'
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
                    url: layui.setter.serviceURI + '/sale/auditVoidRecord'
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
    }), e("saleList", {})
});