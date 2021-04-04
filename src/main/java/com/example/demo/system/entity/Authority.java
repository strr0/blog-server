package com.example.demo.system.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 权限实体
 * @author STRR
 * @time 2020/6/9 13:06
 */
@Data
@Entity
@Table(name = "sys_authority")
public class Authority {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 请求路径
     */
    @Column(name = "url")
    private String url;

    /**
     * 路由地址
     */
    @Column(name = "path")
    private String path;

    /**
     * 权限名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 组件
     */
    @Column(name = "component")
    private String component;

    /**
     * 图标
     */
    @Column(name = "icon_cls")
    private String iconCls;

    /**
     * 父菜单
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 是否菜单
     */
    @Column(name = "is_menu")
    private Boolean isMenu;

    /**
     * 是否可用
     */
    @Column(name = "enabled")
    private Boolean enabled;

    /**
     * 子菜单
     */
    @Transient
    private List<Authority> children;
}
