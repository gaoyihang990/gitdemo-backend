package com.its.demo.service.impl;

import com.its.demo.domain.DeptDO;
import com.its.demo.dao.DeptMapper;
import com.its.demo.domain.DeptVO;
import com.its.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 杨金刚
 * @date 2020/4/22 13:34
 */
@Service
public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;

    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }


    @Override
    public void saveDept(DeptDO dept) {
         deptMapper.insertDept(dept);
    }

    @Override
    public void updateDept(DeptDO dept) {
        deptMapper.updateDept(dept);
    }

    @Override
    public DeptDO getDeptById(Long id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public List<DeptVO> listDeptVOs() {
        return deptMapper.listDeptVOs();
    }

    @Override
    public List<DeptVO> listDeptVOsByKeyword(String keyword) {
        return deptMapper.listDeptVOsByKeyword(keyword);
    }

    @Override
    public Boolean isExistingDept(String dept) {
        Integer count = deptMapper.countDeptByName(dept);

        return count > 0;
    }

    @Override
    public DeptVO getDeptVOById(Long id) {
        return deptMapper.getDeptVOById(id);
    }

    @Override
    public void removeDept(Long id) {
        Integer count = deptMapper.countOccupiedDept(id);
        if(count > 0) {
            throw new RuntimeException("要删除部门存在用户或下级部门，不能删除");
        }
        deptMapper.deleteDept(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchRemoveDept(String ids) {
        String[] arrIds = ids.split(",");
        for(String id: arrIds) {
            removeDept(Long.valueOf(id));
        }
    }

}
