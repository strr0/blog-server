package com.example.demo.system.service.impl;

import com.example.demo.system.repository.UserRoleRepository;
import com.example.demo.system.entity.UserRole;
import com.example.demo.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 用户角色关系逻辑服务实现
 * @author STRR
 * @time 2020/6/9 15:59
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository repository;

    @Override
    public List<Integer> listRidsByUid(Integer uid) {
        return repository.listRidsByUid(uid);
    }

    @Override
    public void saveUserRole(Integer uid, Integer[] rids) {
        for(Integer rid : rids) {
            repository.save(new UserRole(uid, rid));
        }
    }

    @Override
    public void updateUserRole(Integer uid, Integer[] rids) {
        //勾选角色为空, 删除所有关系
        if (rids == null) {
            repository.deleteByUid(uid);
            return;
        }
        //原有角色
        List<UserRole> userRoleList = repository.getByUid(uid);
        //勾选角色
        List<Integer> target = new LinkedList<>();
        Collections.addAll(target, rids);
        //跳过已存在的关系, 删除未勾选的关系
        for (UserRole userRole : userRoleList) {
            if (target.contains(userRole.getRid())) {
                target.remove(userRole.getRid());
            } else {
                repository.delete(userRole);
            }
        }
        //添加新关系
        for (Integer rid : target) {
            repository.save(new UserRole(uid, rid));
        }
    }

    @Override
    public void deleteByUid(Integer uid) {
        repository.deleteByUid(uid);
    }

    @Override
    public void deleteByRid(Integer rid) {
        repository.deleteByRid(rid);
    }
}
