package com.example.demo.system.service;

import com.example.demo.system.entity.Authority;

import java.util.List;

/**
 * 权限逻辑服务
 * @author STRR
 */
public interface AuthorityService {
    /**
     * 获取所有权限
     * @return
     */
    List<Authority> listAuthorities();

    /**
     *
     * 添加权限信息
     * @param authority
     * @return
     */
    void saveAuthority(Authority authority);

    /**
     *
     * 编辑权限信息
     * @param authority
     * @return
     */
    void updateAuthority(Authority authority);

    /**
     *
     * 删除权限信息
     * @param id
     * @return
     */
    void deleteById(Integer id);
}
