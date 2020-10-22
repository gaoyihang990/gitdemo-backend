package com.its.demo.dao;

import com.its.demo.domain.DeptDO;
import com.its.demo.domain.DeptVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 部门Mapper
 *
 * @author 杨金刚
 * @date 2020/8/10 13:36
 */
@Mapper
@Component(value = "deptMapper")
public interface DeptMapper {
    /**
     * 新增部门
     *
     * @param dept 部门对象
     */
    void insertDept(DeptDO dept);

    /**
     * 更新部门
     *
     * @param dept 部门对象
     */
    void updateDept(DeptDO dept);

    /**
     * 通过ID删除部门
     *
     * @param id 部门ID
     */
    void deleteDept(Long id);

    /**
     * 通过部门ID获取部门
     *
     * @param id 部门ID
     * @return 部门对象
     */
    DeptDO getDeptById(Long id);

    /**
     * 通过部门ID获取部门视图信息
     *
     * @param id 部门ID
     * @return 单个部门信息
     */
    DeptVO getDeptVOById(Long id);

    /**
     * 确认该部门是否有下级部门或有用户使用此部门
     *
     * @param id 部门ID
     * @return 返回值大于零，则有下级或用户
     */
    Integer countOccupiedDept(Long id);

    /**
     * 获取部门视图列表
     *
     * @return 部门信息列表
     */
    List<DeptVO> listDeptVOs();

    /**
     * 通过关键字模糊检索部门信息
     *
     * @param keyword 关键字
     * @return
     */
    List<DeptVO> listDeptVOsByKeyword(String keyword);

    /**
     * 验证是否存在给定的部门
     *
     * @param dept 部门
     * @return >0--给定的部门存在；=0--给定的部门不存在
     */
    Integer countDeptByName(String dept);

    /**
     * 验证是否存在给定的部门(考虑ID）
     *
     * @param dept 部门
     * @return >0--给定的部门存在；=0--给定的部门不存在
     */
    Integer countDeptByNameWithId(@Param("dept") String dept,
                                  @Param("id") Long id);


}
