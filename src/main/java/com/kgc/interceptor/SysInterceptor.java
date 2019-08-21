package com.kgc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kgc.pojo.User;

public class SysInterceptor extends HandlerInterceptorAdapter
{

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//        throws Exception
//    {
//        // TODO Auto-generated method stub
//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("userSession");
//        if (null == user)
//        {
//            response.sendRedirect(request.getContextPath()+"/401.jsp");
//            return false;
//        }
//        else {
//            return true;
//        }
//    }
    
}
