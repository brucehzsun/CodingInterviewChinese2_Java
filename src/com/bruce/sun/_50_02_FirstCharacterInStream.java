package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _50_02_FirstCharacterInStream {

    /**
     * 面试题50（二）：字符流中第一个只出现一次的字符
     * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。
     * 当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
     */
    static class CharStatistics {

        int[] hash;
        int index;

        public CharStatistics() {
            // hash[i]: A character with ASCII value i;
            // hash[i] >= 0: The character has been found only once
            // hash[i] = -1: The character has not found;
            // hash[i] = -2: The character has been found for mutlple times

            hash = new int[256];
            for (int i = 0; i < hash.length; i++) {
                hash[i] = -1;
            }
        }

        public Character FirstAppearingOnce() {

            char ch = '\0';
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] >= 0 && hash[i] < minIndex) {
                    ch = (char) i;
                    minIndex = hash[i];
                }
            }
            return ch;
        }

        public void Insert(char c) {
            if (hash[c] == -1) {
                hash[c] = index;
            } else if (hash[c] >= 0) {
                hash[c] = -2;
            }

            index++;
        }
    }


    // ====================测试代码====================
    static void Test(String testName, CharStatistics chars, char expected) {
        if (testName != null)
            MyUtils.print(testName + " begins: ");

        char result = chars.FirstAppearingOnce();
        if (result == expected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("FAILED " + result + ".\n");
    }

    public static void main(String[] args) {
        CharStatistics chars = new CharStatistics();

        Test("Test1", chars, '\0');

        chars.Insert('g');
        Test("Test2", chars, 'g');

        chars.Insert('o');
        Test("Test3", chars, 'g');

        chars.Insert('o');
        Test("Test4", chars, 'g');

        chars.Insert('g');
        Test("Test5", chars, '\0');

        chars.Insert('l');
        Test("Test6", chars, 'l');

        chars.Insert('e');
        Test("Test7", chars, 'l');
    }
}
