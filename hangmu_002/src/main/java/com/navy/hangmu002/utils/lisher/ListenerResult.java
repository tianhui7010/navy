package com.navy.hangmu002.utils.lisher;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 监听到相关事件后的操作
 */
@Component
public class ListenerResult {

    @EventListener
    public void listener(ControllerEvent event) {
        System.out.println("监听到ControllerEvent事件:" + event.getMsg());
    }

}
