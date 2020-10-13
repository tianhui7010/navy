package com.navy.jianzaiji.model.user;

import java.util.List;
import java.util.Set;

/**
 * Created by 52613 on 2019/11/26.
 */
//@Entity
//@Table(name = "sys_role")
public class Role extends EntityBase{

    /**角色名**/
    private String roleName;

    //多对多关系 一个角色对应多个菜单
//    @ManyToMany(fetch= FetchType.EAGER)
//    @JoinTable(name="SysRoleMenu",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="menuId")})
    private List<Menu> menuList;

    //多对多关系 一个角色对用多个用户
//    @ManyToMany(fetch= FetchType.EAGER)
//    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
    private Set<User> userList;

    public Role() {
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

}
