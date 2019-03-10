package com.gy.pattern.proxy.dynamic.jdk;

public class ForumServiceImpl implements ForumService {

	public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录:"+topicId);
	}

	public void removeForum(int forumId) {
		System.out.println("模拟删除Forum记录:"+forumId);
	}
}