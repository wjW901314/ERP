/** layuiAdmin.std-v1.4.0 LPPL License By https://www.layui.com/admin/ */
;layui.define(function (e) {
    layui.use(["admin", "carousel"], function () {
        var e = layui.$, a = (layui.admin, layui.carousel), t = layui.element, i = layui.device();
        e(".layadmin-carousel").each(function () {
            var t = e(this);
            a.render({
                elem: this,
                width: "100%",
                arrow: "none",
                interval: t.data("interval"),
                autoplay: t.data("autoplay") === !0,
                trigger: i.ios || i.android ? "click" : "hover",
                anim: t.data("anim")
            })
        }), t.render("progress")
    }), layui.use(["carousel", "echarts"], function () {
        var e = layui.$,
            a = (layui.carousel, layui.echarts),
            t = [],
            i = [{
                title: {text: "商品进销情况", subtext: "测试数据"},
                tooltip: {trigger: "axis"},
                legend: {data: ["进货数量", "销售数量"]},
                calculable: !0,
                xAxis: [{
                    type: "category",
                    data:
                        ["1月",
                            "2月",
                            "3月",
                            "4月",
                            "5月",
                            "6月",
                            "7月",
                            "8月",
                            "9月",
                            "10月",
                            "11月",
                            "12月"]
                }],
                yAxis: [{type: "value"}],
                series: [{
                    name: "进货数量",
                    type: "bar",
                    data:
                        [
                            2,
                            4.9,
                            7,
                            23.2,
                            25.6,
                            76.7,
                            135.6,
                            162.2,
                            32.6,
                            20,
                            6.4,
                            3.3],
                    markPoint: {
                        data: [{type: "max", name: "最大值"}, {type: "min", name: "最小值"}]
                    },
                    markLine: {
                        data: [{type: "average", name: "平均值"}]
                    }
                }, {
                    name: "销售数量",
                    type: "bar",
                    data:
                        [2.6, 5.9, 9, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6, 2.3],
                    markPoint: {
                        data: [
                            {name: "年最高", value: 182.2, xAxis: 7, yAxis: 183, symbolSize: 18},
                            {name: "年最低", value: 2.3, xAxis: 11, yAxis: 3}]
                    },
                    markLine: {data: [{type: "average", name: "平均值"}]}
                }]
            }],
            n = e("#LAY-index-normcol").children("div"),
            l = function (e) {
                t[e] = a.init(n[e], layui.echartsTheme),
                    t[e].setOption(i[e]),
                    window.onresize = t[e].resize
            };
        if (n[0]) {
            l(0);
            var r = [], o = [{
                tooltip: {trigger: "axis", axisPointer: {type: "shadow"}},
                legend: {data: ["直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎", "百度", "谷歌", "必应", "其他"]},
                calculable: !0,
                xAxis: [{type: "category", data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]}],
                yAxis: [{type: "value"}],
                series: [
                    {name: "直接访问", type: "bar", data: [320, 332, 301, 334, 390, 330, 320]},
                    {name: "邮件营销", type: "bar", stack: "广告", data: [120, 132, 101, 134, 90, 230, 210]},
                    {name: "联盟广告", type: "bar", stack: "广告", data: [220, 182, 191, 234, 290, 330, 310]},
                    {name: "视频广告", type: "bar", stack: "广告", data: [150, 232, 201, 154, 190, 330, 410]},
                    {
                        name: "搜索引擎", type: "bar", data: [862, 1018, 964, 1026, 1679, 1600, 1570],
                        markLine: {
                            itemStyle: {normal: {lineStyle: {type: "dashed"}}},
                            data: [[{type: "min"}, {type: "max"}]]
                        }
                    }, {
                        name: "百度",
                        type: "bar",
                        barWidth: 5,
                        stack: "搜索引擎",
                        data: [620, 732, 701, 734, 1090, 1130, 1120]
                    }, {name: "谷歌", type: "bar", stack: "搜索引擎", data: [120, 132, 101, 134, 290, 230, 220]}, {
                        name: "必应",
                        type: "bar",
                        stack: "搜索引擎",
                        data: [60, 72, 71, 74, 190, 130, 110]
                    }, {name: "其他", type: "bar", stack: "搜索引擎", data: [62, 82, 91, 84, 109, 110, 120]}]
            }], m = e("#LAY-index-heapcol").children("div"), s = function (e) {
                r[e] = a.init(m[e], layui.echartsTheme), r[e].setOption(o[e]), window.onresize = r[e].resize
            };
            if (m[0]) {
                s(0);
                var y = [], d = [{
                    title: {text: "双数值柱形图", subtext: "纯属虚构"},
                    tooltip: {
                        trigger: "axis",
                        axisPointer: {show: !0, type: "cross", lineStyle: {type: "dashed", width: 1}},
                        formatter: function (e) {
                            return e.seriesName + " : [ " + e.value[0] + ", " + e.value[1] + " ]"
                        }
                    },
                    legend: {data: ["数据1", "数据2"]},
                    calculable: !0,
                    xAxis: [{type: "value"}],
                    yAxis: [{type: "value", axisLine: {lineStyle: {color: "#dc143c"}}}],
                    series: [{
                        name: "数据1",
                        type: "bar",
                        data: [[1.5, 10], [5, 7], [8, 8], [12, 6], [11, 12], [16, 9], [14, 6], [17, 4], [19, 9]],
                        markPoint: {
                            data: [{
                                type: "max",
                                name: "最大值",
                                symbol: "emptyCircle",
                                itemStyle: {normal: {color: "#dc143c", label: {position: "top"}}}
                            }, {
                                type: "min",
                                name: "最小值",
                                symbol: "emptyCircle",
                                itemStyle: {normal: {color: "#dc143c", label: {position: "bottom"}}}
                            }, {
                                type: "max",
                                name: "最大值",
                                valueIndex: 0,
                                symbol: "emptyCircle",
                                itemStyle: {normal: {color: "#1e90ff", label: {position: "right"}}}
                            }, {
                                type: "min",
                                name: "最小值",
                                valueIndex: 0,
                                symbol: "emptyCircle",
                                itemStyle: {normal: {color: "#1e90ff", label: {position: "left"}}}
                            }]
                        },
                        markLine: {
                            data: [{
                                type: "max",
                                name: "最大值",
                                itemStyle: {normal: {color: "#dc143c"}}
                            }, {type: "min", name: "最小值", itemStyle: {normal: {color: "#dc143c"}}}, {
                                type: "average",
                                name: "平均值",
                                itemStyle: {normal: {color: "#dc143c"}}
                            }, {
                                type: "max",
                                name: "最大值",
                                valueIndex: 0,
                                itemStyle: {normal: {color: "#1e90ff"}}
                            }, {
                                type: "min",
                                name: "最小值",
                                valueIndex: 0,
                                itemStyle: {normal: {color: "#1e90ff"}}
                            }, {type: "average", name: "平均值", valueIndex: 0, itemStyle: {normal: {color: "#1e90ff"}}}]
                        }
                    }, {
                        name: "数据2",
                        type: "bar",
                        barHeight: 10,
                        data: [[1, 2], [2, 3], [4, 4], [7, 5], [11, 11], [18, 15]]
                    }]
                }], c = e("#LAY-index-diffcol").children("div"), p = function (e) {
                    y[e] = a.init(c[e], layui.echartsTheme), y[e].setOption(d[e]), window.onresize = y[e].resize
                };
                if (c[0]) {
                    p(0);
                    var u = [], x = [{
                        title: {
                            x: "center",
                            text: "ECharts例子个数统计",
                            subtext: "Rainbow bar example",
                            link: "http://echarts.baidu.com/doc/example.html"
                        },
                        tooltip: {trigger: "item"},
                        calculable: !0,
                        grid: {borderWidth: 0, y: 80, y2: 60},
                        xAxis: [{
                            type: "category",
                            show: !1,
                            data: ["Line", "Bar", "Scatter", "K", "Pie", "Radar", "Chord", "Force", "Map", "Gauge", "Funnel"]
                        }],
                        yAxis: [{type: "value", show: !1}],
                        series: [{
                            name: "ECharts例子个数统计",
                            type: "bar",
                            itemStyle: {
                                normal: {
                                    color: function (e) {
                                        var a = ["#C1232B", "#B5C334", "#FCCE10", "#E87C25", "#27727B", "#FE8463", "#9BCA63", "#FAD860", "#F3A43B", "#60C0DD", "#D7504B", "#C6E579", "#F4E001", "#F0805A", "#26C0C0"];
                                        return a[e.dataIndex]
                                    }, label: {show: !0, position: "top", formatter: "{b}\n{c}"}
                                }
                            },
                            data: [12, 21, 10, 4, 12, 5, 6, 5, 25, 23, 7],
                            markPoint: {
                                tooltip: {
                                    trigger: "item",
                                    backgroundColor: "rgba(0,0,0,0)",
                                    formatter: function (e) {
                                        return '<img src="' + e.data.symbol.replace("image://", "") + '"/>'
                                    }
                                },
                                data: [{xAxis: 0, y: 350, name: "Line", symbolSize: 20}, {
                                    xAxis: 1,
                                    y: 350,
                                    name: "Bar",
                                    symbolSize: 20
                                }, {xAxis: 2, y: 350, name: "Scatter", symbolSize: 20}, {
                                    xAxis: 3,
                                    y: 350,
                                    name: "K",
                                    symbolSize: 20
                                }, {xAxis: 4, y: 350, name: "Pie", symbolSize: 20}, {
                                    xAxis: 5,
                                    y: 350,
                                    name: "Radar",
                                    symbolSize: 20
                                }, {xAxis: 6, y: 350, name: "Chord", symbolSize: 20}, {
                                    xAxis: 7,
                                    y: 350,
                                    name: "Force",
                                    symbolSize: 20
                                }, {xAxis: 8, y: 350, name: "Map", symbolSize: 20}, {
                                    xAxis: 9,
                                    y: 350,
                                    name: "Gauge",
                                    symbolSize: 20
                                }, {xAxis: 10, y: 350, name: "Funnel", symbolSize: 20}]
                            }
                        }]
                    }], v = e("#LAY-index-colorline").children("div"), b = function (e) {
                        u[e] = a.init(v[e], layui.echartsTheme), u[e].setOption(x[e]), window.onresize = u[e].resize
                    };
                    if (v[0]) {
                        b(0);
                        var h = [], f = [{
                            title: {text: "世界人口总量", subtext: "数据来自网络"},
                            tooltip: {trigger: "axis"},
                            legend: {data: ["2011年", "2012年"]},
                            calculable: !0,
                            xAxis: [{type: "value", boundaryGap: [0, .01]}],
                            yAxis: [{type: "category", data: ["巴西", "印尼", "美国", "印度", "中国", "世界人口(万)"]}],
                            series: [{
                                name: "2011年",
                                type: "bar",
                                data: [18203, 23489, 29034, 104970, 131744, 630230]
                            }, {name: "2012年", type: "bar", data: [19325, 23438, 31e3, 121594, 134141, 681807]}]
                        }], g = e("#LAY-index-normbar").children("div"), S = function (e) {
                            h[e] = a.init(g[e], layui.echartsTheme), h[e].setOption(f[e]), window.onresize = h[e].resize
                        };
                        if (g[0]) {
                            S(0);
                            var A = [], w = [{
                                tooltip: {trigger: "axis", axisPointer: {type: "shadow"}},
                                legend: {data: ["直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎"]},
                                calculable: !0,
                                xAxis: [{type: "value"}],
                                yAxis: [{type: "category", data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]}],
                                series: [{
                                    name: "直接访问",
                                    type: "bar",
                                    stack: "总量",
                                    itemStyle: {normal: {label: {show: !0, position: "insideRight"}}},
                                    data: [320, 302, 301, 334, 390, 330, 320]
                                }, {
                                    name: "邮件营销",
                                    type: "bar",
                                    stack: "总量",
                                    itemStyle: {normal: {label: {show: !0, position: "insideRight"}}},
                                    data: [120, 132, 101, 134, 90, 230, 210]
                                }, {
                                    name: "联盟广告",
                                    type: "bar",
                                    stack: "总量",
                                    itemStyle: {normal: {label: {show: !0, position: "insideRight"}}},
                                    data: [220, 182, 191, 234, 290, 330, 310]
                                }, {
                                    name: "视频广告",
                                    type: "bar",
                                    stack: "总量",
                                    itemStyle: {normal: {label: {show: !0, position: "insideRight"}}},
                                    data: [150, 212, 201, 154, 190, 330, 410]
                                }, {
                                    name: "搜索引擎",
                                    type: "bar",
                                    stack: "总量",
                                    itemStyle: {normal: {label: {show: !0, position: "insideRight"}}},
                                    data: [820, 832, 901, 934, 1290, 1330, 1320]
                                }]
                            }], k = e("#LAY-index-heapbar").children("div"), z = function (e) {
                                A[e] = a.init(k[e], layui.echartsTheme), A[e].setOption(w[e]), window.onresize = A[e].resize
                            };
                            if (k[0]) {
                                z(0);
                                var L = [], C = {normal: {label: {position: "right"}}}, P = [{
                                    title: {
                                        text: "交错正负轴标签",
                                        subtext: "From ExcelHome",
                                        sublink: "http://e.weibo.com/1341556070/AjwF2AgQm"
                                    },
                                    tooltip: {trigger: "axis", axisPointer: {type: "shadow"}},
                                    grid: {y: 80, y2: 30},
                                    xAxis: [{type: "value", position: "top", splitLine: {lineStyle: {type: "dashed"}}}],
                                    yAxis: [{
                                        type: "category",
                                        axisLine: {show: !1},
                                        axisLabel: {show: !1},
                                        axisTick: {show: !1},
                                        splitLine: {show: !1},
                                        data: ["ten", "nine", "eight", "seven", "six", "five", "four", "three", "two", "one"]
                                    }],
                                    series: [{
                                        name: "生活费",
                                        type: "bar",
                                        stack: "总量",
                                        itemStyle: {
                                            normal: {
                                                color: "orange",
                                                borderRadius: 5,
                                                label: {show: !0, position: "left", formatter: "{b}"}
                                            }
                                        },
                                        data: [{value: -.07, itemStyle: C}, {
                                            value: -.09,
                                            itemStyle: C
                                        }, .2, .44, {value: -.23, itemStyle: C}, .08, {
                                            value: -.17,
                                            itemStyle: C
                                        }, .47, {value: -.36, itemStyle: C}, .18]
                                    }]
                                }], T = e("#LAY-index-windline").children("div"), O = function (e) {
                                    L[e] = a.init(T[e], layui.echartsTheme), L[e].setOption(P[e]), window.onresize = L[e].resize
                                };
                                T[0] && O(0)
                            }
                        }
                    }
                }
            }
        }
    }), e("senior", {})
});