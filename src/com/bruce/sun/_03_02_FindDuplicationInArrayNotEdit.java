package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

public class _03_02_FindDuplicationInArrayNotEdit {

    //==================================================================
    // 《剑指Offer——名企面试官精讲典型编程题》代码
    // 作者：何海涛
    // 翻译：Bruce Sun
    //==================================================================

    /**
     * 面试题3（二）：不修改数组找出重复的数字
     * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
     * 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
     * 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
     * 输出是重复的数字2或者3
     */
    public static void main(String[] args) {

        int[] data = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        int result = findDuplication(data);
        if (result == 2 || result == 3) {
            MyUtils.print("Passed! num = " + result);
        } else {
            MyUtils.print("Failed :(");
        }
    }

    /**
     * 使用辅助空间
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param data
     * @return 找到的重复数字。-1就是没有找到
     */
    private static int findDuplication(int[] data) {
        if (data == null || data.length == 0) {
            return -1;
        }

        int[] map = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            if (map[num] == 1) {
                return num;
            } else {
                map[num]++;
            }
        }

        return -1;
    }

}
