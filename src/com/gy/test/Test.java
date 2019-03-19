package com.gy.test;

import java.io.InputStreamReader;
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

    public static void main(String[] args) throws InterruptedException {

    }

    private static void ab() throws InterruptedException {
        Thread.sleep(1000);
        int[] ints = new int[1024 * 512];
        ab();
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