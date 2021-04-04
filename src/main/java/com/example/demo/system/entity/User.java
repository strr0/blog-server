package com.example.demo.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 用户
 * @author STRR
 * @time 2020/6/9 13:07
 */
@Data
@Entity
@Table(name = "sys_user")
public class User {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    @Column(name = "password", updatable = false)
    private String password;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 电子邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 用户头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 个人说明
     */
    @Column(name = "description")
    private String description;

    /**
     * 登录时间
     */
    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 是否可用
     */
    @Column(name = "enabled")
    private boolean enabled;
}
