package com.example.demo.system.repository;

import com.example.demo.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户数据访问
 * @author STRR
 */
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return
     */
    User getUserByUsername(String username);
}
