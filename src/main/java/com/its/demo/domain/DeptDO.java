package com.its.demo.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


/**
 * 部门实体类
 *
 * @author 杨金刚
 * @date 2020/4/20 14:00
 */
@Data
public class DeptDO implements Serializable {
    /**
     * 主键
     */
    @ExcelIgnore
    private Long id;
    /**
     * 部门
     */
    @ExcelProperty("部门")
    private String dept;
    /**
     * 上级部门ID
     */
    @ExcelIgnore
    private Long parentDeptId;
    /**
     * 记录创建时间
     */
    @ExcelProperty("创建时间")
    private Date gmtCreate;
    /**
     * 记录修改时间
     */
    @ExcelProperty("修改时间")
    private Date gmtModified;
}
