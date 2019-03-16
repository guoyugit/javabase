package com.gy.datastructure.swordoffer.number;

/**
 * ClassName: OneAppearTimes
 * Description: 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * date: 2019/3/16 10:10
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class OneAppearTimes {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n < 1) return 0;
        int count = 0;
        int base = 1;
        int round = n;
        while(round > 0){
            int weight = round % 10;//当前round的个位数字
            round /= 10;//当前round的十位数字
            count += round * base;
            if(weight == 1)
                count += (n%base)+1;//原数个位数字+1 最后一次0-9循环出现1的次数
            else if(weight > 1)
                count += base;
            base *= 10;
        }
        return count;
    }
}