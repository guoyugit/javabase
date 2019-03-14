package com.gy.datastructure.link;


/**
 * 双向链表 链节点 
 *
 */
public class DoubleLink {
	
	public float data;
	public DoubleLink previous;
	public DoubleLink next;
	
	public DoubleLink(float data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Link [data=" + data + "]";
	}
	
}