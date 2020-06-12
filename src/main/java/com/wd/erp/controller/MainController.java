package com.wd.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("user/login");
        return mv;
    }
}
