package com.example.demo.config.security;

import com.example.demo.system.entity.Authority;
import com.example.demo.system.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户信息
 * @author STRR
 */
public class CustomUserDetails implements UserDetails {
    /**
     * 登录用户
     */
    private User user;

    /**
     * 权限集合
     */
    private List<Authority> authorityList;

    public CustomUserDetails() {}

    public CustomUserDetails(User user, List<Authority> authorityList) {
        this.user = user;
        this.authorityList = authorityList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * 获取用户权限集
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
    }

    /**
     * 账户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 凭证是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
