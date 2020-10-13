package com.navy.jianzaiji.model.user;

import java.util.List;

/**
 * Created by 52613 on 2019/11/26.
 */
//@Entity
//@Table(name = "sys_user")
public class User extends EntityBase{

//    @NotEmpty(message = "用户名不能为空")
    private String userName;
//    @NotEmpty(message = "密码不能为空")
    private String passWord;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn( name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setIde(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Role> getRoleList() {
        return this.roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id ='").append(id).append('\'');
        sb.append("userName='").append(userName).append('\'');
        sb.append(", passWord='").append(passWord).append('\'');
        sb.append(", roleList=").append(roleList);
        sb.append('}');
        return sb.toString();
    }
}
