package com.bruce.sun;

import com.bruce.sun.utils.MyUtils;

//==================================================================
// 《剑指Offer——名企面试官精讲典型编程题》代码
// 作者：何海涛
// 翻译：Bruce Sun
//==================================================================
public class _11_MinNumberInRotatedArray {

    /**
     * 面试题11：旋转数组的最小数字
     * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
     */
    public static void main(String[] args) {
        try {
            int[] data = new int[]{3, 4, 5, 1, 2};
            test(data, 1);

            MyUtils.print("\n");
            int[] data2 = new int[]{1, 0, 1, 1, 1};
            test(data2, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void test(int[] data, int expected) throws Exception {
        int minNum = findMinNumInRotatedArray(data);
        if (minNum == expected) {
            MyUtils.print("Passed! minNum = " + minNum);
        } else {
            MyUtils.print("Failed :( minNum = " + minNum);
        }
    }

    private static int findMinNumInRotatedArray(int[] data) throws Exception {
        if (data == null || data.length == 0) {
            throw new Exception("Invalid params");
        }

        int left = 0;
        int right = data.length - 1;
        int middle;
        while (data[left] >= data[right]) {
            if (right - left == 1) {
                break;
            }

            middle = (left + right) / 2;

            //特殊情况处理：如果left middle right 都相等，则只能顺序排列；
            if (data[left] == data[middle] && data[left] == data[right]) {
                return minInOrder(data, left, right);
            }

            if (data[middle] >= data[left]) {
                left = middle;
            } else if (data[middle] <= data[right]) {
                right = middle;
            }
        }
        return data[right];
    }

    private static int minInOrder(int[] data, int left, int right) {

        int result = data[left];
        for (int i = left + 1; i <= right; i++) {
            if (result > data[i]) {
                result = data[i];
            }
        }
        return result;
    }
}
