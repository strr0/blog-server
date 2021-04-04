package com.example.demo.system.repository;

import com.example.demo.system.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 用户角色关系持久层
 * @author STRR
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>, UserRoleRepositoryCustom {
    /**
     * 根据用户id获取用户角色关系
     * @param uid
     * @return
     */
    List<UserRole> getByUid(Integer uid);

    /**
     * 根据用户id删除关系
     * @param uid
     */
    @Transactional(rollbackOn = Exception.class)
    void deleteByUid(Integer uid);

    /**
     * 根据角色id删除关系
     * @param rid
     */
    @Transactional(rollbackOn = Exception.class)
    void deleteByRid(Integer rid);
}
