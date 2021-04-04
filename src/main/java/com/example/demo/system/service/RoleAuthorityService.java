package com.example.demo.system.service;

import java.util.List;

/**
 * 角色权限关系逻辑服务
 * @author STRR
 */
public interface RoleAuthorityService {
    /**
     * 根据角色id获取权限id
     * @param rid
     * @return
     */
    List<Integer> listAidsByRid(Integer rid);

    /**
     * 保存角色权限关系
     * @param rid
     * @param aids
     */
    void saveRoleAuthority(Integer rid, Integer[] aids);

    /**
     * 更新角色权限关系
     * @param rid
     * @param aids
     */
    void updateRoleAuthority(Integer rid, Integer[] aids);

    /**
     * 根据角色id删除关系
     * @param rid
     */
    void deleteByRid(Integer rid);

    /**
     * 根据权限id删除关系
     * @param aid
     */
    void deleteByAid(Integer aid);
}
