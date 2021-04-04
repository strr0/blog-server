package com.example.demo.system.repository;

import com.example.demo.system.entity.Authority;

import java.util.List;

/**
 * 自定义用户数据访问
 * @author STRR
 */
public interface UserRepositoryCustom {
    /**
     * 根据用户id获取权限
     * @param uid 用户id
     * @return
     */
    List<Authority> listAuthoritiesByUid(Integer uid);

    /**
     * 修改状态
     * @param enabled
     * @param id
     * @return
     */
    int updateEnabledById(boolean enabled, Integer id);

    /**
     * 修改密码
     * @param password
     * @param id
     * @return
     */
    int updatePasswordById(String password, Integer id);
}
