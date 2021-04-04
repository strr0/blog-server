package com.example.demo.system;

import com.example.demo.system.repository.UserRepository;
import com.example.demo.system.entity.Authority;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTests {
    @Autowired
    private UserRepository repository;

    @Test
    void listAuthoritiesTest() {
        List<Authority> authorityList = repository.listAuthoritiesByUid(1);
        System.out.println(authorityList.size());
    }

    @Test
    void updatePasswordTest() {
        int i = repository.updatePasswordById("123456", 8);
    }
}
