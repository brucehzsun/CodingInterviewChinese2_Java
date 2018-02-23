package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

public class _03_01_FindDuplicationInArray {

    //==================================================================
    // 《剑指Offer——名企面试官精讲典型编程题》代码
    // 作者：何海涛
    // 翻译：Bruce Sun
    //==================================================================

    /**
     * 面试题3（一）：找出数组中重复的数字
     * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
     */

    public static void main(String[] args) {

        int[] data = new int[]{2, 3, 1, 0, 2, 5, 3};
        int result = findDuplication(data);
        if (result == 2 || result == 3) {
            MyUtils.print("Passed! num = " + result);
        } else {
            MyUtils.print("Failed :(");
        }
    }

    /**
     * 1.遍历i == data[i]是否成立，如果成立，继续
     * 2.i != data[i] .判断data[data[i]]是否等于 data[i];如果成立。程序结束。
     * 3.如果不成立：替换data[data[i]] 与data[i];
     *
     * @param data
     * @return 找到的重复数字。-1就是没有找到
     */
    private static int findDuplication(int[] data) {
        if (data == null || data.length == 0) {
            return -1;
        }
        //检查输入是否正确
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0 || data[i] > data.length - 1) {
                return -1;
            }
        }

        //核心代码
        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            while (num != i) {//要一直换下去，直到换到想要的数据。
                if (num == data[num]) {
                    //找到重复数据
                    return num;
                } else {
                    //swap data[data[i]] <--> data[i]
                    int temp = data[num];
                    data[num] = num;
                    data[i] = temp;
                }
            }
        }

        return -1;
    }

}
