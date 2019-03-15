package com.gy.datastructure.swordoffer.recursion;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 * 1.列出所有字符串用递归求解。
 * 对于n个字符串的排列问题。如果能生成n - 1个元素的全部排列结果，就能生成n个元素的全部排列结果。
 * 2.结果按字典顺序输出，这就用到了强大的TreeSet了，直接排好序。又因为题目中要求返回ArrayList类型，故将TreeSet中元素全部加入ArrayList中
 * @Author: 郭宇
 * @CreateDate: 2019/3/15 16:00
 */
public class StringRescursion {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();//根据返回类型需要
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> res = new TreeSet<String>(); //用于排序输出
        getResult(chars, 0, str.length() - 1, res);
        result.addAll(res);//添加到ArrayList
        return result;
    }

    public void getResult(char[] chars, int start, int end, TreeSet<String> res) {

        if (start == end) {
            res.add(String.valueOf(chars));
        } else {
            for (int i = start; i <= end; i++) {
                if (i != start && chars[i] == chars[start]) continue;
                swap(chars, start, i);//换一位
                getResult(chars, start + 1, end, res);//递归
                swap(chars, start, i);//换回来，保证下次换位是正确的
            }
        }
    }

    public void swap(char[] chars, int a, int b) {
        if (a != b) {//因为会出现原位置与原位置交换，直接空即可
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        StringRescursion test = new StringRescursion();
        ArrayList<String> permutation = test.Permutation(str);
        for (String string : permutation) {
            System.out.println(string);
        }
    }
}