package com.navy.jianzaiji.service.sailor;

import com.navy.jianzaiji.annotation.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 52613 on 2019/11/26.
 */
@User
public interface UserService {

    @RequestMapping(value = "/getByUserName")
    com.navy.jianzaiji.model.user.User getByUserName(@RequestParam("username") String username);

    @RequestMapping(value = "/getRolesByUserId")
    List<String> getRolesByUserId(@RequestParam("id") Long id);

    @RequestMapping(value = "/getPermissionsByUserId")
    List<String> getPermissionsByUserId(@RequestParam("id") Long id);
}
