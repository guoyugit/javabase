package com.gy.pattern.proxy.staticproxy;


import com.gy.pattern.proxy.dynamic.cglib.CglibProxy;
import com.gy.pattern.proxy.dynamic.cglib.Real;
import com.gy.pattern.proxy.dynamic.jdk.ForumService;
import com.gy.pattern.proxy.dynamic.jdk.ForumServiceImpl;

public class TestStaticProxy {
    public static void main(String[] args) {
        ForumService fs = new StaticProxy(new ForumServiceImpl());
        fs.removeForum(11);
        fs.removeTopic(12);
    }
}