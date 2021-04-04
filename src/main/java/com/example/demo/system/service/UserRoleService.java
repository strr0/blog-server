package com.example.demo.system.service;

import java.util.List;

/**
 * 用户角色关系逻辑服务
 * @author STRR
 */
public interface UserRoleService {
    /**
     * 根据用户id获取角色id
     * @param uid
     * @return
     */
    List<Integer> listRidsByUid(Integer uid);

    /**
     * 添加关系
     * @param uid
     * @param rids
     */
    void saveUserRole(Integer uid, Integer[] rids);

    /**
     * 修改关系
     * @param uid
     * @param rids
     */
    void updateUserRole(Integer uid, Integer[] rids);

    /**
     * 根据用户id删除关系
     * @param uid
     */
    void deleteByUid(Integer uid);

    /**
     * 根据角色id删除关系
     * @param rid
     */
    void deleteByRid(Integer rid);
}
