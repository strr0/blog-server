package com.example.demo.system.repository.impl;

import com.example.demo.system.repository.RoleAuthorityRepositoryCustom;
import com.example.demo.system.entity.RoleAuthority;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 自定义角色权限关系数据访问实现
 * @author STRR
 */
public class RoleAuthorityRepositoryImpl implements RoleAuthorityRepositoryCustom {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Integer> listAidsByRid(Integer rid) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();
        Root root = query.from(RoleAuthority.class);
        query.select(root.get("aid"));
        query.where(builder.equal(root.get("rid"), rid));
        Query q = manager.createQuery(query);
        return q.getResultList();
    }
}
