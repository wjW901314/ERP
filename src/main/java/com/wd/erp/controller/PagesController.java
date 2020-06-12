package com.wd.erp.controller;

import com.wd.erp.model.BasisUserRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class PagesController {

    @RequestMapping("/main")
    public ModelAndView mainInfo() {
        ModelAndView mv = new ModelAndView("home/main");
        return mv;
    }

    @RequestMapping("/exit")
    public ModelAndView exit() {
        ModelAndView mv = new ModelAndView("user/login");
        return mv;
    }

    @RequestMapping("/console")
    public ModelAndView consoleInfo() {
        ModelAndView mv = new ModelAndView("home/console");
        return mv;
    }

    @RequestMapping("/homePageOne")
    public ModelAndView homePageOne() {
        ModelAndView mv = new ModelAndView("home/homepage1");
        return mv;
    }

    @RequestMapping("/homePageTwo")
    public ModelAndView homePageTwo() {
        ModelAndView mv = new ModelAndView("home/homepage2");
        return mv;
    }

    @RequestMapping("/department")
    public ModelAndView department() {
        ModelAndView mv = new ModelAndView("depart/departList");
        return mv;
    }

    @RequestMapping("/addDepartment")
    public ModelAndView addDepartment() {
        ModelAndView mv = new ModelAndView("depart/departForm");
        return mv;
    }

    @RequestMapping("/admin")
    public ModelAndView userInfo() {
        ModelAndView mv = new ModelAndView("user/list/userList");
        return mv;
    }

    @RequestMapping("/addAdminForm")
    public ModelAndView addAdminForm() {
        ModelAndView mv = new ModelAndView("user/list/userform");
        return mv;
    }

    @RequestMapping("/modifyPassWord")
    public ModelAndView modifyPassWord() {
        ModelAndView mv = new ModelAndView("user/password");
        return mv;
    }

    @RequestMapping("/user/roleList")
    public ModelAndView userList() {
        ModelAndView mv = new ModelAndView("user/roles/roleList");
        return mv;
    }

    @RequestMapping("/user/addRoleForm")
    public ModelAndView userForm() {
        ModelAndView mv = new ModelAndView("user/roles/roleForm");
        return mv;
    }

    @RequestMapping("/unitList")
    public ModelAndView unitList() {
        ModelAndView mv = new ModelAndView("dict/unit/unitList");
        return mv;
    }

    @RequestMapping("/addUnit")
    public ModelAndView addUnit() {
        ModelAndView mv = new ModelAndView("dict/unit/unitFrom");
        return mv;
    }

    @RequestMapping("/specList")
    public ModelAndView specList() {
        ModelAndView mv = new ModelAndView("dict/spec/specList");
        return mv;
    }

    @RequestMapping("/addSpec")
    public ModelAndView addSpec() {
        ModelAndView mv = new ModelAndView("dict/spec/specForm");
        return mv;
    }

    @RequestMapping("/typeList")
    public ModelAndView typeList() {
        ModelAndView mv = new ModelAndView("dict/type/typeList");
        return mv;
    }

    @RequestMapping("/addCommodityType")
    public ModelAndView addCommodityType() {
        ModelAndView mv = new ModelAndView("dict/type/typeForm");
        return mv;
    }

    @RequestMapping("/commodityInfo")
    public ModelAndView commodity() {
        ModelAndView mv = new ModelAndView("dict/commodity/commodityList");
        return mv;
    }

    @RequestMapping("/addCommodityInfo")
    public ModelAndView addCommodity() {
        ModelAndView mv = new ModelAndView("dict/commodity/commodityFrom");
        return mv;
    }

    @RequestMapping("/supplierInfoList")
    public ModelAndView supplierInfo() {
        ModelAndView mv = new ModelAndView("dict/supplier/supplierList");
        return mv;
    }

    @RequestMapping("/addSupplierInfo")
    public ModelAndView addSupplierInfo() {
        ModelAndView mv = new ModelAndView("dict/supplier/supplierFrom");
        return mv;
    }

    @RequestMapping("/commodityStockList")
    public ModelAndView commodityStockList() {
        ModelAndView mv = new ModelAndView("dict/stock/stockList");
        return mv;
    }

    @RequestMapping("/addCommodityStock")
    public ModelAndView addCommodityStock() {
        ModelAndView mv = new ModelAndView("dict/stock/stockFrom");
        return mv;
    }
    @RequestMapping("/commodityPurchaseList")
    public ModelAndView commodityPurchaseList(){
        ModelAndView mv = new ModelAndView("dict/purchase/purchaseList");
        return mv;
    }
    @RequestMapping("/addCommodityPurchase")
    public ModelAndView addCommodityPurchase(){
        ModelAndView mv = new ModelAndView("dict/purchase/purchaseForm");
        return mv;
    }

    @RequestMapping("/commoditySaleList")
    public ModelAndView commoditySaleList(){
        ModelAndView mv = new ModelAndView("dict/sale/saleList");
        return mv;
    }

    @RequestMapping("/addCommoditySale")
    public ModelAndView addCommoditySale(){
        ModelAndView mv = new ModelAndView("dict/sale/saleForm");
        return mv;
    }

    @RequestMapping("/clientInfoList")
    public ModelAndView clientInfoList(){
        ModelAndView mv = new ModelAndView("dict/client/clientList");
        return mv;
    }

    @RequestMapping("/addClientInfo")
    public ModelAndView addClientInfo(){
        ModelAndView mv = new ModelAndView("dict/client/clientForm");
        return mv;
    }

    @RequestMapping("/histogramReport")
    public ModelAndView histogramReport(){
        ModelAndView mv = new ModelAndView("dict/reports/histogramReport");
        return mv;
    }

    @RequestMapping("/LineChartReport")
    public ModelAndView LineChartReport(){
        ModelAndView mv = new ModelAndView("dict/reports/test");
        return mv;
    }

    @RequestMapping("/commodityMonthSalReport")
    public ModelAndView commodityMonthSalReport(){
        ModelAndView mv = new ModelAndView("tables/monthSaleList");
        return mv;
    }
}
