package com.example.demo.system.service.impl;

import com.example.demo.config.security.CustomUserDetails;
import com.example.demo.system.repository.UserRepository;
import com.example.demo.system.entity.Authority;
import com.example.demo.system.entity.User;
import com.example.demo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户逻辑服务实现
 * @author STRR
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user) {
        //用户密码加密处理
        String rawPassword = "123456";
        if (user.getPassword() != null) {
            rawPassword = user.getPassword();
        }
        String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        user.setPassword(encodedPassword);
        return repository.save(user);
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> listUsers() {
        return repository.findAll();
    }

    @Override
    public Page<User> listUsersByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.getUserByUsername(username);
        if (user != null) {
            List<Authority> authorityList = repository.listAuthoritiesByUid(user.getId());
            return new CustomUserDetails(user, authorityList);
        }
        throw new UsernameNotFoundException("用户不存在!");
    }
}
