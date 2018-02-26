package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _21_ReorderArray {

    /**
     * 面试题21：调整数组顺序使奇数位于偶数前面
     * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     */
    private static void ReorderOddEven_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int leftPos = 0;
        int rightPos = nums.length - 1;
        int i = leftPos;
        int j = rightPos;
        while (i < j) {
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            if (i < j) {
                MyUtils.swap(nums, i, j);
            }
        }
    }

    // ====================测试代码====================
    private static void PrintArray(int numbers[]) {
        if (numbers == null || numbers.length <= 0)
            return;

        for (int number : numbers) {
            MyUtils.print(number + "\t");
        }

        MyUtils.print("\n");
    }

    private static void Test(String testName, int numbers[]) {

        if (testName != null)
            MyUtils.print(testName + " begins:\n");

        MyUtils.print("Test for solution 1:\n");
        PrintArray(numbers);
        ReorderOddEven_1(numbers);
        PrintArray(numbers);

//        MyUtils.print("Test for solution 2:\n");
//        PrintArray(copy);
//        ReorderOddEven_2(copy);
//        PrintArray(copy);
    }


    private static void Test1() {
        int numbers[] = {1, 2, 3, 4, 5, 6, 7};
        Test("Test1", numbers);
    }

    private static void Test2() {
        int numbers[] = {2, 4, 6, 1, 3, 5, 7};
        Test("Test2", numbers);
    }

    private static void Test3() {
        int numbers[] = {1, 3, 5, 7, 2, 4, 6};
        Test("Test3", numbers);
    }

    private static void Test4() {
        int numbers[] = {1};
        Test("Test4", numbers);
    }

    private static void Test5() {
        int numbers[] = {2};
        Test("Test5", numbers);
    }

    private static void Test6() {
        Test("Test6", null);
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
