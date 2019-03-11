package com.gy.datastructure.queue;

/**
 * ClassName: PriorityQueue
 * Description:
 * date: 2019/3/11 23:29
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class PriorityQueue {

    private int maxSize;    //队列大小 构造函数中传入
    private long[] queArray;    //保存队列数据的数组
    private int nItems;    //表示当前有效元素的个数

    public PriorityQueue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }


    //插入一个元素
    public void insert(long e) throws Exception {//大数在前，小数在后
        if (nItems == maxSize) return;
        int i;
        for (i = 0; i < nItems; i++) {
            if (e > queArray[i]) {//记录插入值在数组中的插入位置
                break;
            }
        }
        for (int j = nItems; j > i; j--) {//有效数字总数+1，所以此处初始值为有效数字而不是有效数字-1
            queArray[j] = queArray[j - 1];
        }
        queArray[i] = e;
        nItems++;
    }

    //删除一个元素
    public long remove() {//移除最小的数字。
        long temp = queArray[nItems - 1];
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

    public static void main(String[] args) throws Exception {
        PriorityQueue queue = new PriorityQueue(4);
        queue.insert(1);
        queue.insert(3);
        queue.insert(2);
        queue.insert(4);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
        queue.insert(5);
        System.out.println(queue.remove());
    }

}
