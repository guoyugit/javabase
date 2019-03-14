package com.gy.datastructure.recursion;

/**
 * ClassName: RecursionOrder
 * Description:递归执行顺序
 * date: 2019/3/14 10:39
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class RecursionOrder {
    public static void main(String[] args) {
        Test(0);
    }

    private static void Test(int i) {
        if (i++ < 100) {
            System.out.println("hello world " + i);
            Test(i);
            System.out.println("hello java " + i);
        }
    }


}