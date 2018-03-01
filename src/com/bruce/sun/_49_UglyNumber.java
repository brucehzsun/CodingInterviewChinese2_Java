package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;


//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _49_UglyNumber {

    /**
     * 面试题49：丑数
     * 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到大的顺序的第1500个丑数。
     * 例如6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做第一个丑数。
     */
    private static int getUglyNumber(int k) {
        if (k == 0) return 0;


        int[] data = new int[k];
        data[0] = 1;//第一个丑数是1.
        int nextUglyIndex = 1;//下一个丑数的inex；

        int multiply2Pos = 0;
        int multiply3Pos = 0;
        int multiply5Pos = 0;
        while (nextUglyIndex < k) {
            //上一个丑数分别乘以2,3,5.取最小值
            int min = minNum(data[multiply2Pos] * 2, data[multiply3Pos] * 3, data[multiply5Pos] * 5);
            data[nextUglyIndex] = min;

            while (data[multiply2Pos] * 2 <= min) {
                multiply2Pos++;
            }
            while (data[multiply3Pos] * 3 <= min) {
                multiply3Pos++;
            }
            while (data[multiply5Pos] * 5 <= min) {
                multiply5Pos++;
            }
            nextUglyIndex++;
        }

        return data[nextUglyIndex - 1];
    }

    private static int minNum(int i, int i1, int i2) {
        int min = i;
        if (i1 < min) {
            min = i1;
        }
        if (i2 < min) {
            min = i2;
        }
        return min;
    }


    // ====================测试代码====================
    static void Test(int index, int expected) {
        if (getUglyNumber(index) == expected)
            MyUtils.print("passed\n");
        else
            MyUtils.print("failed\n");

    }

    public static void main(String[] args) {
        Test(1, 1);

        Test(2, 2);
        Test(3, 3);
        Test(4, 4);
        Test(5, 5);
        Test(6, 6);
        Test(7, 8);
        Test(8, 9);
        Test(9, 10);
        Test(10, 12);
        Test(11, 15);

        Test(1500, 859963392);

        Test(0, 0);
    }


}
