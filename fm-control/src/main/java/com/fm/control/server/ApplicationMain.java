package com.fm.control.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	private static ApplicationContext atx;

	public static void main(String[] args) {
		atx = new ClassPathXmlApplicationContext("application-context.xml", "spring-mybatis.xml", "spring-redis.xml",
				"spring-netty.xml");
		NettyServer timeServer = atx.getBean(NettyServer.class);
		timeServer.start(8081);
	}

}
