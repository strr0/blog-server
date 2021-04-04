package com.example.demo.system.repository;

import com.example.demo.system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色持久层
 * @author STRR
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
