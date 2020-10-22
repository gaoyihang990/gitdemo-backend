package com.its.demo.controller;

import com.its.demo.domain.DeptDO;
import com.its.demo.domain.UserDO;
import com.its.demo.service.UserService;
import com.its.demo.domain.UserVO;
import com.its.demo.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 杨金刚
 * @date 2020/4/23 9:48
 */
@RestController
@RequestMapping(value = "api/v1")
@Api(tags = {"用户管理操作接口"})
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

//    @GetMapping(value = "/users")
//    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
//    @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    public List<UserDO> listUsers() {
//        return userService.listUserDO();
//    }
//
//    @PostMapping(value = "/users")
//    @ApiOperation(value = "新增用户", notes = "新增用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "user", value = "用户对象", dataType = "UserDO", required = true, paramType = "body"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public UserVO addUser(@RequestBody UserDO user) {
//        return userService.saveUser(user);
//    }
//
//    @DeleteMapping(value = "/users/batch")
//    @ApiOperation(value = "批量删除用户", notes = "批量删除用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "ids", value = "用户ID数组", dataType = "Long", allowMultiple = true, required = true, paramType = "body"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public boolean batchRemoveUser(@RequestBody List<Long> ids) {
//        return userService.batchRemove(ids);
//    }
//
//    @DeleteMapping(value = "/users/{id}")
//    @ApiOperation(value = "删除用户", notes = "删除用户")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Long", required = true, paramType = "path"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public boolean deleteUser(@PathVariable Long id) {
//        return userService.removeUser(id);
//    }
//
//    @GetMapping(value = "/users/details")
//    @ApiOperation(value = "获取用户详细", notes = "获取用户详细信息")
//    @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    public List<UserVO> listUserInfos(@RequestHeader String authorization) {
//        return userService.listUserinfos(authorization);
//    }
//
//    @PostMapping(value = "/users/details")
//    @ApiOperation(value = "用户查询", notes = "用户查询")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userInfo", value = "查询对象", dataType = "UserInfoVO", required = true, paramType = "body"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public List<UserVO> listUserInfosP(@RequestBody UserVO userInfo,
//                                       @RequestHeader String authorization) {
//        return userService.listUserinfoWhere(userInfo, authorization);
//    }
//
//    @GetMapping(value = "/users/dept")
//    @ApiOperation(value = "获取用户部门", notes = "获取用户部门")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "部门ID", dataType = "Long", required = true, paramType = "query"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public DeptDO getDept(Long id) {
//        return deptService.getDeptById(id);
//    }
//
//    @PutMapping(value = "/users/password/initialization/{userId}")
//    @ApiOperation(value = "初始化用户口令", notes = "初始化用户口令")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "Long", required = true, paramType = "path"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public boolean initPassword(@PathVariable Long userId) {
//        return userService.initPassword(userId);
//    }
//
//    @GetMapping(value = "/users/validator/username")
//    @ApiOperation(value = "检查登录名", notes = "检查登录名是否存在")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "登录名", dataType = "String", required = true, paramType = "query"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public boolean checkUsername(String username) {
//        return userService.notExistUsername(username);
//    }
//
//    @GetMapping(value = "/users/validator/old-password")
//    @ApiOperation(value = "检查旧口令", notes = "检查旧口令是否正确")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "password", value = "旧口令", dataType = "String", required = true, paramType = "query"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public boolean checkPassword(String password, @RequestHeader String authorization ) {
//        return userService.checkPassword(password, authorization);
//    }
//
//    @PutMapping(value = "/users/password")
//    @ApiOperation(value = "修改口令", notes = "修改用户口令")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "params", value = "传递的参数", dataType = "Map", required = true, paramType = "body"),
//            @ApiImplicitParam(name = "authorization", value = "令牌", required = true, paramType = "header")
//    })
//    public boolean changePassword(@RequestBody Map params, @RequestHeader String authorization ) {
//        String oldPassword = (String) params.get("oldPassword");
//        String newPassword = (String)params.get("newPassword");
//
//        return userService.changePassword(oldPassword, newPassword, authorization);
//    }

}
