package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _38_StringPermutation {

    /**
     * 面试题38：字符串的排列
     * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
     * 例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
     */
    public static void main(String[] args) {
        String s = "abc";
        printPermutation(s);
    }

    private static void printPermutation(String s) {
        if (s == null || s.length() == 0) return;

        char[] chars = s.toCharArray();

        printPermutation(chars, 0);
    }

    private static void printPermutation(char[] chars, int startPos) {

        if (startPos == chars.length - 1) {
            //打印最终结果
            for (char s : chars) {
                MyUtils.print(s + "\t");
            }
            MyUtils.print("\n");
        } else {
            for (int i = startPos; i < chars.length; i++) {
                //置换，使得第一位分别是：a,b,c
                char temp = chars[i];
                chars[i] = chars[startPos];
                chars[startPos] = temp;

                //对后两位按照同样方法处理；
                printPermutation(chars, startPos + 1);

                //换回来，要不a后面就不是b和c了；
                temp = chars[i];
                chars[i] = chars[startPos];
                chars[startPos] = temp;
            }
        }

    }
}
