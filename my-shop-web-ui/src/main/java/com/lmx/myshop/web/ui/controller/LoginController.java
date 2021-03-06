package com.lmx.myshop.web.ui.controller;

import com.lmx.myshop.commons.dto.BaseResult;
import com.lmx.myshop.commons.utils.EmailSendUtils;



import com.lmx.myshop.web.ui.API.UserApi;
import com.lmx.myshop.web.ui.constant.SystemConstants;
import com.lmx.myshop.web.ui.dto.TbUser;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.google.code.kaptcha.Constants;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LMX on 2019/8/1 11:13
 */
@Controller
public class LoginController {
    @Autowired
    private EmailSendUtils emailSendUtils;

    /**
     *跳转到登录页
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }


    /**
     *
     * 登录
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request)throws  Exception{
        //验证码失败
        if(!checkVerification(tbUser,request) ){
            model.addAttribute("baseResult", BaseResult.fail("验证码失败,请重新登录"));
            return "login";
        }
        //登录失败
        TbUser user= UserApi.login(tbUser);
        if(user==null){
            model.addAttribute("baseResult",BaseResult.fail("用户名或密码输入错误,请重新输入"));
            return "login";
        }
        //登录成功
        else{
//            emailSendUtils.send("用户登录",String.format("用户 【%s】 登录 Myshop ",user.getUsername()),"limingxuan@limart.com");
//            //将会员信息放入session中
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY,user);
            return"redirect:/index";
        }

    }
    /**
     *
     * 注销
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
           return "redirect:/index";
        }





    /**
     * 检查验证码
     *
     */
    public boolean checkVerification(TbUser tbUser, HttpServletRequest request){
    String verfication=(String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
    if(StringUtils.equals(verfication,tbUser.getVerification())){
            return true;
    }

        return  false;
    }


}
