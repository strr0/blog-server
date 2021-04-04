package com.example.demo.system.controller;

import com.example.demo.common.CommonResult;
import com.example.demo.common.AuthorityUtil;
import com.example.demo.config.security.CustomUserDetails;
import com.example.demo.system.entity.Authority;
import com.example.demo.system.service.AuthorityService;
import com.example.demo.system.service.RoleAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 权限访问控制
 * @author STRR
 */
@RestController
@RequestMapping("/system/authority")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private RoleAuthorityService roleAuthorityService;

    @Value("${custom.menu.root.id}")
    private Integer rootId;

    @GetMapping("/listMenus")
    public CommonResult listMenus(@AuthenticationPrincipal CustomUserDetails userDetails) {
        try {
            if (userDetails == null) {
                return CommonResult.fail();
            }
            List<Authority> authorityList = userDetails.getAuthorityList();
            List<Authority> menuNodeList = AuthorityUtil.listMenuNodes(new LinkedList<>(authorityList), rootId);
            return CommonResult.success(menuNodeList);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @GetMapping("/listAuthorities")
    public CommonResult listAuthorities() {
        try {
            List<Authority> authorityList = authorityService.listAuthorities();
            List<Authority> authorityNodeList = AuthorityUtil.listAuthorityNodes(authorityList, rootId);
            return CommonResult.success(authorityNodeList);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PostMapping("/saveAuthority")
    public CommonResult saveAuthority(Authority authority) {
        try {
            authorityService.saveAuthority(authority);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @PutMapping("/updateAuthority")
    public CommonResult updateAuthority(Authority authority) {
        try {
            authorityService.updateAuthority(authority);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @DeleteMapping("/deleteAuthority")
    public CommonResult deleteAuthority(Integer id) {
        try {
            if(id != null) {
                authorityService.deleteById(id);
                roleAuthorityService.deleteByAid(id);
                return CommonResult.success();
            }
            return CommonResult.fail();
        } catch (Exception e){
            e.printStackTrace();
            return CommonResult.fail();
        }
    }

    @GetMapping("/listAidsByRid")
    public CommonResult listAidsByRid(Integer rid) {
        try {
            if (rid != null) {
                List<Integer> aids = roleAuthorityService.listAidsByRid(rid);
                return CommonResult.success(aids);
            }
            return CommonResult.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail();
        }
    }
}
