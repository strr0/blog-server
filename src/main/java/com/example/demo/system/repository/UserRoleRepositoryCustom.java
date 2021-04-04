package com.example.demo.system.repository;

import java.util.List;

/**
 * 自定义用户角色关系数据访问
 * @author STRR
 */
public interface UserRoleRepositoryCustom {
    /**
     * 根据用户id返回角色id
     * @param uid 用户id
     * @return
     */
    List<Integer> listRidsByUid(Integer uid);
}
