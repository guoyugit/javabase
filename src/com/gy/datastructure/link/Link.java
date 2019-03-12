package com.gy.datastructure.link;

/**
 * ClassName: Link
 * Description:
 * date: 2019/3/12 7:53
 * 链节点
 * 在链表中，每个数据项都被包含在“链节点“中，一个链节点是某个类的对象，这个类可以叫做Link，
 * 一个链表中有许多类似的链节点，每个Link对象都保存着对下一个链节点的引用，链表本身对象中有一个字段指向对第一个链节点的引用。
 * 在数组中，每一项占有一个特定的位置，这个位置可以使用一个下标号直接访问，它就像一排房子，你可以凭借地址找到其中特定的一间。
 * 在链表中，寻找一个特定元素的唯一方法就是沿着这个元素的链一直向下寻找。
 * 它强调的是链节点之间的关系，而不是链节点的位置。
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Link {
    private float data;
    private Link next;

    public Link(float data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Link{" +
                "data=" + data +
                '}';
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
