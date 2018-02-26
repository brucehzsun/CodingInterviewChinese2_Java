package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _15_NumberOf1InBinary {

    public static void main(String[] args) {
        /**
         * 面试题15：二进制中1的个数
         * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
         * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
         */

        int num = numberOf1InBinaray(9);
        int num2 = numberOf1InBinaray2(9);
        if (num == 2 && num2 == 2) {
            MyUtils.print("Passed ! num = " + num);
        } else {
            MyUtils.print("Failed :( num = " + num + ", num2 = " + num2);
        }
    }

    private static int numberOf1InBinaray2(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    private static int numberOf1InBinaray(int num) {
        int flag = 1;
        int count = 0;
        while (flag > 0) {
            if ((num & flag) > 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
