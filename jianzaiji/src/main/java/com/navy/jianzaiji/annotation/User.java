package com.navy.jianzaiji.annotation;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 52613 on 2019/8/23.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@FeignClient(value = User.User)
public @interface User {

    String User = "user";

}
