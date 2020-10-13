package com.navy.jianzaiji.model.user;

import java.util.List;


/**
 * Created by 52613 on 2019/11/26.
 */
//@Entity
//@Table(name="sys_menu")
public class Menu extends EntityBase{

    /**菜单名**/
    private String menuName;

    //多对多 一个菜单对应多个角色
//    @ManyToMany(fetch= FetchType.EAGER)
//    @JoinTable(name="SysRoleMenu",joinColumns={@JoinColumn(name="menuId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<Role> roleList;

    public Menu() {
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
