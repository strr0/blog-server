package com.example.demo.system.service.impl;

import com.example.demo.system.repository.RoleRepository;
import com.example.demo.system.entity.Role;
import com.example.demo.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色逻辑服务实现
 * @author STRR
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> listRoles() {
        return repository.findAll();
    }

    @Override
    public void saveRole(Role role) {
        repository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        repository.save(role);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
