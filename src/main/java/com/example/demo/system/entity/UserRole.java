package com.example.demo.system.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户角色关系
 * @author STRR
 * @time 2020/6/9 13:07
 */
@Data
@Entity
@Table(name = "rel_user_role")
public class UserRole {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户编号
     */
    @Column(name = "uid")
    private Integer uid;

    /**
     * 角色编号
     */
    @Column(name = "rid")
    private Integer rid;

    public UserRole() { }

    public UserRole(Integer uid, Integer rid) {
        this.uid = uid;
        this.rid = rid;
    }
}
