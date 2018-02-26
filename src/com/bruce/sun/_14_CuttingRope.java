package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _14_CuttingRope {

    public static void main(String[] args) {
        /**
         * 面试题14：剪绳子
         * 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
         * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘积是多少？
         * 例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
         */

        int ropeLength = 8;
        int max = maxProductByDynamicRules(ropeLength);
        if (max == 18) {
            MyUtils.print("Passed! max = " + max + "\n");
        } else {
            MyUtils.print("Failed :( max = " + max + "\n");
        }

        int max2 = maxProductByGreedAlgorithm(ropeLength);
        if (max2 == 18) {
            MyUtils.print("Passed! max = " + max2 + "\n");
        } else {
            MyUtils.print("Failed :( max = " + max2 + "\n");
        }
    }

    /**
     * 动态规则
     *
     * @param length
     * @return
     */
    public static int maxProductByDynamicRules(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int[] results = new int[length + 1];
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;

        int max = 0;
        int temp = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                temp = results[j] * results[i - j];
                if (temp > max) {
                    max = temp;
                }
                results[i] = max;
            }
        }
        return results[length];
    }

    /**
     * 贪婪算法。分割成3*3*3的小段。无法分割的分割成2*2；
     *
     * @param length
     * @return
     */
    public static int maxProductByGreedAlgorithm(int length) {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int timesOf3 = length / 3;
        if (length % 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }
}
