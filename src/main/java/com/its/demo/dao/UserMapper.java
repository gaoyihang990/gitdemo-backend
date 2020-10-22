package com.its.demo.dao;

import com.its.demo.domain.RoleDO;
import com.its.demo.domain.UserDO;
import com.its.demo.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 用户Mapper
 *
 * @author 杨金刚
 * @date 2020/4/22 9:21
 */
@Mapper
@Component(value = "userMapper")
public interface UserMapper {

    UserDO getUserByUsername(String username);

    UserVO getUserVOByUsername(String username);

    List<UserDO> listUsers();

    List<UserVO> listUserinfos(String owner);

    List<UserVO> listAllUserinfos();

    List<UserVO> listUserinfoWhere(UserVO userInfo);

    List<RoleDO> listRoles();

    List<RoleDO> listAllRoles();

    Integer insert(UserDO user);

    Integer update(UserDO user);

    Integer deleteUser(Long id);

    void deleteAll();

    Integer  disable(Long id);

    Integer  enable(Long id);

    String checkPassword(String username);

    void changePassword(@Param("password") String password,
                        @Param("username") String username);

}
