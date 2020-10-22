package com.its.demo.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体类
 *
 * @author 杨金刚
 * @date 2020/4/20 14:06
 */
@Data
public class RoleDO implements Serializable {
    /**
     * 主键
     */
    @ExcelIgnore
    private Long id;
    /**
     * 角色
     */
    @ExcelProperty("角色")
    private String role;
    /**
     * 上级角色ID
     */
    @ExcelIgnore
    private Long parentRoleId;
    /**
     * 角色汉字描述
     */
    private String description;
    /**
     * 记录创建时间
     */
    private Date gmtCreate;
    /**
     * 记录修改时间
     */
    private Date gmtModified;
}
