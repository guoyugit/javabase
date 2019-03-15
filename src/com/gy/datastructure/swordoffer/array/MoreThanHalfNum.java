package com.gy.datastructure.swordoffer.array;

import java.util.HashMap;

/**
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Author: 郭宇
 * @CreateDate: 2019/3/15 20:23
 */
public class MoreThanHalfNum {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) return 0;
        quick(array, 0, array.length - 1);
        return array[array.length / 2];
    }

    public static void quick(int[] array, int start, int end) {
        if (start < end) {
            int baseIndex = quickSort(array, start, end);
            quick(array, start, baseIndex - 1);
            quick(array, baseIndex + 1, end);
        }
    }

    public static int quickSort(int[] array, int start, int end) {
        int base = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= base) end--;
            array[start] = array[end];
            while ((start < end) && array[start] <= base) start++;
            array[end] = array[start];
        }
        array[start] = base;
        return start;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}