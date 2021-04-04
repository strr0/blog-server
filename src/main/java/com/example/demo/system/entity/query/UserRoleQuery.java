package com.example.demo.system.entity.query;

import com.example.demo.system.entity.Authority;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 用户关系查询表
 * @author STRR
 */
@Data
@Entity
@Table(name = "rel_user_role")
public class UserRoleQuery {
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

    /**
     * 角色权限关系 (用于查询用户对应权限)
     */
    @ManyToMany(targetEntity = Authority.class, fetch = FetchType.LAZY)
    @JoinTable(name = "rel_role_authority",
        joinColumns = {@JoinColumn(name = "rid", referencedColumnName = "rid", insertable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name = "aid", referencedColumnName = "id", insertable = false, updatable = false)})
    private List<Authority> authorityList;
}
