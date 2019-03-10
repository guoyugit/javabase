package com.gy.algorithm.sort;

import java.util.Arrays;

/**
 * ClassName: Select
 * Description:选择排序
 * date: 2019/3/10 21:11
 * 假设需要从小到大排列n个数，首先寻找最小的一个数，记录下他的索引，将他和第一个数交换，
 * 然后在剩下的n-1个数中寻找最小的，记录下索引，与第二个数交换，以此类推，经过n-1次操作，排序完成。
 * 和冒泡排序相比的好处：减少了交换的次数，但是比较次数仍然没有减少。
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Select {

    /**
     * 选择最小的值放在每次循环起始位置
     * 交换次数为n，比较次数仍旧是N^2的数量级，所以时间复杂度是O(N^2)。
     * 只需要常数量的额外内存保存min、temp、minIndex三个变量，所以需要的空间复杂度是O(1)。
     * 看一个例子：5、8、5、2、9，第一趟交换第一个5和2会交换，那么两个5的相对位置就发生了改变，所以说选择排序是不稳定的排序算法。
     *
     * @param a
     */
    public static void select(int[] a) {
        if (Utils.isEmptyArray(a)) return;
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            minValue = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minValue) {
                    minIndex = j;
                    minValue = a[j];
                }
            }
            if (i != minIndex) Utils.swap(a, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 4, 1, 1, 0, 10};
        select(array);
        System.out.println(Arrays.toString(array));
    }
}
