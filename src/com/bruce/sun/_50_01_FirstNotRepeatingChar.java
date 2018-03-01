package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _50_01_FirstNotRepeatingChar {

    /**
     * 面试题50（一）：字符串中第一个只出现一次的字符
     * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
     */
    public static void main(String[] args) {
        String s = "abaccdeff";
        char result = getFirstNotRepeatingChar(s);
        if (result == 'b') {
            MyUtils.print("pass");
        } else {
            MyUtils.print("failed " + result);
        }
    }

    /**
     * 使用hash表查询算法
     * @return
     */
    private static Character getFirstNotRepeatingChar(String s) {
        if (s == null || s.length() == 0) return null;

        int[] hash = new int[256];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 1) {
                return (char) i;
            }
        }
        return null;
    }
}
