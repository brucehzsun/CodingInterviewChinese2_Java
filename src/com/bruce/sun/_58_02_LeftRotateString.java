package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _58_02_LeftRotateString {

    /**
     * 面试题58（二）：左旋转字符串
     * 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
     */
    private static String leftRotateString(String input, int num) {
        if (input == null || input.length() == 0 || num < 0) return null;
        if (num == 0) return input;

        char[] data = input.toCharArray();

        int startPos = 0;
        int endPos = data.length - 1;
        reverse(data, 0, data.length - 1);

        endPos = endPos - num;
        reverse(data, 0, endPos);

        startPos = endPos + 1;
        endPos = data.length - 1;
        reverse(data, startPos, endPos);

        return new String(data);
    }

    private static void reverse(char[] data, int startPos, int endPos) {
        char temp;
        while (startPos < endPos) {
            temp = data[startPos];
            data[startPos] = data[endPos];
            data[endPos] = temp;

            startPos++;
            endPos--;
        }
    }

    // ====================测试代码====================

    static void Test(String testName, String input, int num, String expectedResult) {
        if (testName != null)
            MyUtils.print(testName + "  begins: ");

        String result = leftRotateString(input, num);

        if ((input == null && expectedResult == null)
                || (result != null && result.equals(expectedResult)))
            MyUtils.print("Passed.\n\n");
        else
            MyUtils.print("Failed.\n\n");
    }

    // 功能测试
    static void Test1() {
        String input = "abcdefg";
        String expected = "cdefgab";

        Test("Test1", input, 2, expected);
    }

    // 边界值测试
    static void Test2() {
        String input = "abcdefg";
        String expected = "bcdefga";

        Test("Test2", input, 1, expected);
    }

    // 边界值测试
    static void Test3() {
        String input = "abcdefg";
        String expected = "gabcdef";

        Test("Test3", input, 6, expected);
    }

    // 鲁棒性测试
    static void Test4() {
        Test("Test4", null, 6, null);
    }

    // 鲁棒性测试
    static void Test5() {
        String input = "abcdefg";
        String expected = "abcdefg";

        Test("Test5", input, 0, expected);
    }

    // 鲁棒性测试
    static void Test6() {
        String input = "abcdefg";
        String expected = "abcdefg";

        Test("Test6", input, 7, expected);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
    }
}
