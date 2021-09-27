package com.cg.healthcaresystem;

import com.cg.healthcaresystem.model.User;
import com.cg.healthcaresystem.service.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HealthCareSystemApplicationTests {

	@Autowired
	private UserService userService;
	@Test
	void contextLoads() {
	}

	@Test
	public void userTest(){
		User user=new  User();
		user.setUsername("Mahesh");
		user.setPassword("1234");
		user.setRole("user");
		assertEquals(user,userService.addUser(user));
	}

}
