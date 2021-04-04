package com.example.demo.system.service;

import com.example.demo.system.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 用户逻辑服务
 * @author STRR
 */
public interface UserService {
    /**
     *
     * 添加用户信息
     * @param user
     * @return
     * @author STRR
     * @time 2020/6/5 10:03
     */
    User saveUser(User user);

    /**
     *
     * 修改用户信息
     * @param user
     * @return
     * @author STRR
     * @time 2020/6/5 10:04
     */
    void updateUser(User user);

    /**
     *
     * 删除用户信息
     * @param id
     * @return
     * @author STRR
     * @time 2020/6/6 15:46
     */
    void deleteById(Integer id);

    /**
     *
     * 查询所有用户信息
     * @return
     * @author STRR
     * @time 2020/6/6 23:33
     */
    List<User> listUsers();

    /**
     *
     * 分页获取用户信息
     * @param pageable
     * @return
     * @author STRR
     * @time 2020/6/7 21:40
     *
     */
    Page<User> listUsersByPage(Pageable pageable);

    /**
     *
     * 根据用户名获取用户
     * @param username
     * @return:
     * @author: STRR
     * @time: 2020/6/7 21:51
     *
     */
    User getUserByUsername(String username);

    /**
     * 获取Security用户信息
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);
}
