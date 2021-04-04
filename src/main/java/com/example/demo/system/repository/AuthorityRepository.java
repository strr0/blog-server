package com.example.demo.system.repository;

import com.example.demo.system.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 权限数据访问
 * @author STRR
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
