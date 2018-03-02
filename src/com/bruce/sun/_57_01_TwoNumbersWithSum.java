package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _57_01_TwoNumbersWithSum {

    /**
     * 面试题57（一）：和为s的两个数字
     * 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
     * 如果有多对数字的和等于s，输出任意一对即可。
     */
    private static boolean FindNumbersWithSum(int[] data, int sum, int[] num1, int[] num2) {
        if (data == null || data.length == 0) return false;
        if (num1 == null || num1.length == 0) return false;
        if (num2 == null || num2.length == 0) return false;

        int startPos = 0;
        int endPos = data.length - 1;
        while (startPos < endPos) {
            int cuSum = data[startPos] + data[endPos];
            if (cuSum == sum) {
                num1[0] = data[startPos];
                num2[0] = data[endPos];
                return true;
            } else if (cuSum > sum) {
                endPos--;
            } else if (cuSum < sum) {
                startPos++;
            }
        }
        return false;
    }


    // ====================测试代码====================
    static void Test(String testName, int data[], int sum, boolean expectedReturn) {
        if (testName != null)
            MyUtils.print(testName + " begins: ");

        int[] num1 = new int[1];
        int[] num2 = new int[1];
        boolean result = FindNumbersWithSum(data, sum, num1, num2);
        if (result == expectedReturn) {
            if (result) {
                if (num1[0] + num2[0] == sum)
                    MyUtils.print("Passed. \n");
                else
                    MyUtils.print("FAILED. \n");
            } else
                MyUtils.print("Passed. \n");
        } else
            MyUtils.print("FAILED. \n");
    }


    // 存在和为s的两个数字，这两个数字位于数组的中间
    static void Test1() {
        int data[] = {1, 2, 4, 7, 11, 15};
        Test("Test1", data, 15, true);
    }

    // 存在和为s的两个数字，这两个数字位于数组的两段
    static void Test2() {
        int data[] = {1, 2, 4, 7, 11, 16};
        Test("Test2", data, 17, true);
    }

    // 不存在和为s的两个数字
    static void Test3() {
        int data[] = {1, 2, 4, 7, 11, 16};
        Test("Test3", data, 10, false);
    }

    // 鲁棒性测试
    static void Test4() {
        Test("Test4", null, 0, false);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
    }

}
