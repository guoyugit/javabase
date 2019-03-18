package com.gy.datastructure.swordoffer.number;

/**
 * ClassName: UglyNumber
 * Description:把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：
     创建传入数字值大小的数组，数组第一个值为1.每一个丑数都是前面的丑数*2或者*3或者*5得到的。
     创建三个指针分别指向数组中最后一个2，3，5的倍数的位置。
     每次循环过程中计算当前循环中的最小值，并将对应的2或3或5的倍数的指针前进一位。
     构建完丑数数组后返回最后一个值就是所求值。
 * date: 2019/3/16 13:33
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        System.out.println(u.GetUglyNumber_Solution(10));
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 1) return 0;
        int[] result = new int[index];
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;
        result[0] = 1;
        for (int i = 1; i < index; i++) {
            int min = min(result[m2] * 2, result[m3] * 3, result[m5] * 5);
            result[i] = min;
            if (result[m2] * 2 <= min) m2++;
            if (result[m3] * 3 <= min) m3++;
            if (result[m5] * 5 <= min) m5++;

        }
        return result[--index];
    }

    public int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }
}