package com.example.demo.system.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色权限关系
 * @author STRR
 * @time 2020/6/9 13:07
 */
@Data
@Entity
@Table(name = "rel_role_authority")
public class RoleAuthority {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色编号
     */
    @Column(name = "rid")
    private Integer rid;

    /**
     * 权限编号
     */
    @Column(name = "aid")
    private Integer aid;

    public RoleAuthority() { }

    public RoleAuthority(Integer rid, Integer aid) {
        this.rid = rid;
        this.aid = aid;
    }
}
