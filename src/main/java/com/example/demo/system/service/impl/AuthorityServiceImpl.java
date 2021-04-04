package com.example.demo.system.service.impl;

import com.example.demo.system.repository.AuthorityRepository;
import com.example.demo.system.entity.Authority;
import com.example.demo.system.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限逻辑服务实现
 * @author STRR
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository repository;

    @Override
    public List<Authority> listAuthorities() {
        return repository.findAll();
    }

    @Override
    public void saveAuthority(Authority authority) {
        repository.save(authority);
    }

    @Override
    public void updateAuthority(Authority authority) {
        repository.save(authority);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
