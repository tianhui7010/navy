package com.navy.hangmu002.utils.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局捕获异常
 */
@ControllerAdvice
public class excep {


    /**
     * shiro 无权限异常
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public String errorHandler403(Exception ex) {
        System.out.println("捕获到403异常");
        return "403";

    }



}
