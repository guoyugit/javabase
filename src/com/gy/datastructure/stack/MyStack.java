package com.gy.datastructure.stack;

import java.util.Arrays;

/**
 * ClassName: MyStack
 * Description:
 * date: 2019/3/11 21:40
 * 原理
 * 栈只允许访问一个数据项，即最后一个插入的元素。移除最后一个元素之后才能访问倒数第二个元素，以此类推。
 * 栈是一种后进先出的数据结构。
 * 栈的几种常见操作:
 * Push : 插入一个元素到栈顶
 * Pop	：删除栈顶中的元素
 * Peek ：查看栈顶的元素
 * 要实现一个栈，一般有两种方式：
 * 基于链表实现和基于数组实现。
 * 具体使用哪种方式，视情况而定，
 * 若是栈的最大值确定，那么使用数组实现开销最小，否则使用链表实现，
 * 因为链表适合实现无上限的栈。在这里，我们使用数组来实现一个栈，链表的可自行研究。
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class MyStack {
    char[] stack;
    int size;
    int top = -1;//栈顶指针

    public MyStack(int size) {
        stack = new char[size];
        this.size = size;
    }

    public MyStack() {
        stack = new char[10];
        this.size = 10;
    }

    public void push(char e) {
        if (top == size - 1) {
            size <<= 1;
            stack = Arrays.copyOf(stack, size);
        }
        stack[++top] = e;
    }

    public char pop() {
        if (top < 0) return Character.MIN_VALUE;
        return stack[top--];
    }

    public char peek() {
        if (top < 0) return Character.MIN_VALUE;
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

}
