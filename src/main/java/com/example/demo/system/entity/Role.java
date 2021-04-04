package com.example.demo.system.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色
 * @author STRR
 * @time 2020/6/9 13:06
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名
     */
    @Column(name = "name")
    private String name;

    /**
     * 角色说明
     */
    @Column(name = "description")
    private String description;

    /**
     * 是否可用
     */
    @Column(name = "enabled")
    private boolean enabled;
}
