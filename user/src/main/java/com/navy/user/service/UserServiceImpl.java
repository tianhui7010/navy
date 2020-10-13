package com.navy.user.service;

import com.navy.jianzaiji.annotation.Facade;
import com.navy.jianzaiji.model.user.User;
import com.navy.jianzaiji.service.sailor.UserService;
import com.navy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 52613 on 2019/11/26.
 */
@Facade
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByUserName(String username) {
        User user = userRepository.getByUserName(username);
        System.out.println("user user is "+user);
        return user;
    }

    @Override
    public List<String> getRolesByUserId(@RequestParam("id") Long id) {
        List<String> rolesByUserId = userRepository.getRolesByUserId(id);
        System.out.println("sailor rolesByUserId is "+rolesByUserId);
        return rolesByUserId;
    }

    @Override
    public List<String> getPermissionsByUserId(@RequestParam("id") Long id) {
        List<String> permissions = userRepository.getPermissionsByUserId(id);
        System.out.println("user getPermissionsByUserId is "+permissions);
        return permissions;
    }
}
