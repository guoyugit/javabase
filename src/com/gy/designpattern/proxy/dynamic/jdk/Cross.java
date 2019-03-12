package com.gy.designpattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Cross implements InvocationHandler {

    private ForumService fs;

    public Cross(ForumService fs) {
        this.fs = fs;
    }

    //创建代理类
    public ForumService bind() {
        return (ForumService) Proxy.newProxyInstance(
                this.getClass().getClassLoader(), new Class[]{ForumService.class}, this);
    }

    /*
    obj2:传入的参数数组
     */
    public Object invoke(Object arg0, Method method, Object[] obj2) throws Throwable {
        if ("removeForum".equals(method.getName())) {
            System.out.println("代理删除");
        } else {
            return method.invoke(fs, obj2);
        }
        return null;
    }
}