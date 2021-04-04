package com.example.demo.system.service.impl;

import com.example.demo.system.repository.RoleAuthorityRepository;
import com.example.demo.system.entity.RoleAuthority;
import com.example.demo.system.service.RoleAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 角色权限关系逻辑服务实现
 * @author STRR
 * @time 2020/6/9 15:58
 */
@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {
    @Autowired
    private RoleAuthorityRepository repository;

    @Override
    public List<Integer> listAidsByRid(Integer rid) {
        return repository.listAidsByRid(rid);
    }

    @Override
    public void saveRoleAuthority(Integer rid, Integer[] aids) {
        for (Integer aid : aids) {
            repository.save(new RoleAuthority(rid, aid));
        }
    }

    @Override
    public void updateRoleAuthority(Integer rid, Integer[] aids) {
        if (aids == null) {
            repository.deleteByRid(rid);
            return;
        }
        //原有权限
        List<RoleAuthority> roleAuthorityList = repository.getByRid(rid);
        //勾选权限
        List<Integer> target = new LinkedList<>();
        Collections.addAll(target, aids);
        //跳过已存在的关系, 删除未勾选的关系
        for (RoleAuthority roleAuthority : roleAuthorityList) {
            if (target.contains(roleAuthority.getAid())) {
                target.remove(roleAuthority.getAid());
            } else {
                repository.delete(roleAuthority);
            }
        }
        //添加新关系
        for (Integer aid : target) {
            repository.save(new RoleAuthority(rid, aid));
        }
    }

    @Override
    public void deleteByRid(Integer rid) {
        repository.deleteByRid(rid);
    }

    @Override
    public void deleteByAid(Integer aid) {
        repository.deleteByAid(aid);
    }
}
