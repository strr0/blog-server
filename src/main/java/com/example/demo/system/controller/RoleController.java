package com.example.demo.system.controller;

import com.example.demo.common.CommonResult;
import com.example.demo.system.entity.Role;
import com.example.demo.system.service.RoleAuthorityService;
import com.example.demo.system.service.RoleService;
import com.example.demo.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色访问控制
 * @author STRR
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleAuthorityService roleAuthorityService;

    @GetMapping("/listRoles")
    public CommonResult listRoles() {
        try {
            List<Role> roleList = roleService.listRoles();
            return CommonResult.success(roleList);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PostMapping("/saveRole")
    public CommonResult saveRole(Role role) {
        try {
            roleService.saveRole(role);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PutMapping("/updateRole")
    public CommonResult updateRole(Role role) {
        try {
            roleService.updateRole(role);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @DeleteMapping("/deleteRole")
    public CommonResult deleteRole(Integer id) {
        try {
            if (id != null) {
                roleService.deleteById(id);
                userRoleService.deleteByRid(id);
                roleAuthorityService.deleteByRid(id);
                return CommonResult.success();
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @GetMapping("/listRidsByUid")
    public CommonResult listRidsByUid(Integer uid) {
        try {
            if (uid != null) {
                List<Integer> rids = userRoleService.listRidsByUid(uid);
                return CommonResult.success(rids);
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PostMapping("/saveRoleAuthority")
    public CommonResult saveRoleAuthority(Integer rid, Integer[] checkedIds) {
        try {
            if (rid != null && checkedIds != null) {
                roleAuthorityService.saveRoleAuthority(rid, checkedIds);
                return CommonResult.success();
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PutMapping("/updateRoleAuthority")
    public CommonResult updateRoleAuthority(Integer rid, Integer[] checkedIds) {
        try {
            if (rid != null) {
                roleAuthorityService.updateRoleAuthority(rid, checkedIds);
                return CommonResult.success();
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }
}
