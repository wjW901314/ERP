;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin, $ = layui.$;
    i.render({
        elem: "#stock-manage",
        toolbar: true,
        totalRow: true,
        defaultToolbar: ['filter', 'exports', 'print'],
        url: layui.setter.serviceURI + "/stock/getAll",
        cols: [[{type: "checkbox", fixed: "left"},
            {field: "id", title: "ID", width: 110, sort: true, unresize: true, totalRowText: "合计:"},
            {field: "commodityName", title: "商品名称", minWidth: 200},
            {field: "specName", title: "规格", width: 80},
            {field: "typeName", title: "商品类型", width: 90},
            {field: "supplierName", title: "供应商", width: 150},
            {field: "largeUnit", title: "大单位", width: 80},
            {field: "smallUnit", title: "小单位", width: 80},
            {field: "price", title: "单价", width: 80, totalRow: true},
            {field: "totalPrice", title: "总价", width: 80, totalRow: true},
            {field: "inventory", title: "数量", width: 80, totalRow: true},
            {field: "minimumInventory", title: "库存下限", width: 100},
            {
                title: "操作", width: 150, align: "center", fixed: "right", toolbar: "#table-stock-tools"
            }]],
        height: "full-220",
        page: true,
        limit: 30,
        text: "对不起，加载出现异常！"
    }), i.on("tool(stock-manage)", function (e) {
        e.data;
        console.log(e.data.departCode);
        var jsonDta = {'specCode': "" + e.data.specCode + ""};
        if ("del" === e.event) layer.prompt({formType: 1, title: "敏感操作，请验证口令"}, function (t, i) {
            layer.close(i), layer.confirm("真的删除行么", function (t) {
                //执行 Ajax 后重载
                admin.req({
                    url: layui.setter.serviceURI + '/stock/delete'
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
                content: "addCommodityStock",
                maxmin: !0,
                area: ["500px", "450px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e], r = "stock-front-submit",
                        n = t.find("iframe").contents().find("#" + r);
                    l.layui.form.on("submit(" + r + ")", function (t) {
                        t.field;
                        $.ajax({
                            type: "POST"
                            , url: layui.setter.serviceURI + "/stock/modify"
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
                    body.find('#commodityName').val(e.data.commodityName);
                    body.find('#specName').val(e.data.specName);
                    body.find('#typeName').val(e.data.typeName);
                    body.find('#supplierName').val(e.data.supplierName);
                    body.find('#largeUnit').val(e.data.largeUnit);
                    body.find('#smallUnit').val(e.data.smallUnit);
                    body.find('#price').val(e.data.price);
                    body.find('#totalPrice').val(e.data.totalPrice);
                    body.find('#inventory').val(e.data.inventory);
                    body.find('#minimumInventory').val(e.data.minimumInventory);
                }
            })
        }
    }), e("stockList", {})
});