package com.its.demo.service.impl;

import com.its.demo.domain.RoleDO;
import com.its.demo.dao.RoleMapper;
import com.its.demo.domain.RoleVO;
import com.its.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 杨金刚
 * @date 2020/4/22 13:34
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }


    @Override
    public void saveRole(RoleDO role) {
        roleMapper.insertRole(role);
    }

    @Override
    public void updateRole(RoleDO role) {
        roleMapper.updateRole(role);
    }

    @Override
    public RoleDO getRoleById(Long id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public List<RoleVO> listRoleVOs() {
        return roleMapper.listRoleVOs();
    }

    @Override
    public List<RoleDO> listAllRole() {
        return roleMapper.listAllRole();
    }

    @Override
    public List<RoleVO> listRoleVOsByKeyword(String keyword) {
        return roleMapper.listRoleVOsByKeyword(keyword);
    }

    @Override
    public Boolean isExistingRole(String role) {
        Integer count = roleMapper.countRoleByName(role);

        return count > 0;
    }

    @Override
    public RoleVO getRoleVOById(Long id) {
        return roleMapper.getRoleVOById(id);
    }

    @Override
    public void removeRole(Long id) {
        Integer count = roleMapper.countOccupiedRole(id);
        if(count > 0) {
            throw new RuntimeException("要删除存在用户或下级角色，不能删除");
        }
        roleMapper.deleteRole(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchRemoveRole(String ids) {
        String[] arrIds = ids.split(",");
        for(String id: arrIds) {
            removeRole(Long.valueOf(id));
        }
    }

}