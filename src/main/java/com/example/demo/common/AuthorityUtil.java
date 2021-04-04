package com.example.demo.common;

import com.example.demo.system.entity.Authority;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单工具
 * @author STRR
 */
public class AuthorityUtil {
    /**
     * 获取权限树
     * @param authorityList
     * @return
     */
    public static Authority getAuthorityTree(List<Authority> authorityList, Integer rootId) {
        Authority authorityTree = getRootNode(authorityList, rootId);
        if (authorityTree != null) {
            authorityTree.setChildren(buildAuthorityTree(authorityList, authorityTree.getId()));
        }
        return authorityTree;
    }

    /**
     * 获取权限树节点
     * @param authorityList
     * @param rootId
     * @return
     */
    public static List<Authority> listAuthorityNodes(List<Authority> authorityList, Integer rootId) {
        return buildAuthorityTree(authorityList, rootId);
    }

    /**
     * 获取菜单树
     * @param authorityList
     * @return
     */
    public static Authority getMenuTree(List<Authority> authorityList, Integer rootId) {
        Authority menuTree = getRootNode(authorityList, rootId);
        if (menuTree != null) {
            menuTree.setChildren(buildMenuTree(authorityList, menuTree.getId()));
        }
        return menuTree;
    }

    /**
     * 获取菜单树节点
     * @param authorities
     * @param rootId
     * @return
     */
    public static List<Authority> listMenuNodes(List<Authority> authorities, Integer rootId) {
        return buildMenuTree(authorities, rootId);
    }

    /**
     * 根据父id建立权限树
     * @param authorityList
     * @param parentId
     * @return
     */
    private static List<Authority> buildAuthorityTree(List<Authority> authorityList, Integer parentId) {
        if (authorityList.size() == 0) {
            return null;
        }
        List<Authority> childrenAuthorities = new ArrayList<>();
        //遍历菜单集合, 寻找子菜单
        for (Authority authority : authorityList) {
            if (authority.getParentId().equals(parentId)) {
                //寻找子菜单的子菜单
                authority.setChildren(buildAuthorityTree(authorityList, authority.getId()));
                childrenAuthorities.add(authority);
            }
        }
        return childrenAuthorities;
    }

    /**
     * 根据父id建立菜单树
     * @param authorityList
     * @param parentId
     * @return
     */
    private static List<Authority> buildMenuTree(List<Authority> authorityList, Integer parentId) {
        if (authorityList.size() == 0) {
            return null;
        }
        List<Authority> childrenMenus = new ArrayList<>();
        //遍历菜单集合, 寻找子菜单
        for (Authority authority : authorityList) {
            //如果不是菜单, 继续遍历
            if (!authority.getIsMenu()) {
                continue;
            }
            if (authority.getParentId().equals(parentId)) {
                //寻找子菜单的子菜单
                authority.setChildren(buildMenuTree(authorityList, authority.getId()));
                childrenMenus.add(authority);
            }
        }
        return childrenMenus;
    }

    /**
     * 获取根节点
     * @param authorityList
     * @return
     */
    private static Authority getRootNode(List<Authority> authorityList, Integer rootId) {
        if (authorityList.size() == 0) {
            return null;
        }
        //遍历权限集合, 寻找根节点
        for (Authority authority : authorityList) {
            if (authority.getId().equals(rootId)) {
                return authority;
            }
        }
        return null;
    }
}
