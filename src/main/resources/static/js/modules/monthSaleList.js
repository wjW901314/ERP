;layui.define(["table", "form"], function (e) {
    var t = layui.$, i = layui.table;
    form = layui.form, admin = layui.admin, $ = layui.$;
    i.render({
        elem: "#monthSale-manage",
        url: layui.setter.serviceURI + "/sale/commodityMonthSalReport",
        toolbar:true,
        defaultToolbar: ['filter', 'exports', 'print'],
        totalRow: true,
        cols: [[
            {field: "commodityName", title: "商品名称", minWidth: 200, totalRowText: "合计"},
            {field: "saleNumber", title: "数量", width: 100, totalRow: true},
            {field: "salePrice", title: "单价", width: 100},
            {field: "saleTotalPrice", title: "销售总价", width: 100, totalRow: true}]],
        height: "full-220",
        text: "对不起，加载出现异常！"
    }), e("monthSaleList", {})
});