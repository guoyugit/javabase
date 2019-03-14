package com.gy.datastructure.link;

/**
 * 有序链表的实现
 * 在某些链表中，需要保持对数据的有效性，具有这个特性的链表叫做”有序链表“。有序链表中，都是按照关键值有序排列的，
   有序链表优于有序数组的地方：
   一是插入速度快，因为不需要元素的移动
   二是链表可以扩展到全部有效的内存，而数组只能局限于一个固定的大小之中。
 */
public class OrderList {

    private Link first;

    public OrderList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 插入新值
     *
     * @param key
     */
    public void insert(int key) {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;
        //找到新值插入的位置
        while (current != null && current.getData() < key) {
            //如果当前值小于key，那么就继续向下遍历
            previous = current;
            current = current.getNext();
        }
        //调整链表中的顺序
        if (previous == null) {
            first = newLink;
        } else
            previous.setNext(newLink);
        newLink.setNext(current);
    }

    public Link find(int key) {
        Link current = first;
        while (current != null && current.getData() != key) {
            current = current.getNext();
        }
        return current;
    }

    public void delete(int key) {
        //调整链表关系，定义两个变量存储前后两个链表相关信息
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getData()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }
    }


    public void display() {
        Link current = first;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }


}