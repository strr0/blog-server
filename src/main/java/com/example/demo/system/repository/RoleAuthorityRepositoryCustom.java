package com.example.demo.system.repository;

import java.util.List;

/**
 * 自定义角色权限关系数据访问
 * @author STRR
 */
public interface RoleAuthorityRepositoryCustom {
    /**
     * 根据角色id返回权限id
     * @param rid
     * @return
     */
    List<Integer> listAidsByRid(Integer rid);
}
