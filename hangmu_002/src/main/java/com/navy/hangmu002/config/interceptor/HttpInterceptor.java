package com.navy.hangmu002.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 52613 on 2019/8/24.
 */
@Slf4j
public class HttpInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)       throws Exception {

        log.debug("拦截器执行航母_002 ");
        String originHeader=request.getHeader("origin");
        response.addHeader("Access-Control-Allow-Origin",originHeader);
        response.addHeader("Access-Control-Allow-Method","POST,GET,OPTIONS,DELETE");
        response.addHeader("Access-Control-Allow-Headers","content-type,x-requested-with");
        response.addHeader("Access-Control-Allow-Credentials","true");
        return  true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
