package com.gy.datastructure.link;
/**
 * @Description:
 * 双向链表既可以从头往后遍历，也可以从后往前遍历。原因是双向链表的每个链节点都保留两个引用，一个指向下一个，一个指向上一个。
 * @Author:         郭宇
 * @CreateDate:     2019/3/14 10:18
 */
public class DoubleLinkedList {

	private DoubleLink first;
	private DoubleLink last;	//这里采用双端的方式

	public DoubleLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	//开头插入元素
	public void insertFirst(float data) {
		DoubleLink newLink = new DoubleLink(data);
		if(first == null) {
			last = newLink;
		}else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;

	}

	//结尾插入元素
	public void insertLast(float data) {
		DoubleLink newLink = new DoubleLink(data);
		if(isEmpty()) {
			first = newLink;
		}else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	//开头删除元素
	public DoubleLink deleteFirst() {
		if(isEmpty()) return null;
		DoubleLink temp = first;
		if(first.next == null) {
			last = null;
		}else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}	

}