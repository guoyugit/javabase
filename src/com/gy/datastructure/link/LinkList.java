package com.gy.datastructure.link;

/**
 * ClassName: LinkList
 * Description:
 * date: 2019/3/12 7:58
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class LinkList {
    //链表就是由若干个链节点完成的   链表对象中必须有一个字段指向对第一个链节点的引用
    private Link first;

    public LinkList() {
        first = null;
    }

    //链表首部插入节点
    public void insertFirst(float value) {
        Link link = new Link(value);
        if (first != null)
            link.setNext(first);
        first = link;
    }

    //链表首部删除节点
    public Link deleteFirst() {
        if (isEmpty()) return null;
        //拿到原链表的first节点
        Link oldFirst = first;
        //将原链表的first的next节点设置为first节点
        first = first.getNext();
        //返回原链表的first节点
        return oldFirst;

    }

    public void insertTail(float value) {
        Link newNode = new Link(value);
        if (first == null) {
            first = newNode;
            return;
        }
        Link current = first;
        while (current.getNext() != null) current = current.getNext();
        current.setNext(newNode);

    }

    public Link deleteTail() {
        //第一个节点为空
        if (isEmpty()) return null;
        Link current = first;
        //第二个节点为空
        if (current.getNext() == null) {
            first = null;
            return current;
        }
        while (current.getNext().getNext() != null) current = current.getNext();
        //第三个节点为空
        Link result = current.getNext();
        current.setNext(null);
        return result;
        /*//快慢指针
        Link low = first;
        Link fast = first.getNext();
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            low = low.getNext();
        }
        low.setNext(null);
        return fast;*/
    }

    public boolean isEmpty() {
        return first == null;
    }

    //-------------------------------------------------------------------

    //根据数据项查找某个链节点
    public Link find(float key) {
        Link current = first;
        while (current != null && current.getData() != key) {
            if (current.getNext() == null) return null;//全部遍历完还未找到匹配的节点，直接返回null
            current = current.getNext();
        }
        return current;
    }


    //根据给定数据项删除某个链节点
    public Link delete(float key) {
        Link previous = first;
        Link current = first;
        while (current.getData() != key) {
            if (current.getNext() == null) return null;//全部遍历完还未找到要删除的节点，直接返回
            previous = current;
            current = current.getNext();
        }
        if (current == first) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }
        return current;
    }


    //遍历一遍链表 并且打印
    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();
        Link current = first;
        while (current != null) {
            buffer.append(current.getData() + " ");
            current = current.getNext();
        }

        return buffer.toString();
    }
}
