package com.navy.user.repository;

import com.navy.jianzaiji.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 52613 on 2019/11/26.
 */
@Repository
public interface UserRepository {

    User getByUserName(String username);

    List<String> getRolesByUserId(Long id);

    List<String> getPermissionsByUserId(Long id);

}
