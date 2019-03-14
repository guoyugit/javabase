package com.gy.datastructure.link;

/**
 * 双端链表
 * 双端链表和传统链表唯一不同的地方就是双端链表增加了对最后一个链节点的引用
 * @author 郭宇
 *
 */
public class FirstLastList {
	
	private Link first;	//指向第一个链节点
	private Link last;	//指向最后一个链节点
	
	public FirstLastList() {
		//完成first和last变量的初始化
		first = null;
		last = null;
	}
	
	//判断链表是否为空
	public boolean isEmpty() {
		return first == null;
	}
	
	//开头插入一个数据
	public void insertFirst(float data) {
		Link link = new Link(data);
		if(isEmpty()) {
			last = link;
		}
		link.setNext(first);
		first = link;
	}
	
	//结尾插入一个数据
	public void insertLast(float data) {
		Link link = new Link(data);
		if(isEmpty()) first = link;
		else last.setNext(link);
		last = link;
	}
	
	//删除开头第一个数据
	public float deleteFirst() {
		float temp = first.getData();
		if(first.getNext() == null) {
			last = null;
		}
		first = first.getNext();
		return temp;
	}
	
}