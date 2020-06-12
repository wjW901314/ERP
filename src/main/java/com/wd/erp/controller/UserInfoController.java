package com.wd.erp.controller;

import com.wd.erp.model.ResultJson;
import com.wd.erp.model.UserInfo;
import com.wd.erp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/userBak")
public class UserInfoController {

    @Autowired
    UserInfoService userService;


    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserInfo user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

//    @RequestMapping("/checkUserInfo")
    @ResponseBody
    @GetMapping("/checkUserInfo")
    public ResultJson checkUserInfo(@RequestParam(name = "userCode") int userCoed,@RequestParam(name = "userPwd")String userPwd){
        ResultJson result = new ResultJson();
        boolean flag = userService.getUserInfo(userCoed,userPwd);
        if(flag) {
            result.setSuccess(true);
            result.setCode(0);
            result.setMsg("登录成功！");
        }
        return result;
    }

    @RequestMapping("/login")
    public String loginUser(@RequestParam(name = "userCode") int userCoed,@RequestParam(name = "userPwd")String userPwd){
        boolean flag = userService.getUserInfo(userCoed,userPwd);
        if(flag)
            return "redirect:main.html";
        else
            return "login";
    }


}
