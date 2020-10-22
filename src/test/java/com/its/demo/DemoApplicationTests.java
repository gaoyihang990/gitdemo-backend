package com.its.demo;

import com.its.demo.dao.UserMapper;
import com.its.demo.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void changePassword() {
		String encryptPassword = MD5Util.getMD5Hash("admin", "admin", 2, "hex");
		userMapper.changePassword(encryptPassword, "admin");
	}

}
