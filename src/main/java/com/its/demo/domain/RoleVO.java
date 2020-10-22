package com.its.demo.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
public class RoleVO extends RoleDO{

    /**
     * 上级角色
     */
    @ExcelProperty(value = "上级角色", index = 1)
    private String parentRole;


}
