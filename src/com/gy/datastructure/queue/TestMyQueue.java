package com.gy.datastructure.queue;

/**
 * ClassName: TestMyQueue
 * Description:
 * date: 2019/3/11 22:47
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class TestMyQueue {

    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
