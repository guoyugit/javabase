package com.gy.designpattern.proxy.staticproxy;

import com.gy.designpattern.proxy.dynamic.jdk.ForumService;

import java.lang.reflect.Method;

public class StaticProxy implements ForumService {
    private ForumService fs;

    public StaticProxy(ForumService fs) {
        this.fs = fs;
    }

    @Override
    public void removeTopic(int topicId) {
        System.out.println("检查权限");
        System.out.println("模拟删除Topic记录:" + topicId);
        System.out.println("善后处理");
    }

    @Override
    public void removeForum(int forumId) {
        System.out.println("检查权限");
        System.out.println("模拟删除Forum记录:" + forumId);
        System.out.println("善后处理");
    }
}