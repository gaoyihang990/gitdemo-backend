package com.its.demo.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 部门视图类
 *
 * @author 杨金刚
 * @date 2020/4/24 10:06
 */
@Data
public class DeptVO extends DeptDO{

    /**
     * 上级部门
     */
    @ExcelProperty(value = "上级部门", index = 1)
    private String parentDept;


}
