package com.gy.datastructure.queue;

import java.util.Arrays;

/**
 * ClassName: MyQueue
 * Description:
 * date: 2019/3/11 22:31
 * 队列是一种类似栈的数据结构，但是与栈不同的是，队列中第一个插入的元素会被第一个移出。
 * 几种常见操作：
 * 1.Insert	向队尾插入元素
 * 2.Remove	移出队首元素
 * 3.Peek	查看队首元素
 * 队列也可以基于数组实现或者链表实现，我们这里同样使用数组实现。
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class MyQueue {
    private int maxSize;	//队列大小 构造函数中传入
    private long[] queArray;	//保存队列数据的数组
    private int front;	//队首指针 循环队列的构成关键要素
    private int rear;	//队尾指针 循环队列的构成关键要素
    private int nItems;	//表示当前有效元素的个数

    public MyQueue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
        front = 0;
        rear = -1;
    }


    //插入一个元素
    public void insert(long j) throws Exception {
        if(isFull()) {
            throw new Exception("队列元素已满");
        }
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = j;//队尾插入元素，所以队尾指针前进
        nItems++;
    }

    //删除一个元素
    public long remove() {
        long temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }


    //判断是否为空
    public boolean isEmpty() {
        return nItems == 0;
    }


    //判断队列是否已满
    public boolean isFull() {
        return nItems == maxSize;
    }

    //队列元素个数
    public int size() {
        return nItems;
    }

    //查看队首元素
    public long peekFront() {
        return queArray[front];
    }

    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue(4);
        queue.insert(1);
        queue.insert(3);
        queue.insert(2);
        queue.insert(4);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.insert(5);
        System.out.println(queue.remove());
    }
}
