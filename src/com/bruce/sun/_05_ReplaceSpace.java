package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _05_ReplaceSpace {

    /**
     * 面试题5：替换空格
     * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
     * 则输出“We%20are%20happy.”。
     */
    public static void main(String[] args) {

        String str = "We are happy";
        String result = replaceSpace(str);
        if ("We%20are%20happy".equals(result)) {
            MyUtils.print("Passed! result = " + result);
        } else {
            MyUtils.print("Failed :( result = " + result);
        }
    }

    private static String replaceSpace(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        //计算空格个数
        char[] chars = str.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }

        //核心代码
        //计算新字符串的长度
        char[] newChars = new char[chars.length + spaceCount * 2];
        int originPos = chars.length - 1;
        int newPos = newChars.length - 1;
        while (originPos <= newPos && originPos >= 0) {
            if (chars[originPos] == ' ') {
                newChars[newPos--] = '0';
                newChars[newPos--] = '2';
                newChars[newPos--] = '%';
            } else {
                newChars[newPos--] = chars[originPos];
            }
            originPos--;
        }
        return new String(newChars);
    }


}
