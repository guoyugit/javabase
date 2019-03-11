package com.gy.algorithm.sort;

import java.util.Arrays;

/**
 * ClassName: Merge
 * Description:
 * date: 2019/3/11 20:09
 * 原理
 * 归并排序的核心便是分治法思想。
 * 许多的算法在结构上是递归的，为了解决一个给定的问题。算法多次的调用自身，这些算法典型的遵循分治法的思想，
 * 将原问题分解为几个规模较小但是类似于原问题的子问题，递归的求解这些问题。然后合并这些子问题的解来建立原问题的解。
 * 那么归并排序是如何应用分治法思想的呢？
 * 假设待排序数组是a，长度是n，那么把a分成两等份(n是奇数就有一份多一个)，分别对两份进行排序，排序完了之后再合并这两份，
 * 其中每一份在排序的过程中也应用归并排序。以此类推。
 * 在排序的过程中就会不断地进行拆分，直到拆无可拆。然后开始合并。
 * 归并排序需要两个方法：
 * 拆分方法(mergeSort)和合并(merge)方法。
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Merge {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 2, 1, 0, 10};
        merge(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void merge(int[] array, int start, int end) {
        if (Utils.isEmptyArray(array)) return;
        if (start < end) {
            int mid = (start + end) / 2;
            merge(array, start, mid);
            merge(array, mid + 1, end);
            mergeSort(array, start, mid, end);
        }
    }

    private static void mergeSort(int[] array, int start, int mid, int end) {
        int[] tempArr = new int[end - start + 1 + start];//创建与传入数组end值在数组中的位置相同大小的临时数组
        int left = start;
        int right = mid + 1;
        int index = start; //记录当前完成排序的截至位置的索引
        while (left <= mid && right <= end) {
            if (array[left] <= array[right]) {
                tempArr[index++] = array[left++];
            } else {
                tempArr[index++] = array[right++];
            }
        }
        //剩下的值依次放入后续数组中
        while (left <= mid) tempArr[index++] = array[left++];
        while (right <= end) tempArr[index++] = array[right++];
        //拍好序的结果赋给原数组
        for (int i = start; i <= end; i++) {
            array[i] = tempArr[i];
        }
    }
}
