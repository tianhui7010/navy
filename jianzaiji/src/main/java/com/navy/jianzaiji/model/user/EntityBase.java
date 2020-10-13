package com.navy.jianzaiji.model.user;

import java.io.Serializable;

/**
 * entity基类
 * @MappedSuperclass ： EntityBase不会将字段映射到数据表中，而继承该EntityBase的子类
 *                       会将EntityBase中的字段映射到子类的数据表中
 */

//@MappedSuperclass
public class EntityBase implements Serializable {

//    @Id
//    @GeneratedValue
    protected Long id;

    private static final long serialVersionUID = 1L;

}
