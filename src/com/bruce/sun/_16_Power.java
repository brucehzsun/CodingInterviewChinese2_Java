package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _16_Power {

    /**
     * 面试题16：数值的整数次方
     * 题目：实现函数double Power(double base, int exponent)，求base的exponent次方。
     * 不得使用库函数，同时不需要考虑大数问题。
     */
    public static void main(String[] args) {
        // 底数、指数都为正数
        Test("Test1", 2, 3, 8);

        // 底数为负数、指数为正数
        Test("Test2", -2, 3, -8);

        // 指数为负数
        Test("Test3", 2, -3, 0.125);

        // 指数为0
        Test("Test4", 2, 0, 1);

        // 底数、指数都为0
        Test("Test5", 0, 0, 1);

        // 底数为0、指数为正数
        Test("Test6", 0, 4, 0);

        // 底数为0、指数为负数
        Test("Test7", 0, -4, 0);
    }

    private static double _power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        if (MyUtils.equalDouble(base, 0.0)) return 0.0;

        double result = 1;
        int abs_exponent = exponent > 0 ? exponent : -exponent;
        for (int i = 1; i <= abs_exponent; i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }


    // ====================测试代码====================
    private static void Test(String testName, double base, int exponent, double expectedResult) {
        double result = _power(base, exponent);
        if (MyUtils.equalDouble(result, expectedResult))
            MyUtils.print(testName + " passed \n");
        else
            MyUtils.print(testName + " FAILED \n");
    }


}
