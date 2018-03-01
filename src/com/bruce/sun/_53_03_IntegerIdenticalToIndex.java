package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _53_03_IntegerIdenticalToIndex {


    /**
     * 面试题53（三）：数组中数值和下标相等的元素
     * 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
     * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
     * 例如，在数组{-3, -1,1, 3, 5}中，数字3和它的下标相等。
     */
    private static int GetNumberSameAsIndex(int[] data) {
        if (data == null || data.length == 0) return -1;

        int start = 0;
        int end = data.length - 1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) >> 1;
            if (data[middle] == middle) {
                return middle;
            } else if (data[middle] > middle) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
    // ====================测试代码====================

    static void Test(String testName, int numbers[], int expected) {
        if (GetNumberSameAsIndex(numbers) == expected)
            MyUtils.print(testName + " passed.\n");
        else
            MyUtils.print(testName + " FAILED.\n");
    }

    static void Test1() {
        int numbers[] = {-3, -1, 1, 3, 5};
        int expected = 3;
        Test("Test1", numbers, expected);
    }

    static void Test2() {
        int numbers[] = {0, 1, 3, 5, 6};
        int expected = 0;
        Test("Test2", numbers, expected);
    }

    static void Test3() {
        int numbers[] = {-1, 0, 1, 2, 4};
        int expected = 4;
        Test("Test3", numbers, expected);
    }

    static void Test4() {
        int numbers[] = {-1, 0, 1, 2, 5};
        int expected = -1;
        Test("Test4", numbers, expected);
    }

    static void Test5() {
        int numbers[] = {0};
        int expected = 0;
        Test("Test5", numbers, expected);
    }

    static void Test6() {
        int numbers[] = {10};
        int expected = -1;
        Test("Test6", numbers, expected);
    }

    static void Test7() {
        Test("Test7", null, -1);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
    }
}
