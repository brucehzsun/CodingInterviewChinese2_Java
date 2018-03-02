package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _59_01_MaxInSlidingWindow {

    /**
     * 面试题59（一）：滑动窗口的最大值
     * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
     * 例如，如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，
     * 那么一共存在6个滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
     */
    private static int[] maxInWindows(int[] num, int size) {
        if (num == null || num.length == 0 || size == 0) {
            return null;
        }
        if (size > num.length) {
            return null;
        }

        int[] result = new int[num.length - size + 1];
        for (int i = 0; i < result.length; i++) {
            int max = num[i];
            for (int j = i + 1; j < i + size; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            result[i] = max;
        }

        return result;
    }

    private static int max(int i, int i1, int i2) {
        int max = i;
        if (i1 > i) {
            max = i1;
        }
        if (i2 > i) {
            max = i2;
        }
        return max;
    }


    // ====================测试代码====================

    static void Test(String testName, int[] num, int size, int[] expected) {
        if (testName != null)
            MyUtils.print(testName + " begins: ");

        int[] result = maxInWindows(num, size);

        boolean r = false;
        if (result == null && expected == null) {
            r = true;
        } else if (result.length == 0 && expected.length == 0) {
            r = true;
        } else if (result.length != expected.length) {
            r = false;
        } else {
            r = true;
            for (int i = 0; i < result.length; i++) {
                if (result[i] != expected[i]) {
                    r = false;
                    break;
                }
            }
        }

        if (r)
            MyUtils.print("Passed.\n");
        else
            MyUtils.print("FAILED.\n");
    }

    static void Test1() {
        int num[] = {2, 3, 4, 2, 6, 2, 5, 1};
        int expected[] = {4, 4, 6, 6, 6, 5};
        int size = 3;

        Test("Test1", num, size, expected);
    }

    static void Test2() {
        int num[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int expected[] = {3, 3, 5, 5, 6, 7};
        int size = 3;

        Test("Test2", num, size, expected);
    }

    // 输入数组单调递增
    static void Test3() {
        int num[] = {1, 3, 5, 7, 9, 11, 13, 15};
        int expected[] = {7, 9, 11, 13, 15};
        int size = 4;

        Test("Test3", num, size, expected);
    }

    // 输入数组单调递减
    static void Test4() {
        int num[] = {16, 14, 12, 10, 8, 6, 4};
        int expected[] = {16, 14, 12};
        int size = 5;

        Test("Test4", num, size, expected);
    }

    // 滑动窗口的大小为1
    static void Test5() {
        int num[] = {10, 14, 12, 11};
        int expected[] = {10, 14, 12, 11};
        int size = 1;

        Test("Test5", num, size, expected);
    }

    // 滑动窗口的大小等于数组的长度
    static void Test6() {
        int num[] = {10, 14, 12, 11};
        int expected[] = {14};
        int size = 4;

        Test("Test6", num, size, expected);
    }

    // 滑动窗口的大小为0
    static void Test7() {
        int num[] = {10, 14, 12, 11};
        int size = 0;

        Test("Test7", num, size, null);
    }

    // 滑动窗口的大小大于输入数组的长度
    static void Test8() {
        int num[] = {10, 14, 12, 11};
        int size = 5;

        Test("Test8", num, size, null);
    }

    // 输入数组为空
    static void Test9() {
        int size = 5;
        Test("Test9", null, size, null);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
        Test8();
        Test9();
    }

}
