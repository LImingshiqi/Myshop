package com.lmx.myshop.web.admin.web.interceptor;

import com.lmx.myshop.commons.Context.ContansUtils;

import com.lmx.myshop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser user=(TbUser)httpServletRequest.getSession().getAttribute(ContansUtils.SESSION_USER);
       //判断用户是否登录
        if(user==null){
            //用户未登录,重定向到登录
            httpServletResponse.sendRedirect("/login");
            return false;
        }

        //放行
      return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        //如果请求来自登录页
//        if(modelAndView!=null && modelAndView.getViewName()!=null &&modelAndView.getViewName().endsWith("login")){
//            //直接重定向到首页 不在显示登录页
//            httpServletResponse.sendRedirect("home");
//        }

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
