package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _42_GreatestSumOfSubarrays {

    /**
     * 面试题42：连续子数组的最大和
     * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
     * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
     */
    private static int FindGreatestSumOfSubArray(int[] data) {
        if (data == null || data.length == 0) return 0;

        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < data.length; i++) {
            if (currentSum <= 0) {
                currentSum = data[i];
            } else {
                currentSum += data[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    // ====================测试代码====================
    static void Test(String testName, int[] pData, int expected) {
        if (testName != null)
            MyUtils.print(testName + " begins: \n");

        int result = FindGreatestSumOfSubArray(pData);
        if (result == expected)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("Failed.\n");
    }

    // 1, -2, 3, 10, -4, 7, 2, -5
    static void Test1() {
        int data[] = {1, -2, 3, 10, -4, 7, 2, -5};
        Test("Test1", data, 18);
    }

    // 所有数字都是负数
// -2, -8, -1, -5, -9
    static void Test2() {
        int data[] = {-2, -8, -1, -5, -9};
        Test("Test2", data, -1);
    }

    // 所有数字都是正数
// 2, 8, 1, 5, 9
    static void Test3() {
        int data[] = {2, 8, 1, 5, 9};
        Test("Test3", data, 25);
    }

    // 无效输入
    static void Test4() {
        Test("Test4", null, 0);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
    }
}
