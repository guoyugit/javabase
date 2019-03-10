package com.gy.algorithm.sort;

import java.util.Arrays;

/**
 * ClassName: Insert
 * Description:
 * 原理
 * 按照如下的方式进行迭代(假设待排序的数组是a[0…n-1])：
 * 1.初始时，a[0]自成一个有序区，无序区为a[1…n-1] 令i=1
 * 2.将a[i]并入当前的有序区a[0…i-1]形成a[0…i]的有序区
 * 3.i++并且重复第二步  直到i==n-1
 * 我们可以看出插入排序就是一种不断地增加有序区域的排序方法。直到有序区域等于待排序的整个数组，此时就完成了排序的过程。
 * 考虑如何把一个元素插入到合适的位置？
 * 首先，它前面的所有元素一定是排好序的，它需要首先找到比它大的数中最小的那一个，然后那个数到当前元素之间的所有元素都后移，
 * 然后把当前元素赋值到比它大的数中最小的那个数的位置上。这样就完成了元素插入到合适位置的过程。
 * date: 2019/3/10 23:43
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Insert {

    /*
    构成有序区间，依次插入
     */
    public static void insert(int[] a) {
        if (Utils.isEmptyArray(a)) return;
        int temp = 0;
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= a[i - 1]) continue;
            temp = a[i];
            index = i - 1;
            if (a[i] < a[0]) {//比首位元素小时需要直接插入有序数组的头部
                temp = a[i];
                for (int j = i; j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[0] = temp;
                continue;
            }
            while (a[index] > a[i] && index > 0) index--;
            index++;
            for (int j = i; j > index; j--) {
                a[j] = a[j - 1];
            }
            a[index] = temp;
        }
    }

    /*
    优化：只有当遍历值比首位元素小时，index不自增。
     时间复杂度
     外层循环是大约n次，内层最坏情况下长度递增，也是1+2+…+n，也是N^2，所以插入排序最坏情况下的
     时间复杂度是O(N^2)。
     空间复杂度
     插入排序仅仅需要几个临时变量来辅助完成插入排序的过程，所以额外的内存消耗也是常量级的，所以插入排序的时间复杂度是O(N)。
     稳定性
     稳定，一个数只有前面的数比它大，才会向前移动，所以不会改变两个相等元素的相对位置。
     */
    public static void insertAdvance(int[] a) {
        if (Utils.isEmptyArray(a)) return;
        int temp = 0;
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= a[i - 1]) continue;
            temp = a[i];
            index = i - 1;
            while (a[index] > a[i] && index > 0) index--;
            if (index != 0 || (index == 0 && a[0] < a[i]))//当需要插入的位置不为0或者为0但是插入的值大于头部元素 都需要在index++位置插入数据
                index++;
            for (int j = i; j > index; j--) {
                a[j] = a[j - 1];
            }
            a[index] = temp;
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 2, 1, 0, 10};
        insertAdvance(array);
        System.out.println(Arrays.toString(array));
    }
}
