package com.lmx.myshop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String Register(){
        System.out.println("注册");

        return "register";
    }
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String admin(){


        return "home";
    }

}
