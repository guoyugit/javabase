package com.gy.algorithm.sort;

import java.util.Arrays;

/**
 * ClassName: Bubble
 * date: 2019/3/10 20:21
 * Description:冒泡排序
 * 原理：
 * 假设有n个数，要对它们进行从小到大的排序，那么首先将最大的数移到最后一个位置，接着把第二大的数移到倒数第二个的位置，
 * 以此类推。那么经过n-1次操作之后，就完成了排序的过程。
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Bubble {

    /*
    从代码可以看出有两层for循环，外层循环n-1次，内层循环次数递减，所以实际操作次数就大致可看成1+2+3+…+n，数量级的角度来看，是n^2，
    所以冒泡排序的时间复杂度是O(N^2)
    仅仅在交换变量的时候需要在内存中创建一个临时变量用于交换，所消耗的空间不随着数据项个数的增多而增多。所以空间复杂度是O(1)
    因为我们每次比较大小时都是用的<或者>号，所以两个数相等时它们的相对位置不会改变，所以冒泡排序是一种稳定的排序算法
     */
    public static void bubble(int[] a) {
        if (Utils.isEmptyArray(a)) return;
        for (int i = 0; i < a.length - 1; i++) {//进行n-1次比较 将最大值往前抛出
            for (int j = 0; j < a.length - i - 1; j++) { //内循环每次需要去掉外循环已经排好序的值
                if (a[j] > a[j + 1]) {
                    Utils.swap(a, j, j + 1);
                }
            }
        }
        System.out.println("排序结束后结果：");
    }

    /*
    思考：如果有一个无序数列（2，1，3，4，5，6，7，8，9，10）从第一次循环交换后的操作，可以说都是没必要的
    指如果存在一层内循环没有发生交换操作即之后的外循环停止
    通过设置一个标记变量，标记数列中的数是否在循环结束前就已经排好序
     */
    public static void bubbleAdvance(int[] a) {
        if (a == null || a.length == 0) return;
        boolean flag = true;//代表需要排序
        for (int i = 0; i < a.length - 1 && flag; i++) {//进行n-1次比较 将最大值往前抛出
            flag = false;//每次循环前默认该循环已经排好序
            for (int j = 0; j < a.length - i - 1; j++) { //内循环每次需要去掉外循环已经排好序的值
                if (a[j] > a[j + 1]) {
                    Utils.swap(a, j, j + 1);
                    if (!flag)
                        flag = true;//存在交换操作，即需要继续排序
                }
            }
        }
        System.out.println("排序结束后结果：");
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 4, 1, 1, 0, 10};
        bubbleAdvance(array);
        System.out.println(Arrays.toString(array));
    }
}
