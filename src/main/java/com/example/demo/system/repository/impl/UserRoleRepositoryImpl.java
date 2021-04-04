package com.example.demo.system.repository.impl;

import com.example.demo.system.repository.UserRoleRepositoryCustom;
import com.example.demo.system.entity.query.UserRoleQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 自定义用户角色关系数据访问实现
 * @author STRR
 */
public class UserRoleRepositoryImpl implements UserRoleRepositoryCustom {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Integer> listRidsByUid(Integer uid) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();
        Root root = query.from(UserRoleQuery.class);
        query.select(root.get("rid"));
        query.where(builder.equal(root.get("uid"), uid));
        Query q = manager.createQuery(query);
        return q.getResultList();
    }
}
