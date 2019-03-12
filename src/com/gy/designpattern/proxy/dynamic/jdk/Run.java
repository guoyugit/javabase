package com.gy.designpattern.proxy.dynamic.jdk;
public class Run {
	public static void main(String[] args) {
		ForumService target = new ForumServiceImpl();
		ForumService f = new Cross(target).bind();
		f.removeForum(20);
		f.removeTopic(30);
//		ForumService fs = new Real();
//		fs.removeForum(1);
//		fs.removeTopic(2);
	}
}