package com.its.demo.dao;

import com.its.demo.domain.RoleDO;
import com.its.demo.domain.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色Mapper
 *
 * @author 杨金刚
 * @date 2020/8/9 13:36
 */
@Mapper
@Component(value = "roleMapper")
public interface RoleMapper {
    /**
     * 新增角色
     *
     * @param role 角色对象
     */
    void insertRole(RoleDO role);

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
    void deleteRole(Long id);

    /**
     * 通过角色ID获取角色
     *
     * @param id 角色ID
     * @return 角色对象
     */
    RoleDO getRoleById(Long id);

    /**
     * 通过角色ID获取角色视图信息
     *
     * @param id 角色ID
     * @return 单个角色信息
     */
    RoleVO getRoleVOById(Long id);

    /**
     * 确认该角色是否有下级角色或有用户使用此角色
     *
     * @param id 角色ID
     * @return 返回值大于零，则有下级或用户
     */
    Integer countOccupiedRole(Long id);

    /**
     * 获取角色视图列表
     *
     * @return 角色信息列表
     */
    List<RoleVO> listRoleVOs();
    List<RoleDO> listAllRole();
    /**
     * 通过关键字模糊检索角色信息
     *
     * @param keyword 关键字
     * @return
     */
    List<RoleVO> listRoleVOsByKeyword(String keyword);

    /**
     * 验证是否存在给定的角色
     *
     * @param role 角色
     * @return >0--给定的角色存在；=0--给定的角色不存在
     */
    Integer countRoleByName(String role);

    /**
     * 验证是否存在给定的角色(考虑ID）
     *
     * @param role 角色
     * @return >0--给定的角色存在；=0--给定的角色不存在
     */
    Integer countRoleByNameWithId(@Param("role") String role,
                                  @Param("id") Long id);


}
