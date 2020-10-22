package com.its.demo.service;

import com.its.demo.domain.DeptDO;
import com.its.demo.domain.DeptVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨金刚
 * @date 2020/4/22 13:32
 */
@Service
public interface DeptService {
    /**
     * 新增部门
     *
     * @param dept 部门对象
     */
    void saveDept(DeptDO dept);

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
    void removeDept(Long id);

    /**
     * 批量删除部门
     *
     * @param ids 部门ID数组
     */
    void batchRemoveDept(String ids);

    /**
     * 通过ID获取部门信息
     *
     * @param id 部门ID
     * @return 部门对象
     */
    DeptDO getDeptById(Long id);

    /**
     * 通过ID获取部门详细信息
     *
     * @param id 部门ID
     * @return 部门对象
     */
    DeptVO getDeptVOById(Long id);

    /**
     * 获取部门详细信息列表
     *
     * @return 部门视图列表
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
     * 验证部门是否存在
     *
     * @param dept 部门
     * @return true--存在；false--不存在
     */
    Boolean isExistingDept(String dept);

}
