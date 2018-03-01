package com.fm.control.server;

import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;

public class ChannelSession {

	private static ConcurrentHashMap<String, Channel> sessions;
	private static ChannelSession instance;

	private ChannelSession() {
		sessions = new ConcurrentHashMap<>();
	}

	public static ChannelSession getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (ChannelSession.class) {
			if (instance == null) {
				instance = new ChannelSession();
			}
			return instance;
		}
	}

	// 获取
	public Channel getChannel(String ID) {
		Channel ch = sessions.get(ID);
		return ch;
	}

	// 设置
	public void setChannel(String ID, Channel ch) {
		sessions.put(ID, ch);
	}

	// 移除
	public void removeChannel(String ID) {
		sessions.remove(ID);
	}

	public void printSession() {
		int i = 0;
		for (String key : sessions.keySet()) {
			System.out.println("num:" + i + "    key:" + key + "    channel:" + sessions.get(key));
			i++;
		}
	}

}
