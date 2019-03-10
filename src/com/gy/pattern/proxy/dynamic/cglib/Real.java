package com.gy.pattern.proxy.dynamic.cglib;


public class Real {

    public void removeTopic(int topicId) {
        System.out.println("cglib模拟删除Topic记录:" + topicId);
    }

    public void removeForum(int forumId) {
        System.out.println("cglib模拟删除Forum记录:" + forumId);
    }
}