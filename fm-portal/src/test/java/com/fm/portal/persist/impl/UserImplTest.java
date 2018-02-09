package com.fm.portal.persist.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fm.portal.persist.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:*spring-mvc.xml", "classpath:*application-context.xml",
		"classpath:*spring-mybatis.xml", "classpath:*spring-redis.xml" })
public class UserImplTest {

	@Autowired
	UserDao userImpl;

	@Test
	public void test() {
		System.out.println(userImpl.selectListAll());
	}

}
