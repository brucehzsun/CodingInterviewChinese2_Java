package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _58_01_ReverseWordsInSentence {


    /**
     * 面试题58（一）：翻转单词顺序
     * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     */
    private static String reverseSentence(String input) {
        if (input == null) return null;
        if (input.length() == 0) return "";

        char[] data = input.toCharArray();
        //反转整个句子
        reverse(data, 0, data.length - 1);

        int startPos = 0;
        int endPos = 0;
        while (startPos < data.length - 1) {
            if (data[startPos] == ' ') {
                //起始位置是空格
                startPos++;
                endPos++;
            } else if (endPos == data.length || data[endPos] == ' ') {
                //结束位置是空格
                reverse(data, startPos, endPos - 1);
                startPos = endPos;
            } else {
                //起始位置和结束位置都不是空格；
                endPos++;
            }
        }


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

    static void Test(String testName, String input, String expectedResult) {
        if (testName != null)
            MyUtils.print(testName + " begins: ");

        String result = reverseSentence(input);

        if ((result == null && expectedResult == null)
                || (result != null && result.equals(expectedResult)))
            MyUtils.print("Passed.\n\n");
        else
            MyUtils.print("Failed.\n\n");
    }

    // 功能测试，句子中有多个单词
    static void Test1() {
        String input = "I am a student.";
        String expected = "student. a am I";

        Test("Test1", input, expected);
    }

    // 功能测试，句子中只有一个单词
    static void Test2() {
        String input = "Wonderful";
        String expected = "Wonderful";

        Test("Test2", input, expected);
    }

    // 鲁棒性测试
    static void Test3() {
        Test("Test3", null, null);
    }

    // 边界值测试，测试空字符串
    static void Test4() {
        Test("Test4", "", "");
    }

    // 边界值测试，字符串中只有空格
    static void Test5() {
        String input = "   ";
        String expected = "   ";
        Test("Test5", input, expected);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
    }
}
