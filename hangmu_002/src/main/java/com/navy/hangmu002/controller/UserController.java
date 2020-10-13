package com.navy.hangmu002.controller;

import com.navy.hangmu002.controller.dto.UserDto;
import com.navy.hangmu002.utils.response.Response;
import com.navy.jianzaiji.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 52613 on 2019/12/3.
 */
@RestController
@Slf4j
public class UserController {

    @RequestMapping("login")
    public Response login(UserDto userDto) {
        log.debug("login userDto is {}", userDto);
        if (StringUtils.isEmpty(userDto.getUsername()) || StringUtils.isEmpty(userDto.getPassword())) {
            return Response.error("账号/密码不能为空!");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userDto.getUsername(), userDto.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            log.debug("获取 user name is {} ", user.getUserName());

            return Response.success("登陆成功");
        } catch (Exception ex) {
            log.debug("登陆失败 ");
        }
        return Response.error("登陆失败");

    }

    @RequestMapping("logout")
    public Response logout() {
        log.debug("注销...");
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return Response.success("退出成功 ");
        }catch (Exception ex){
            return Response.error("退出失败 ");
        }

    }


    @RequestMapping("testRoles")
    @RequiresRoles("admin")
    @ResponseBody
    public String testRoles() {
        log.debug("执行Roles");
        return "Roles";
    }

    @RequestMapping("PermissionsAdd")
    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @ResponseBody
    public String PermissionsAdd() {
        log.debug("执行PermissionsAdd");
        return "PermissionsAdd";
    }

    @RequestMapping("PermissionsHahaha")
    @RequiresRoles("admin")
    @RequiresPermissions("hahaha")
    @ResponseBody
    public String PermissionsHahaha() {
        log.debug("执行PermissionsHahaha");
        return "PermissionsHahaha";
    }

}
