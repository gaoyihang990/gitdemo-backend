package com.its.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.its.demo.domain.RoleDO;
import com.its.demo.domain.RoleVO;
import com.its.demo.service.RoleService;
import com.its.demo.service.UserService;
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
 * @date 2020/5/9 20:40
 */
@RestController
@RequestMapping(value = "api/v1")
@Api(tags = {"用户角色操作接口"})
public class RoleController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/roles")
    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
    @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    public List<RoleDO> listRoles(@RequestHeader String authorization) {
        return roleService.listAllRole();
    }
    @GetMapping(value = "/roles/{keyword}")
    @ApiOperation(value = "模糊检索角色", notes = "按关键字模糊检索角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "关键字", dataType = "String", required = true, paramType = "path"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public List<RoleVO> listRoleVOsByKeyword(@PathVariable String keyword, @RequestHeader String authorization){
        return roleService.listRoleVOsByKeyword(keyword);
    }
    @DeleteMapping(value = "/roles/{id}")
    @ApiOperation(value = "删除角色", notes = "通过ID删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色ID", dataType = "Long", required = true, paramType = "path"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public void removeRole(@PathVariable Long id) {
        roleService.removeRole(id);
    }

    @DeleteMapping(value = "/roles/batch/{ids}")
    @ApiOperation(value = "批量删除角色", notes = "批量删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "角色ID串（逗号分隔）", dataType = "String",  required = true, paramType = "path"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public void batchRemoveRole(@PathVariable String ids) {
        roleService.batchRemoveRole(ids);
    }

    @PostMapping(value = "/roles/exp-excel")
    @ApiOperation(value = "导出角色为Excel", notes = "导出角色为Excel")
    public void expToExcel(HttpServletResponse response) throws IOException {
        List<RoleVO> listRoleVO = roleService.listRoleVOs();

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
//        String fileName = URLEncoder.encode("角色", "UTF-8");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), RoleVO.class).sheet("角色").doWrite(listRoleVO);
    }

    @GetMapping(value = "/roles/validator/role")
    @ApiOperation(value = "检查角色是否存在", notes = "检查给定的角色是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "角色", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public Boolean checkRole(String role) {
        return roleService.isExistingRole(role);
    }

    @PostMapping(value = "/roles")
    @ApiOperation(value = "新增角色", notes = "新增角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "角色对象", dataType = "RoleDO", required = true, paramType = "body"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public void addRole(@RequestBody RoleDO role){
        roleService.saveRole(role);
    }

    @PutMapping(value = "/roles")
    @ApiOperation(value = "修改角色", notes = "修改角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "角色对象", dataType = "RoleDO", required = true, paramType = "body"),
            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
    })
    public void changeUnit(@RequestBody RoleDO role){
        roleService.updateRole(role);
    }

}
    
//    @GetMapping(value = "/roles")
//    @ApiOperation(value = "获取角色列表", notes = "获取角色列表")
//    @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    public List<RoleDO> listRoles(@RequestHeader String authorization) {
//        return userService.listRoles(authorization);
//    }


