package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _10_Fibonacci {

    public static void main(String[] argv) {

        // 面试题10：斐波那契数列
        // 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。

        Test(0, 0);
        Test(1, 1);
        Test(2, 1);
        Test(3, 2);
        Test(4, 3);
        Test(5, 5);
        Test(6, 8);
        Test(7, 13);
        Test(8, 21);
        Test(9, 34);
        Test(10, 55);

        Test(40, 102334155);
    }

    private static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int fib0 = 0;
        int fib1 = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fib0 + fib1;
            fib0 = fib1;
            fib1 = fibN;
        }
        return fibN;
    }

    // ====================测试代码====================
    private static void Test(int n, int expected) {
        if (fibonacci(n) == expected)
            MyUtils.print("test for " + n + " in solution1 passed.\n");
        else
            MyUtils.print("test for " + n + " in solution1 failed.\n");

//        if (Fibonacci_Solution2(n) == expected)
//            MyUtils.print("test for " + n + " in solution1 passed.\n");
//        else
//            MyUtils.print("test for " + n + " in solution1 failed.\n");
//
//        if (Fibonacci_Solution3(n) == expected)
//            MyUtils.print("test for " + n + " in solution1 passed.\n");
//        else
//            MyUtils.print("test for " + n + " in solution1 failed.\n");
    }
}
