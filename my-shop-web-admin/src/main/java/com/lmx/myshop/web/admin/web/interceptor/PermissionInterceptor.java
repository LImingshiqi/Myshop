package com.lmx.myshop.web.admin.web.interceptor;

import com.lmx.myshop.commons.Context.ContansUtils;

import com.lmx.myshop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if(modelAndView!=null && modelAndView.getViewName()!=null && modelAndView.getViewName().endsWith("login")){
            TbUser user=(TbUser)httpServletRequest.getSession().getAttribute(ContansUtils.SESSION_USER);
            if(user!=null){
                httpServletResponse.sendRedirect("/home");
            }
        }


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
