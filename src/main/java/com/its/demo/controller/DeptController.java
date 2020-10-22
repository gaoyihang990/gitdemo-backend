package com.its.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.its.demo.domain.DeptDO;
import com.its.demo.domain.DeptVO;
import com.its.demo.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author 杨金刚
 * @date 2020/8/10 8:11
 */
@RestController
@RequestMapping(value = "api/v1")
@Api(tags = {"部门管理操作接口"})
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping(value = "/depts")
    @ApiOperation(value = "获取部门列表", notes = "获取部门列表")
    @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    public List<DeptVO> listDeptVOs(@RequestHeader String authorization){
        return deptService.listDeptVOs();
    }

    @GetMapping(value = "/depts/{keyword}")
    @ApiOperation(value = "模糊检索部门", notes = "按关键字模糊检索部门信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "关键字", dataType = "String", required = true, paramType = "path"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public List<DeptVO> listDeptVOsByKeyword(@PathVariable String keyword, @RequestHeader String authorization){
        return deptService.listDeptVOsByKeyword(keyword);
    }

    @DeleteMapping(value = "/depts/{id}")
    @ApiOperation(value = "删除部门", notes = "通过ID删除部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门ID", dataType = "Long", required = true, paramType = "path"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public void removeDept(@PathVariable Long id) {
        deptService.removeDept(id);
    }

    @DeleteMapping(value = "/depts/batch/{ids}")
    @ApiOperation(value = "批量删除部门", notes = "批量删除部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "部门ID串（逗号分隔）", dataType = "String",  required = true, paramType = "path"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public void batchRemoveDept(@PathVariable String ids) {
        deptService.batchRemoveDept(ids);
    }

    @PostMapping(value = "/depts/exp-excel")
    @ApiOperation(value = "导出部门为Excel", notes = "导出部门为Excel")
    public void expToExcel(HttpServletResponse response) throws IOException {
        List<DeptVO> listDeptVO = deptService.listDeptVOs();

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
//        String fileName = URLEncoder.encode("部门", "UTF-8");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DeptVO.class).sheet("部门").doWrite(listDeptVO);
    }

    @GetMapping(value = "/depts/validator/dept")
    @ApiOperation(value = "检查部门是否存在", notes = "检查给定的部门是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dept", value = "部门", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public Boolean checkDept(String dept) {
        return deptService.isExistingDept(dept);
    }

    @PostMapping(value = "/depts")
    @ApiOperation(value = "新增部门", notes = "新增部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dept", value = "部门对象", dataType = "DeptDO", required = true, paramType = "body"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public void addDept(@RequestBody DeptDO dept){
        deptService.saveDept(dept);
    }

    @PutMapping(value = "/depts")
    @ApiOperation(value = "修改部门", notes = "修改部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dept", value = "部门对象", dataType = "DeptDO", required = true, paramType = "body"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public void changeUnit(@RequestBody DeptDO dept){
        deptService.updateDept(dept);
    }



}
