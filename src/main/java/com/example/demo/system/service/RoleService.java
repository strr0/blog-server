package com.example.demo.system.service;

import com.example.demo.system.entity.Role;

import java.util.List;

/**
 *
 * 角色逻辑服务
 * @author STRR
 * @time 2020/6/12 18:13
 */
public interface RoleService {
    /**
     *
     * 查询所有角色信息
     * @return
     * @author STRR
     * @time 2020/6/6 23:37
     */
    List<Role> listRoles();

    /**
     *
     * 添加角色信息
     * @param role 角色
     * @return
     * @author STRR
     * @time 2020/6/6 23:36
     */
    void saveRole(Role role);

    /**
     *
     * 编辑角色信息
     * @param role
     * @return
     * @author STRR
     * @time 2020/6/6 23:36
     */
    void updateRole(Role role);

    /**
     *
     * 删除角色信息
     * @param id
     * @return
     * @author STRR
     * @time 2020/6/6 23:37
     */
    void deleteById(Integer id);
}
