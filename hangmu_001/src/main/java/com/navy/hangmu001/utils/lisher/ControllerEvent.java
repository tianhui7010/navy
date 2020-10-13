package com.navy.hangmu001.utils.lisher;

import org.springframework.context.ApplicationEvent;

/**
 * 监听器三要素：事件
 */
public class ControllerEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String msg;

    public ControllerEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
