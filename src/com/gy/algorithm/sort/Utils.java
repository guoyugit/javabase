package com.gy.algorithm.sort;

/**
 * ClassName: Utils
 * Description:
 * date: 2019/3/10 22:58
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Utils {

    /*
    交换两个值
     */
    public static void swap(int[] array, int pre, int next) {
        int i = array[pre];
        array[pre] = array[next];
        array[next] = i;
    }

    public static boolean isEmptyArray(int[] a) {
        return a == null || a.length == 0;
    }
}
