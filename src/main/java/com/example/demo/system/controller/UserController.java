package com.example.demo.system.controller;

import com.example.demo.common.CommonResult;
import com.example.demo.system.entity.User;
import com.example.demo.system.service.UserRoleService;
import com.example.demo.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户访问控制
 * @author STRR
 */
@RestController
@RequestMapping("/system/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/listUsers")
    public CommonResult listUsers() {
        try {
            List<User> userList = userService.listUsers();
            return CommonResult.success(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @GetMapping("/listUsersByPage")
    public CommonResult listUsersByPage(Pageable pageable) {
        try {
            Page<User> userPage = userService.listUsersByPage(pageable);
            return CommonResult.success(userPage);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PostMapping("/saveUser")
    public CommonResult saveUser(User user, Integer[] checkedIds) {
        try {
            User exist = userService.getUserByUsername(user.getUsername());
            if (exist == null) {
                User result = userService.saveUser(user);
                if (result.getId() != null && checkedIds != null) {
                    userRoleService.saveUserRole(result.getId(), checkedIds);
                }
                return CommonResult.success();
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PutMapping("/updateUser")
    public CommonResult updateUser(User user, Integer[] checkedIds) {
        try {
            User exist = userService.getUserByUsername(user.getUsername());
            if (exist == null) {
                userService.updateUser(user);
                if (user.getId() != null) {
                    userRoleService.updateUserRole(user.getId(), checkedIds);
                }
                return CommonResult.success();
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @DeleteMapping("/deleteUser")
    public CommonResult deleteUser(Integer id) {
        try {
            if (id != null) {
                userService.deleteById(id);
                userRoleService.deleteByUid(id);
                return CommonResult.success();
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }
}
