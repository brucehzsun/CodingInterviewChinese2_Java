package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _53_02_MissingNumber {


    /**
     * 面试题53（二）：0到n-1中缺失的数字
     * 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
     * 在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     */
    private static int GetMissingNumber(int[] data) {
        if (data == null || data.length == 0) return -1;

        int start = 0;
        int end = data.length - 1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) >> 1;
            if (data[middle] > middle) {
                if (middle == 0 || data[middle - 1] == middle - 1) {
                    return middle;
                } else {
                    end = middle - 1;
                }
            } else {
                start = middle + 1;
            }
        }
        if (start == data.length) {
            return data.length;
        }
        return -1;
    }


    // ====================测试代码====================
    static void Test(String testName, int numbers[], int expected) {
        if (testName != null)
            MyUtils.print(testName + " begins: ");

        int result = GetMissingNumber(numbers);
        if (result == expected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("Failed.\n");
    }

    // 缺失的是第一个数字0
    static void Test1() {
        int numbers[] = {1, 2, 3, 4, 5};
        int expected = 0;
        Test("Test1", numbers, expected);
    }

    // 缺失的是最后一个数字
    static void Test2() {
        int numbers[] = {0, 1, 2, 3, 4};
        int expected = 5;
        Test("Test2", numbers, expected);
    }

    // 缺失的是中间某个数字0
    static void Test3() {
        int numbers[] = {0, 1, 2, 4, 5};
        int expected = 3;
        Test("Test3", numbers, expected);
    }

    // 数组中只有一个数字，缺失的是第一个数字0
    static void Test4() {
        int numbers[] = {1};
        int expected = 0;
        Test("Test4", numbers, expected);
    }

    // 数组中只有一个数字，缺失的是最后一个数字1
    static void Test5() {
        int numbers[] = {0};
        int expected = 1;
        Test("Test5", numbers, expected);
    }

    // 空数组
    static void Test6() {
        int expected = -1;
        Test("Test6", null, expected);
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
