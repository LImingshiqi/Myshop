package com.lmx.myshop.web.ui.interceptor;

import com.lmx.myshop.web.ui.constant.SystemConstants;
import com.lmx.myshop.web.ui.dto.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 * 登录拦截器
 * Created by LMX on 2019/8/1 14:37
 *
 */

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TbUser tbUser= (TbUser) request.getSession().getAttribute(SystemConstants.SESSION_USER_KEY);
        //未登录状态
        if(tbUser==null){
            return true;
        }
        //已登录状态
        else {
            response.sendRedirect("/index");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
