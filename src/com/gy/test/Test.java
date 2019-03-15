package com.gy.test;

import java.util.HashMap;

/**
 * ClassName: Test
 * Description:
 * date: 2019/3/15 20:49
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Test {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(a(t));
    }

    public static int a(int[] array) {
        if (array == null || array.length == 0) return 0;
        HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (a.get(array[i]) == null) {
                a.put(array[i], 1);
            } else {
                a.put(array[i], a.get(array[i]) + 1);
            }
        }
        int flag = array.length / 2;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(array[i]) > flag) {
                return array[i];
            }
        }
        return 0;
    }
}