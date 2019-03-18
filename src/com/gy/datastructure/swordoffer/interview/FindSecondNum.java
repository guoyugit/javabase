package com.gy.datastructure.swordoffer.interview;

import javax.print.attribute.standard.Fidelity;

/**
 * ClassName: FindSecondNum
 * Description: 查找无序数组中第二大的值
 * 各种条件判断，当数组个数大于2时，记录前两个值比较后的结果，较大的值为max，小的值为 secondMax
 * 遍历数组中剩余值，当大于max时，更换max的值，当小于等于max并大于second值时，替换secondMax的值。
 * date: 2019/3/18 14:42
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class FindSecondNum {

    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 9, 9, 2, 1};
        findSecondNum(arr);
    }

    public static void findSecondNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("输入数组为空");
            return;
        }
        if (arr.length == 1) {
            System.out.println("最大值:" + arr[0] + ",无第二大数");
            return;
        }
        int max = arr[0] > arr[1] ? arr[0] : arr[1];
        int secondMax = arr[0] < arr[1] ? arr[0] : arr[1];
        if (arr.length == 2) {
            System.out.println("最大值:" + max + ",第二大数" + secondMax);
            return;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] <= max && arr[i] > secondMax) {//<=max 当数组中有重复数字时保证第二大数字可以获取
                secondMax = arr[i];
            }
        }
        System.out.println("最大值:" + max + ",第二大数" + secondMax);
    }
}