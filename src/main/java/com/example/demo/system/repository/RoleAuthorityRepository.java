package com.example.demo.system.repository;

import com.example.demo.system.entity.RoleAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 角色权限关系持久层
 * @author STRR
 */
public interface RoleAuthorityRepository extends JpaRepository<RoleAuthority, Integer>, RoleAuthorityRepositoryCustom {
    /**
     * 根据角色id获取角色权限关系
     * @param rid
     * @return
     */
    List<RoleAuthority> getByRid(Integer rid);

    /**
     * 根据权限id删除关系
     * @param aid
     */
    @Transactional(rollbackOn = Exception.class)
    void deleteByAid(Integer aid);

    /**
     * 根据角色id删除关系
     * @param rid
     */
    @Transactional(rollbackOn = Exception.class)
    void deleteByRid(Integer rid);
}
