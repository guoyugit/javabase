package com.gy.designpattern.proxy.staticproxy;


import com.gy.designpattern.proxy.dynamic.jdk.ForumService;
import com.gy.designpattern.proxy.dynamic.jdk.ForumServiceImpl;

public class TestStaticProxy {
    public static void main(String[] args) {
        ForumService fs = new StaticProxy(new ForumServiceImpl());
        fs.removeForum(11);
        fs.removeTopic(12);
    }
}