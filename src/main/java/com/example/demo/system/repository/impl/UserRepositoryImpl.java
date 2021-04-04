package com.example.demo.system.repository.impl;

import com.example.demo.system.entity.User;
import com.example.demo.system.repository.UserRepositoryCustom;
import com.example.demo.system.entity.Authority;
import com.example.demo.system.entity.query.UserRoleQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * 自定义用户数据访问实现
 * @author STRR
 */
public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Authority> listAuthoritiesByUid(Integer uid) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery();
        Root root = query.from(UserRoleQuery.class);
        query.select(root.get("authorityList"));
        query.where(builder.equal(root.get("uid"), uid));
        query.distinct(true);
        Query q = manager.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updateEnabledById(boolean enabled, Integer id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaUpdate update = builder.createCriteriaUpdate(User.class);
        Root root = update.from(User.class);
        update.set(root.get("enabled"), enabled);
        update.where(builder.equal(root.get("id"), id));
        Query q = manager.createQuery(update);
        return q.executeUpdate();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updatePasswordById(String password, Integer id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaUpdate update = builder.createCriteriaUpdate(User.class);
        Root root = update.from(User.class);
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        update.set(root.get("password"), encodedPassword);
        update.where(builder.equal(root.get("id"), id));
        Query q = manager.createQuery(update);
        return q.executeUpdate();
    }
}
