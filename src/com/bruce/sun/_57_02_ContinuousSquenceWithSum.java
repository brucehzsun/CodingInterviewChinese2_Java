package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _57_02_ContinuousSquenceWithSum {


    /**
     * 面试题57（二）：为s的连续正数序列
     * 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
     * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
     */
    private static void findContinuousSequence(int sum) {
        if (sum < 3) return;

        int small = 1;
        int big = 2;
        int curSum = small + big;
        int middle = (sum + 1) >> 1;
//        MyUtils.print("中间数 = " + middle + "\n");

        while (small < big && big <= middle) {
            if (curSum == sum) {
                MyUtils.print("找到结果：" + small + " >> " + big + "\n");
                big++;
                curSum += big;
            } else if (curSum < sum) {
                big++;
                curSum += big;
            } else if (curSum > sum) {
                curSum -= small;
                small++;
            }
        }
    }


    // ====================测试代码====================

    static void Test(String testName, int sum) {
        if (testName != null)
            MyUtils.print(testName + " for " + sum + " begins: \n");

        findContinuousSequence(sum);
    }

    public static void main(String[] args) {
//        Test("test1", 1);
        Test("test2", 3);
        Test("test3", 4);
        Test("test4", 9);
        Test("test5", 15);
        Test("test6", 100);
    }

}
