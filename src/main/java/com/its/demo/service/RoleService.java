package com.its.demo.service;

import com.its.demo.domain.RoleDO;
import com.its.demo.domain.RoleVO;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 杨金刚
 * @date 2020/4/22 13:32
 */
@Service
public interface RoleService {
    /**
     * 新增角色
     *
     * @param role 角色对象
     */
    void saveRole(RoleDO role);

    /**
     * 更新角色
     *
     * @param role 角色对象
     */
    void updateRole(RoleDO role);

    /**
     * 通过ID删除角色
     *
     * @param id 角色ID
     */
    void removeRole(Long id);

    /**
     * 批量删除角色
     *
     * @param ids 角色ID数组
     */
    void batchRemoveRole(String ids);

    /**
     * 通过ID获取角色信息
     *
     * @param id 角色ID
     * @return 角色对象
     */
    RoleDO getRoleById(Long id);

    /**
     * 通过ID获取角色详细信息
     *
     * @param id 角色ID
     * @return 角色对象
     */
    RoleVO getRoleVOById(Long id);

    /**
     * 获取角色详细信息列表
     *
     * @return 角色视图列表
     */
    List<RoleVO> listRoleVOs();

    /**
     * 通过关键字模糊检索角色信息
     *
     * @param keyword 关键字
     * @return
     */
    List<RoleVO> listRoleVOsByKeyword(String keyword);

    /**
     * 验证角色是否存在
     *
     * @param role 角色
     * @return true--存在；false--不存在
     */
    Boolean isExistingRole(String role);

    List<RoleDO> listAllRole();
}
