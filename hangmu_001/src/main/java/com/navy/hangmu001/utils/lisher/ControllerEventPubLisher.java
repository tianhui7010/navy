package com.navy.hangmu001.utils.lisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 监听器三要素：发布事件
 */
@Component
public class ControllerEventPubLisher {
    @Autowired
    private ApplicationContext applicationContext;

    // 事件发布方法
    public void pushListener(String msg) {
        applicationContext.publishEvent(new ControllerEvent(this, msg));
    }
}
