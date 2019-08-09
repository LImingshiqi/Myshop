package com.lmx.myshop.web.ui.controller;

import com.lmx.myshop.commons.utils.EmailSendUtils;
import com.lmx.myshop.web.ui.API.UserApi;
import com.lmx.myshop.web.ui.constant.SystemConstants;
import com.lmx.myshop.web.ui.dto.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LMX on 2019/8/1 14:42
 */
@Controller
public class RegisterController {


    @Autowired
   private EmailSendUtils emailSendUtils;

    /**
     * 注册
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(TbUser tbUser, Model model, HttpServletRequest request)throws Exception{
        TbUser user= UserApi.register(tbUser);
        if(user==null){
            model.addAttribute("注册失败,请重新输入");
            return "register";
        }
        else
            {
            emailSendUtils.send("用户注册成功",String.format("用户 【%s】 注册到 Myshop ",user.getUsername()),"limingxuan@limart.com");
            return"redirect:/register";
        }
    }

    /**
     * 跳转到注册器
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }




}
