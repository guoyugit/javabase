package com.gy.datastructure.stack;

/**
 * ClassName: TestMyStack
 * Description:
 * date: 2019/3/11 21:44
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class TestMyStack {
    public static void main(String[] args) {
        MyStack s = new MyStack(5);
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('d');
        s.push('e');
        s.push('f');
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
