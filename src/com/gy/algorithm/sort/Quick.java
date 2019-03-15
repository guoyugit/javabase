package com.gy.algorithm.sort;

import java.util.Arrays;

/**
 * ClassName: Quick
 * Description:
 * date: 2019/3/11 11:35
 * 原理
 * 分治思想，给定待排序数组a[0…n-1],以a[0]为关键字，
 * 把数组分为a[0…k]和a[k+1…n-1],使得第一个数组中的数都小于a[0]，第二个数组中的数都大于a[0]，重复执行上述过程（递归），即可完成排序。
 * 快速排序的实现和归并排序十分的类似。都是有两个方法完成，快速排序的两个方法一个是完成划分过程，将数组按照某个元素划分成两部分，
 * 左面的都小于这个元素，右面的都大于这个元素，一个是完成递归调用的过程。
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Quick {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 2, 1, 0, 10};
        quick(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /*
    时间复杂度
	最坏情况下，每次划分都只减少一个元素，那么快速排序就退化为了冒泡排序，时间复杂度就是O(N)。
	一般情况下，冒泡排序的时间复杂度是O(n*log(N))。快速排序是最快的排序算法。并不是说时间复杂度小的就一定快，
	时间复杂度只是一种对算法效率的量化，反映了算法运行效率的大体数量级。
    空间复杂度
	需要使用一个长度为log2(N)的栈实现递归。所以时间复杂度就是O(log(N))。
    稳定性
	快速排序是不稳定的。在中枢元素和left指向的元素或者right指向的元素交换时，可能会改变相同元素的相对位置。
     */
    private static void quick(int[] array, int left, int right) {
        if (Utils.isEmptyArray(array)) return;
        if (left < right) {
            int baseIndex = quickSort(array, left, right);
            quick(array, left, baseIndex - 1);
            quick(array, baseIndex + 1, right);
        }

    }

    /*
    返回基准数的下标位置
     */
    private static int quickSort(int[] array, int left, int right) {
        int num = array[left];//获取左部头节点为基准数
        while (left < right) {//获取的最左边的数 需要从最右边开始遍历
            while (left < right && array[right] >= num) right--;//left<right必须要写，避免越界，>= 避免死循环
            array[left] = array[right];
            while (left < right && array[left] <= num) left++;
            array[right] = array[left];
        }
        array[left] = num;
        return left;
    }
}
