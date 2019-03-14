package com.gy.datastructure.recursion;

/**
 * ClassName: TestTriangle
 * Description:
 * date: 2019/3/14 11:32
 * 1/3/6/10/15/21 数字打印规律
 *
 * 30,02-25
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class TestTriangle {
    public static void main(String[] args) {
//        System.out.println(printNumRecursion(1));
//        System.out.println(printNumRecursion(2));
//        System.out.println(printNumRecursion(3));
        System.out.println(printNumRecursion(4));
    }

    private static int printNum(int i) {
        if (i < 1) return i;
        int total = 0;
        while (i > 0) {
            total += i;
            i--;
        }
        return total;
    }

    private static int printNumRecursion(int i) {
        if (i <= 1) return i;
        return i + printNumRecursion(--i);
    }
}